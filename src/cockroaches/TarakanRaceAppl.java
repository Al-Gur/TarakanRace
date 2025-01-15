package cockroaches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TarakanRaceAppl {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of tarakans:");
        int nTarakans = Integer.parseInt(reader.readLine());
        Tarakan[] tarakans = new Tarakan[nTarakans];
        Thread[] threads = new Thread[nTarakans];
        System.out.println("Enter the distance:");
        int distance = Integer.parseInt(reader.readLine());
        for (int i = 0; i < nTarakans; i++) {
            tarakans[i] = new Tarakan(i + 1, distance);
            threads[i] = new Thread(tarakans[i]);
            threads[i].start();
        }
        for (int i = 0; i < nTarakans; i++) {
            threads[i].join();
        }
        System.out.println("Congratulations to tarakan #" + Tarakan.winnerNumber + " (winner)");
    }
}
