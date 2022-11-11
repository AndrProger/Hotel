package com.example.javaproject;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PropertyRoom {
    private SimpleStringProperty type;
    private SimpleIntegerProperty num;
    private SimpleIntegerProperty countPeople;
    private SimpleDoubleProperty price;
    private SimpleDoubleProperty min_tern;
    private SimpleDoubleProperty max_tern;
    private SimpleStringProperty status;
    private SimpleStringProperty entry;
    private SimpleStringProperty exit;
    //☺

    public PropertyRoom(String type, int num, int countPeople, double price, double min_tern, double max_tern, String status, String entry, String exit) {
        this.type=new SimpleStringProperty(type);
        this.num=new SimpleIntegerProperty(num);
        this.countPeople =new SimpleIntegerProperty(countPeople);
        this.price =new SimpleDoubleProperty(price);
        this.min_tern = new SimpleDoubleProperty(min_tern) ;
        this.max_tern = new SimpleDoubleProperty(max_tern);
        this.status = new SimpleStringProperty(status) ;
        this.entry =new SimpleStringProperty(entry) ;
        this.exit =new SimpleStringProperty(exit) ;
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public int getNum() {
        return num.get();
    }

    public SimpleIntegerProperty numProperty() {
        return num;
    }

    public void setNum(int num) {
        this.num.set(num);
    }

    public int getCountPeople() {
        return countPeople.get();
    }

    public SimpleIntegerProperty countPeopleProperty() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople.set(countPeople);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getMin_tern() {
        return min_tern.get();
    }

    public SimpleDoubleProperty min_ternProperty() {
        return min_tern;
    }

    public void setMin_tern(double min_tern) {
        this.min_tern.set(min_tern);
    }

    public double getMax_tern() {
        return max_tern.get();
    }

    public SimpleDoubleProperty max_ternProperty() {
        return max_tern;
    }

    public void setMax_tern(double max_tern) {
        this.max_tern.set(max_tern);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getEntry() {
        return entry.get();
    }

    public SimpleStringProperty entryProperty() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry.set(entry);
    }

    public String getExit() {
        return exit.get();
    }

    public SimpleStringProperty exitProperty() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit.set(exit);
    }
}


