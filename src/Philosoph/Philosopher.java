package Philosoph;

import java.util.concurrent.Semaphore;

class Philosopher implements Runnable {
    private final int id; // Идентификатор философа
    private final Semaphore[] forks; // Вилки
    private final Semaphore[] eatCounters; // Счетчики приемов пищи

    public Philosopher(int id, Semaphore[] forks, Semaphore[] eatCounters) {
        this.id = id;
        this.forks = forks;
        this.eatCounters = eatCounters;
    }

    @Override
    public void run() {
        int eatCounter = 0; // Счетчик приемов пищи

        while (eatCounter < 3) { // Пока не достигнуто ограничение на количество приемов пищи
            try {
                System.out.println("Философ " + id + " размышляет");
                Thread.sleep((long) (Math.random() * 1000)); // Время на размышление

                // Захват левой вилки
                forks[id].acquire();
                System.out.println("Философ " + id + " взял левую вилку");

                // Захват правой вилки
                int rightForkId = (id + 1) % forks.length; // Индекс правой вилки
                forks[rightForkId].acquire();
                System.out.println("Философ " + id + " взял правую вилку и начинает есть");

                Thread.sleep((long) (Math.random() * 1000)); // Время на прием пищи

                // Освобождение вилок после приема пищи
                forks[rightForkId].release();
                forks[id].release();
                System.out.println("Философ " + id + " закончил есть и положил вилки на стол");

                eatCounters[id].acquire(); // Уменьшение счетчика приемов пищи для текущего философа
                eatCounter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}