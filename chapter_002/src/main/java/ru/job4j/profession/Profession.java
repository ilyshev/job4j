package ru.job4j.profession;

public class Profession {
    public String name;
    public String description;
    public String profession;

    public Profession() {

    }
    public Profession (String name, String profession, String description) {
        this.name = name;
        this.profession = profession;
        this.description = description;
    }
    public String getName() {
        return this.name;
    }

    public String getProfession() {
        return this.profession;
    }

    public String getDescription() {
        return description;
    }
}