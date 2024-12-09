package ru.liga.orderservice.service.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.orderservice.dto.Order;

@Slf4j
@Service
public class TrailerService {

    public void assignTrailerAndDispatch(Order order) throws InterruptedException {
        Thread.sleep(3000L);
        log.info("Назначен трейлер и заказ отправлен {}", Thread.currentThread().getName());
    }
}
