import java.util.concurrent.Phaser;

public class CyclicBarrierPhaser implements Runnable {
    private final Phaser phaser;
    public  CyclicBarrierPhaser(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        while (true){
            phaser.arriveAndAwaitAdvance(); // similar to barrier.await()
        }
    }
}
