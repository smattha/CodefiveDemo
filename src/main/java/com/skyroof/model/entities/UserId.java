package com.skyroof.model.entities;

public class UserId {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserId{" +
                "id='" + id + '\'' +
                '}';
    }
}
