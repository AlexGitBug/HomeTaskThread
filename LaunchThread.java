package Thread.HomeTask;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class LaunchThread {

    public void LaunchTreadAll() {
        Queue<Crystal> queue = new LinkedBlockingDeque<>();
        AtomicBoolean isNotFull = new AtomicBoolean(true);
        Thread fire = new Thread(new ConsumerFire(queue, 20, "Огня", isNotFull));
        Thread air = new Thread(new ConsumerAir(queue, 20, "Воздуха", isNotFull));
        Thread producer = new Thread(new CrystalProducer(queue, 200));

        producer.start();
        fire.start();
        air.start();

    }
}
