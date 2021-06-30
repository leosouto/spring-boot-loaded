package org.dev.application.controller.assembler;

import org.dev.application.controller.CarController;
import org.dev.application.model.Car;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CarModelAssembler implements RepresentationModelAssembler<Car, EntityModel<Car>> {
    @Override
    public EntityModel<Car> toModel(Car car) {
        return EntityModel.of(car,
                linkTo(methodOn(CarController.class).findById(car.getId())).withSelfRel(),
                linkTo(methodOn(CarController.class).findAll()).withRel("cars")
        );
    }
}
