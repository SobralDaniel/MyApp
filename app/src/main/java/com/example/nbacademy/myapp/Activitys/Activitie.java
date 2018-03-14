package com.example.nbacademy.myapp.Activitys;

/**
 * Created by nbacademy on 08/03/2018.
 */
public class Activitie  {

    private final ImagesEnum imagesEnum;
    private final double price;
    private final int id;
    private final double ranking;
    private final double duracao;
    private final double hi;
    private final double hf;
    String city;
    String type;
    String name;

    public Activitie(int id, String city, String type, String name, ImagesEnum imagesEnum, double price, double ranking, double duracao, double hi, double hf) {
        this.id = id;
        this.city = city;
        this.type = type;
        this.name = name;
        this.imagesEnum = imagesEnum;
        this.price =  price;
        this.ranking = ranking;
        this.duracao = duracao;
        this.hi = hi;
        this.hf = hf;
    }

    public double getRanking() {
        return ranking;
    }

    public double getDuracao() {
        return duracao;
    }

    public double getHi() {
        return hi;
    }

    public double getHf() {
        return hf;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public ImagesEnum getImagesEnum() {
        return imagesEnum;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }


}
