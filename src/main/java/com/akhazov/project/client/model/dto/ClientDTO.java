package com.akhazov.project.client.model.dto;

/**
 * DTO-класс - представление объекта Client в формате Имя, Фамилия
 */
public class ClientDTO {
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
