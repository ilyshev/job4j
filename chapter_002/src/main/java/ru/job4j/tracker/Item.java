package ru.job4j.tracker;

public class Item {
    private String id;
    public String name;
    public String description;
    private long create;

    public Item() {

    }
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }
    public Item(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
