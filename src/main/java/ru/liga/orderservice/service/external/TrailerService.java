package ru.liga.orderservice.service.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.liga.orderservice.model.Order;

@Slf4j
@Service
public class TrailerService {

    @Async("taskExecutor")
    public void assignTrailerAndDispatch(Order order) throws InterruptedException {
        Thread.sleep(3000L);
        log.info("Назначен трейлер и заказ отправлен {}", Thread.currentThread().getName());
    }
}
