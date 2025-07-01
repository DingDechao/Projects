package com.ddc.projects.java11.mapstruct.mapper;

import com.ddc.projects.java11.mapstruct.entities.Car;
import com.ddc.projects.java11.mapstruct.entities.CarDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapperTest {
    @Test
    public void shouldMapCarToDto() {
        //given
        Car car = new Car();
        car.setBrand("BMW");
        car.setName("X5");
        car.setColor("BLUE");

        //when
        CarDTO carDto = CarMapper.INSTANCE.carToCarDto(car);

        //then
        assertNotNull(carDto);
        assertTrue(carDto.getCarBrand().equals("BMW"));
        assertTrue(carDto.getCarName().equals("X5"));
        assertTrue(carDto.getCarColor().equals("BLUE"));
    }
}

