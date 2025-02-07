package com.nera.now.singleton;

import org.springframework.stereotype.Component;

@Component
public class StatefulService {
    public int order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        return price;
    }
}
