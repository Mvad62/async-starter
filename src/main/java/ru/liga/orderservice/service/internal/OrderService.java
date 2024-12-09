package ru.liga.orderservice.service.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.orderservice.model.Order;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public void processOrder(Order order) throws InterruptedException {
        if (inventoryService.checkProductAvailability(order.getProductId())) {
            order.setTrackingId(UUID.randomUUID().toString());
            paymentService.processPayment(order);
        } else {
            throw new RuntimeException("Техническая ошибка, повторите попытку");
        }
    }
}