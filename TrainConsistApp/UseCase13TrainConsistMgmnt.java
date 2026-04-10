import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Use Case 13: Performance Comparison (Loops vs Streams)
 * This class compares execution time of loop-based filtering
 * versus stream-based filtering using System.nanoTime().
 *
 * @author Developer
 * @version 13.0
 */
public class UseCase13TrainConsistMgmnt {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC13 Performance Comparison (Loops vs Streams) ");
        System.out.println("===============================================\n");

        // Create large test dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", (int) (Math.random() * 100)));
        }

        // Measure Loop execution time
        long loopStart = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        // Measure Stream execution time
        long streamStart = System.nanoTime();
        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        // Display performance results
        System.out.println("Loop Execution Time (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}