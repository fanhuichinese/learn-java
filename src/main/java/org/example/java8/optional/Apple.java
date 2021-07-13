package org.example.java8.optional;

import java.util.Objects;

public class Apple {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(name, apple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Apple(String name) {
        this.name = name;
    }

    public Apple() {

    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }
}
