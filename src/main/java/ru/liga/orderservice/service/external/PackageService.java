package ru.liga.orderservice.service.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.orderservice.model.Order;

@Slf4j
@Service
public class PackageService {

    public void packaging(Order order) throws InterruptedException {
        Thread.sleep(2000L);
        log.info("Упаковка заказа завершена {}", Thread.currentThread().getName());
    }
}
