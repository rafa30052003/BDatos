package com.iesfranciscodelosrios.bdatos_alejandrogalvez_rafalucena;

public class Artist {
    private String id;
    private String name;
    private String genre;
    private double age;

    public Artist(String id, String name, String genre, double age) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.age = age;
    }

    public Artist() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
