package ru.liga.orderservice.service.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryService {

    public boolean checkProductAvailability(int productId) {
        return true;
    }
}
