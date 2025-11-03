package ru.liga.orderservice.service.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.liga.orderservice.model.Order;

@Slf4j
@Service
public class VendorService {

    @Async("taskExecutor")
    public void assignVendor(Order order) throws InterruptedException {
        Thread.sleep(5000L);
        log.info("Заказ назначен поставщику {}", Thread.currentThread().getName());
    }
}
