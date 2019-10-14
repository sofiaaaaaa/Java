package com.example.modelMapper.model;

import lombok.Data;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.junit.Assert;
import org.modelmapper.convention.MatchingStrategies;

import javax.print.attribute.standard.Destination;

import static org.junit.Assert.assertEquals;


public class TestModel {

    @Test
    public static void main(String[] args) {
        Order order = new Order();
        Address address = new Address();
        address.setCity("bbb");
        address.setStreet("aaa");
        order.setBillingAddress(address);
        Customer customer = new Customer();
        Name name = new Name();
        customer.setName(name);

        order.setCustomer(customer);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        // Map
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        System.out.println( orderDTO.toString());
        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());

        // modelMapper.createTypeMap(Order.class, OrderDTO.class);
        // modelMapper.addMappings(new OrderMap());
        // modelMapper.validate();



    }

    @Data
    static class Order {
        Customer customer;
        Address billingAddress;
    }

    @Data
    static class Customer {
        Name name;
    }

    @Data
    static class Name {
        String firstName;
        String lastName;
    }

    @Data
    static class Address {
        String street;
        String city;
    }

    @Data
    static class OrderDTO {
        String customerFirstName;
        String customerLastName;
        String billingStreet;
        String billingCity;
    }
}
