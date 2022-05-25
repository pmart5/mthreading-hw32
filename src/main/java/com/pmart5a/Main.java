package com.pmart5a;

import com.pmart5a.myclasses.GroceryStore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    static final int NUMBER_GROCERY_STORE = 3;
    static final int TIMEOUT = 3;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder dailyRevenue = new LongAdder();
        for (int i = 0; i < NUMBER_GROCERY_STORE; i++) {
            new GroceryStore().getCashRegister()
                    .forEach(j -> executorService.submit(() -> dailyRevenue.add(j)));
        }
        executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
        System.out.printf("\nОбщая дневная выручка %s магазинов: %d руб. %d коп.\n", NUMBER_GROCERY_STORE,
                dailyRevenue.sum() / 100, dailyRevenue.sum() % 100);
        executorService.shutdown();
    }
}