package com.example.modelMapper.model;

import lombok.Data;
import org.modelmapper.ModelMapper;

public class TestModel3 {
    @Data
    public static class OrderInfo {
        private String customerName;
        private String streetAddress;

        // Assume getters and setters
    }

    @Data
    public static class Order {
        private Customer customer;
        private Address address;
    }
    @Data
    public static class Customer {
        private String name;
    }
    @Data
    public static class Address {
        private String street;
    }

    public static void main(String[] args) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCustomerName("name");
        orderInfo.setStreetAddress("111");
        ModelMapper modelMapper = new ModelMapper();
        Order order = modelMapper.map(orderInfo, Order.class);

        System.out.println(order.toString());


    }

}
