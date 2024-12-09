package ru.liga.orderservice.service.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.orderservice.dto.Order;

@Slf4j
@Service
public class DeliveryService {

    public void assignDeliveryPartner(Order order) throws InterruptedException {
        Thread.sleep(10000L);
        log.info("Назначен партнер по доставке {}", Thread.currentThread().getName());
    }
}
