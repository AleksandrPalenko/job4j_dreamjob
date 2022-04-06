package ru.job4j.job;

import java.util.Objects;

public class Hr {

    String name;
    int id;

    public Hr(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hr hr = (Hr) o;
        return id == hr.id && Objects.equals(name, hr.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
