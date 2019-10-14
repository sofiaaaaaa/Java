package com.example.modelMapper.model;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

public class TestModel4 {
    @Data
    public static class OrderDTO {
        private String street;
        private String city;

        // Assume getters and setters
    }

    @Data
    public static class Order {
        private Address address;
    }
    @Data
    public static class Address {
        private String street;
        private String city;
        private String city2;
    }

    public static void main(String[] args) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCity("city");
        orderDTO.setStreet("aaa");

        PropertyMap <OrderDTO, Order> orderMap = new PropertyMap<OrderDTO, Order>() {
            protected void configure() {
                map().getAddress().setStreet(source.getStreet());
                map().getAddress().setCity2(source.getCity());
                map().getAddress().setCity("test");
            }
        };
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        modelMapper.addMappings(orderMap);


        Order order = modelMapper.map(orderDTO, Order.class);
        System.out.println(order.toString());

    }

}
