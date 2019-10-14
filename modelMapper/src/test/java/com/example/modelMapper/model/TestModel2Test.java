package com.example.modelMapper.model;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

import static org.junit.jupiter.api.Assertions.*;

class TestModel2Test {

    @org.junit.jupiter.api.Test
    void main() {

        PropertyMap<TestModel2.Person, TestModel2.PersonDTO> personMap = new PropertyMap<TestModel2.Person, TestModel2.PersonDTO>() {
            protected void configure() {
                map().setStreet(source.getAddress().getStreet());
                map(source.getAddress().city, destination.city);
            }
        };
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(personMap);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        TestModel2.Person person = new TestModel2.Person();
        TestModel2.Address address = new TestModel2.Address();
        address.setCity("aaa");
        address.setStreet("bbb");
        person.setAddress(address);

        TestModel2.PersonDTO dto = modelMapper.map(person, TestModel2.PersonDTO.class);

        System.out.println(dto.toString());

        assert dto.getStreet().equals(person.getAddress().getStreet());
        assert dto.getCity().equals(person.getAddress().getCity());
    }
}