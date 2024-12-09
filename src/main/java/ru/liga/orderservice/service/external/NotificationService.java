package ru.liga.orderservice.service.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.orderservice.dto.Order;

@Slf4j
@Service
public class NotificationService {

    public void notifyUser(Order order) throws InterruptedException {
        Thread.sleep(4000L);
        log.info("Пользователь уведомлен {}", Thread.currentThread().getName());
    }
}
