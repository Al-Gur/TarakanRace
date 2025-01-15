package cockroaches;

import java.util.Random;

public class Tarakan implements Runnable {
    static int winnerNumber;

    private int number;
    private int remainingDistance;

    public Tarakan(int number, int remainingDistance) {
        this.number = number;
        this.remainingDistance = remainingDistance;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (remainingDistance > 0) {
            System.out.println("Tarakan #" + number + ": distance of " + remainingDistance + " remains");
            try {
                int delay = random.nextInt(4) + 2;
                System.out.println("#"+number+": "+delay);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            remainingDistance--;
        }
        System.out.println("Tarakan #" + number + " finished");
        if (winnerNumber == 0) {
            winnerNumber = number;
        }

    }
}
