package Thread.HomeTask;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConsumerAir implements Runnable {

    private final Queue<Crystal> queue;
    private final int capacity;
    private int counter = 0;

    private int countRed = 0;

    private final String name;


    private AtomicBoolean finish;

    public ConsumerAir(Queue<Crystal> queue, int capacity, String name, AtomicBoolean finish) {
        this.queue = queue;
        this.capacity = capacity;
        this.name = name;
        this.finish = finish;
    }

    @Override
    public void run() {
        while (counter < capacity) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    Crystal crystal = queue.peek();
                    if (crystal.getColor() == CrystalColorEnum.WHITE) {
                        queue.poll();
                        counter++;
                        System.out.println("Всего у расы " + getName() + " Белых кристаллов: " + counter);
                    } else if (!queue.isEmpty()) {
                        if (crystal.getColor() == CrystalColorEnum.RED) {
                            queue.poll();
                            countRed++;
                            System.out.println("Всего у расы " + getName() + " Красных кристаллов: " + countRed);
                        }
                    }
                } else {
                    System.out.println("На данный момент отсутствуют кристаллы. Обращайтесь завтра");
                }
                try {
                    queue.wait(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (counter >= capacity) {
                    finish.getAndSet(false);
                }
            }
        }
    }

    public Queue<Crystal> getQueue() {
        return queue;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCountRed() {
        return countRed;
    }

    public void setCountRed(int countRed) {
        this.countRed = countRed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ConsumerAir{" +
                "queue=" + queue +
                ", capacity=" + capacity +
                ", counter=" + counter +
                ", countRed=" + countRed +
                ", name='" + name + '\'' +
                ", finish=" + finish +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerAir that = (ConsumerAir) o;
        return capacity == that.capacity && counter == that.counter && countRed == that.countRed && Objects.equals(queue, that.queue) && Objects.equals(name, that.name) && Objects.equals(finish, that.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queue, capacity, counter, countRed, name, finish);
    }
}