package com.ddc.projects.mapstruct.mapper;

import com.ddc.projects.mapstruct.entities.Car;
import com.ddc.projects.mapstruct.entities.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "car.brand", target = "carBrand")
    @Mapping(source = "car.name", target = "carName")
    @Mapping(source = "car.color", target = "carColor")
    CarDTO carToCarDto(Car car);

}
