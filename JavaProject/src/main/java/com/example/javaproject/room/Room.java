package com.example.javaproject.room;

import java.util.Objects;

public class Room {
    private int id;
    private String type;
    private int num;
    private int maxPeople;
    private int countPeople;
    private double price;
    private double min_tern;
    private double max_tern;
    private String status;
    private String entry;
    private String exit;

    public Room( int num, int maxPeople, int countPeople, double price, double min_tern, double max_tern, String status, String entry, String exit) {
        this.type = "none";
        this.num = num;
        this.maxPeople = maxPeople;
        this.countPeople = countPeople;
        this.price = price;
        this.min_tern = min_tern;
        this.max_tern = max_tern;
        this.status = status;
        this.entry = entry;
        this.exit = exit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMin_tern() {
        return min_tern;
    }

    public void setMin_tern(double min_tern) {
        this.min_tern = min_tern;
    }

    public double getMax_tern() {
        return max_tern;
    }

    public void setMax_tern(double max_tern) {
        this.max_tern = max_tern;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && num == room.num && maxPeople == room.maxPeople && countPeople == room.countPeople && Double.compare(room.price, price) == 0 && Double.compare(room.min_tern, min_tern) == 0 && Double.compare(room.max_tern, max_tern) == 0 && Objects.equals(type, room.type) && Objects.equals(status, room.status) && Objects.equals(entry, room.entry) && Objects.equals(exit, room.exit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, num, maxPeople, countPeople, price, min_tern, max_tern, status, entry, exit);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", num=" + num +
                ", maxPeople=" + maxPeople +
                ", countPeople=" + countPeople +
                ", price=" + price +
                ", min_tern=" + min_tern +
                ", max_tern=" + max_tern +
                ", status='" + status + '\'' +
                ", entry='" + entry + '\'' +
                ", exit='" + exit + '\'' +
                '}';
    }
}
