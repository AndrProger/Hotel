package com.example.javaproject.room;

public final class Standard extends Room {
    public Standard(int num, int maxPeople, int countPeople, double price, double min_tern, double max_tern, String status, String entry, String exit) {
        super(num, maxPeople, countPeople, price, min_tern, max_tern, status, entry, exit);
        super.setType("Стандартный");

    }
}
