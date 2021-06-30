package org.dev.application.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car_type")
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarType carType = (CarType) o;
        return Objects.equals(id, carType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
