package org.example.java8.optional;

public class Banana {

    private String name;

    public Banana(String name) {
        this.name = name;
    }

    public Banana() {
    }

    @Override
    public String toString() {
        return "Banana{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
