package ru.job4j.job;

import java.util.Objects;

public class Сandidate {

    String name;
    int id;

    public Сandidate(String name, int id) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Сandidate сandidate = (Сandidate) o;
        return id == сandidate.id && Objects.equals(name, сandidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
