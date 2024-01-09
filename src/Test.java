import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Phaser phaser = new Phaser(3);
        service.submit(new CyclicBarrierPhaser(phaser));
        service.submit(new CyclicBarrierPhaser(phaser));
        service.submit(new CyclicBarrierPhaser(phaser));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+ " , is current running");

        service.shutdown();
    }
}
