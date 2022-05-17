package com.pmart5a.myclasses;

import java.util.ArrayList;
import java.util.Random;

public class GroceryStore {

    static final int MAX_NUMBER_OF_BUYERS = 201;
    static final int MAX_PURCHASE_AMOUNT = 500000;
    private final ArrayList<Integer> cashRegister = new ArrayList<>();

    public GroceryStore() {
        for (int i = 0; i < getRandomNumberOfBuyers(); i++) {
            cashRegister.add(sell());
        }
    }

    public ArrayList<Integer> getCashRegister() {
        return cashRegister;
    }

    public int getRandomNumberOfBuyers() {
        return new Random().nextInt(MAX_NUMBER_OF_BUYERS);
    }

    public Integer sell() {
        return new Random().nextInt(MAX_PURCHASE_AMOUNT) + 1;
    }
}