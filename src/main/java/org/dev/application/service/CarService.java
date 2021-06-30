package org.dev.application.service;

import org.dev.application.model.Car;
import org.dev.application.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Optional<Car> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Car> findAll() {
        return repository.findAll();
    }
}
