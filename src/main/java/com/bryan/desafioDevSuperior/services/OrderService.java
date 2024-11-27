package com.bryan.desafioDevSuperior.services;

import com.bryan.desafioDevSuperior.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    public double total(Order order){
        double discountAmount = order.getBasic() * (order.getDiscount() / 100);

        double basicPriceWithDisconut = order.getBasic() - discountAmount;

        order.setBasic(basicPriceWithDisconut);

        return shippingService.shipment(order);
    }
}
