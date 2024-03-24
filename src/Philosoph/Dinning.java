package Philosoph;

import java.util.concurrent.Semaphore;

public class Dinning {
    private static final int NUM_PHILOSOPHERS = 5; // Количество философов
    private static final int EAT_LIMIT = 3; // Ограничение на количество приемов пищи

    public static void main(String[] args) {
        // Создаем семафоры для каждой вилки
        Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1); // Изначально каждая вилка доступна
        }

        // Создаем семафоры для ограничения на количество приемов пищи
        Semaphore[] eatCounters = new Semaphore[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            eatCounters[i] = new Semaphore(EAT_LIMIT); // Философ может есть EAT_LIMIT раз
        }

        // Создаем потоки для каждого философа
        Thread[] philosophers = new Thread[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Thread(new Philosopher(i, forks, eatCounters));
        }

        // Запускаем потоки
        for (Thread philosopher : philosophers) {
            philosopher.start();
        }

        // Ждем завершения всех потоков
        for (Thread philosopher : philosophers) {
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}