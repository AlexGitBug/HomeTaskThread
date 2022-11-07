package Thread.HomeTask;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConsumerFire extends ConsumerAir {
    public ConsumerFire(Queue<Crystal> queue, int capacity, String name, AtomicBoolean finish) {
        super(queue, capacity, name, finish);
    }


}

//    private final Queue<Crystal> queue;
//    private final int capacity;
//    private int counter = 0;
//
//    private int countWhite;
//    private final String name;
//
//
//    private AtomicBoolean finish;
//
//    public ConsumerRed(Queue<Crystal> queue, int capacity, String name, AtomicBoolean finish) {
//        this.queue = queue;
//        this.capacity = capacity;
//
//        this.name = name;
//        this.finish = finish;
//    }
//
//    @Override
//    public void run() {
//        while (counter < capacity) {
//            synchronized (queue) {
//                if (!queue.isEmpty()) {
//                    Crystal crystal = queue.peek();
//                    if (crystal.getColor() == CrystalColorEnum.RED) {
//                        queue.poll();
//                        counter++;
//                        System.out.println("Всего у расы " + getName() + " Красных кристаллов: " + counter);
//                    } else if (!queue.isEmpty()) {
//                        if (crystal.getColor() == CrystalColorEnum.WHITE) {
//                            queue.poll();
//                            countWhite++;
//                            System.out.println("Всего у расы " + getName() + " Белых кристаллов: " + countWhite);
//                        }
//                    }
//                } else {
//                    System.out.println("На данный момент отсутствуют кристаллы. Обращайтесь завтра");
//                }
//
//                try {
//                    queue.wait(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                if (counter >= capacity) {
//                    finish.getAndSet(false);
//                }
//            }
//        }
//        System.out.println("+++++++++++++++++++++++++++Раса Огня++++++++++++++++++++++++++++++++++++");
//    }
//
//    public String getName() {
//        return name;
//    }
//}