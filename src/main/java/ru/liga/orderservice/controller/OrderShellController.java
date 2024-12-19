package ru.liga.orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.liga.orderservice.model.Order;
import ru.liga.orderservice.service.external.DeliveryService;
import ru.liga.orderservice.service.external.NotificationService;
import ru.liga.orderservice.service.external.PackageService;
import ru.liga.orderservice.service.external.TrailerService;
import ru.liga.orderservice.service.external.VendorService;
import ru.liga.orderservice.service.internal.OrderService;

@ShellComponent
@RequiredArgsConstructor
public class OrderShellController {

    private final OrderService orderService;
    private final NotificationService notificationService;
    private final VendorService vendorService;
    private final PackageService packageService;
    private final DeliveryService deliveryService;
    private final TrailerService trailerService;

    @ShellMethod("создать заказ")
    public String create(@ShellOption(value = "--jsonOrder") String jsonOrder) throws InterruptedException, JsonProcessingException {
        Order order = new ObjectMapper().readValue(jsonOrder, Order.class);
        orderService.processOrder(order);
        notificationService.notifyUser(order);
        vendorService.assignVendor(order);
        packageService.packaging(order);
        deliveryService.assignDeliveryPartner(order);
        trailerService.assignTrailerAndDispatch(order);

        return "Заказ успешно создан! Трек-номер: %s".formatted(order.getTrackingId());
    }
}