package org.dev.application.controller;

import org.dev.application.controller.assembler.CarModelAssembler;
import org.dev.application.controller.exception.ResourceNotFoundException;
import org.dev.application.model.Car;
import org.dev.application.service.CarService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/cars")
public class CarController {
    private final CarService service;
    private final CarModelAssembler assembler;

    public CarController(CarService service, CarModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("/{id}")
    public EntityModel<Car> findById(@PathVariable Integer id) {
        return assembler.toModel(service.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    @GetMapping
    public CollectionModel<EntityModel<Car>> findAll() {
        List<EntityModel<Car>> cars = service.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(cars, linkTo(methodOn(CarController.class).findAll()).withSelfRel());
    }
}
