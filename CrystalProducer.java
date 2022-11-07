package Thread.HomeTask;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class CrystalProducer implements Runnable {
    private final Queue<Crystal> queue;
    private final int maxCrystals;
    private int counter = 0;

    public CrystalProducer(Queue<Crystal> queue, int maxCrystals) {
        this.queue = queue;
        this.maxCrystals = maxCrystals;
    }


    @Override
    public void run() {
        while (counter < maxCrystals) {
            synchronized (queue) {

                int totalCount = ThreadLocalRandom.current().nextInt(2, 5);
                int redCrystalsCount = ThreadLocalRandom.current().nextInt(0, totalCount);

                for (int i = 0; i < redCrystalsCount; i++) {
                    queue.offer(new Crystal(CrystalColorEnum.RED));
                    counter++;
                }
                for (int i = 0; i < totalCount - redCrystalsCount; i++) {
                    queue.offer(new Crystal(CrystalColorEnum.WHITE));
                    counter++;
                }
                System.out.println("Произведено красных кристаллов: " + redCrystalsCount + ", "
                        + " произведено белых кристаллов: " + (totalCount - redCrystalsCount) + " , общее число (capacity) = " + counter);

                try {
                    queue.wait(900);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    public Queue<Crystal> getQueue() {
        return queue;
    }

    public int getMaxCrystals() {
        return maxCrystals;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "CrystalProducer{" +
                "queue=" + queue +
                ", maxCrystals=" + maxCrystals +
                ", counter=" + counter +
                '}';
    }
}