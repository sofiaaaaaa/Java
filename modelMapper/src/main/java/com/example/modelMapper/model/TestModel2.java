package com.example.modelMapper.model;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

public class TestModel2 {
    @Data
    public static class Person {
        Address address;
    }

    @Data
    public static class Address {
        String street;
        String city;
    }

    @Data
    public static class PersonDTO {
        String street;
        String city;

        // Assume getters and setters
    }

    public static void main(String[] args) {



    }

}
