package ru.liga.orderservice.service.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.orderservice.model.Order;

@Slf4j
@Service
public class PaymentService {
    public void processPayment(Order order) throws InterruptedException {
        log.info("Начало оплаты заказа {}", order.getProductId());
        Thread.sleep(2000L);
        log.info("Оплата заказа {} завершена", order.getProductId());
    }
}
