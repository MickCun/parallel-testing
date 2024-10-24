import java.util.Random;
import java.util.concurrent.*;


public class main {
    static long startTime = 0;
    static long endTime = 0;

    private static int[] theList;
//  Generate Numbers
    static {
        theList = new int[999999999];
        Random random = new Random();
        for (int i = 0; i < 999999999; i++) {
            theList[i] = random.nextInt(Integer.MAX_VALUE);
        }
    }

//  Time Function
    public static void time(int status){
        if(status == 0){
            startTime = System.nanoTime();
        }
        if(status == 1){
            endTime = System.nanoTime();
            long duration = (endTime - startTime);
            double durationInSeconds = duration / 1_000_000_000.0;

            System.out.println("Duration: " + durationInSeconds);

            startTime = 0;
            endTime = 0;
        }
    }

// --------------------------------------------------------------------------------------------------------------
//  Code for Single Processor.
    public static void SSP() {
        int total = 0;
        for(int num: theList) {
            total += num;
        }
        System.out.println(total);
    }

// --------------------------------------------------------------------------------------------------------------
//   Code for multi-processor with 2 cores.
    public static void twoCores() {
        //  Data for loop bounds used by the cores.
        int lowerBound1 = 0;
        int upperBound1 = theList.length / 2;
        int lowerBound2 = (theList.length / 2) + 1;
        int upperBound2 = theList.length - 1;

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(() -> MPC1(lowerBound1, upperBound1));
        Future<Integer> future2 = executor.submit(() -> MPC2(lowerBound2, upperBound2));

        executor.shutdown();
        try {
            int result1 = future1.get();
            int result2 = future2.get();
            int totalSum = result1 + result2;

            System.out.println("Total sum: " + totalSum);

            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException | ExecutionException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }
    }

// --------------------------------------------------------------------------------------------------------------
//   Code for multi-processor with 4 cores.

    public static void fourCores() {
        int totalLength = theList.length;
        int chunkSize = totalLength / 4;

        int lowerBound1 = 0;
        int upperBound1 = chunkSize - 1;

        int lowerBound2 = upperBound1 + 1;
        int upperBound2 = lowerBound2 + chunkSize - 1;

        int lowerBound3 = upperBound2 + 1;
        int upperBound3 = lowerBound3 + chunkSize - 1;

        int lowerBound4 = upperBound3 + 1;
        int upperBound4 = totalLength - 1;

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Integer> future1 = executor.submit(() -> MPC1(lowerBound1, upperBound1));
        Future<Integer> future2 = executor.submit(() -> MPC2(lowerBound2, upperBound2));
        Future<Integer> future3 = executor.submit(() -> MPC3(lowerBound3, upperBound3));
        Future<Integer> future4 = executor.submit(() -> MPC4(lowerBound4, upperBound4));

        executor.shutdown();
        try {
            int result1 = future1.get();
            int result2 = future2.get();
            int result3 = future3.get();
            int result4 = future4.get();
            int totalSum = result1 + result2 + result3 + result4;

            System.out.println("Total sum: " + totalSum);

            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException | ExecutionException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }
    }

// --------------------------------------------------------------------------------------------------------------
//   Code for multi-processor with 8 cores.

    public static void eightCores() {
        int totalLength = theList.length;
        int chunkSize = totalLength / 8;

        int lowerBound1 = 0;
        int upperBound1 = chunkSize - 1;

        int lowerBound2 = upperBound1 + 1;
        int upperBound2 = lowerBound2 + chunkSize - 1;

        int lowerBound3 = upperBound2 + 1;
        int upperBound3 = lowerBound3 + chunkSize - 1;

        int lowerBound4 = upperBound3 + 1;
        int upperBound4 = lowerBound4 + chunkSize - 1;

        int lowerBound5 = upperBound4 + 1;
        int upperBound5 = lowerBound5 + chunkSize - 1;

        int lowerBound6 = upperBound5 + 1;
        int upperBound6 = lowerBound6 + chunkSize - 1;

        int lowerBound7 = upperBound6 + 1;
        int upperBound7 = lowerBound7 + chunkSize - 1;

        int lowerBound8 = upperBound7 + 1;
        int upperBound8 = totalLength - 1;

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Integer> future1 = executor.submit(() -> MPC1(lowerBound1, upperBound1));
        Future<Integer> future2 = executor.submit(() -> MPC2(lowerBound2, upperBound2));
        Future<Integer> future3 = executor.submit(() -> MPC3(lowerBound3, upperBound3));
        Future<Integer> future4 = executor.submit(() -> MPC4(lowerBound4, upperBound4));
        Future<Integer> future5 = executor.submit(() -> MPC5(lowerBound5, upperBound5));
        Future<Integer> future6 = executor.submit(() -> MPC6(lowerBound6, upperBound6));
        Future<Integer> future7 = executor.submit(() -> MPC7(lowerBound7, upperBound7));
        Future<Integer> future8 = executor.submit(() -> MPC8(lowerBound8, upperBound8));

        executor.shutdown();
        try {
            int result1 = future1.get();
            int result2 = future2.get();
            int result3 = future3.get();
            int result4 = future4.get();
            int result5 = future5.get();
            int result6 = future6.get();
            int result7 = future7.get();
            int result8 = future8.get();
            int totalSum = result1 + result2 + result3 + result4 + result5 + result6 + result7 + result8;

            System.out.println("Total sum: " + totalSum);

            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException | ExecutionException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }
    }

// --------------------------------------------------------------------------------------------------------------
//   Code for multi-processor with 12 cores.

    public static void twelveCores() {
        int totalLength = theList.length;
        int chunkSize = totalLength / 12;

        // Initialize bounds for each core
        int lowerBound1 = 0;
        int upperBound1 = chunkSize - 1;

        int lowerBound2 = upperBound1 + 1;
        int upperBound2 = lowerBound2 + chunkSize - 1;

        int lowerBound3 = upperBound2 + 1;
        int upperBound3 = lowerBound3 + chunkSize - 1;

        int lowerBound4 = upperBound3 + 1;
        int upperBound4 = lowerBound4 + chunkSize - 1;

        int lowerBound5 = upperBound4 + 1;
        int upperBound5 = lowerBound5 + chunkSize - 1;

        int lowerBound6 = upperBound5 + 1;
        int upperBound6 = lowerBound6 + chunkSize - 1;

        int lowerBound7 = upperBound6 + 1;
        int upperBound7 = lowerBound7 + chunkSize - 1;

        int lowerBound8 = upperBound7 + 1;
        int upperBound8 = lowerBound8 + chunkSize - 1;

        int lowerBound9 = upperBound8 + 1;
        int upperBound9 = lowerBound9 + chunkSize - 1;

        int lowerBound10 = upperBound9 + 1;
        int upperBound10 = lowerBound10 + chunkSize - 1;

        int lowerBound11 = upperBound10 + 1;
        int upperBound11 = lowerBound11 + chunkSize - 1;

        int lowerBound12 = upperBound11 + 1;
        int upperBound12 = totalLength - 1;


        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Integer> future1 = executor.submit(() -> MPC1(lowerBound1, upperBound1));
        Future<Integer> future2 = executor.submit(() -> MPC2(lowerBound2, upperBound2));
        Future<Integer> future3 = executor.submit(() -> MPC3(lowerBound3, upperBound3));
        Future<Integer> future4 = executor.submit(() -> MPC4(lowerBound4, upperBound4));
        Future<Integer> future5 = executor.submit(() -> MPC5(lowerBound5, upperBound5));
        Future<Integer> future6 = executor.submit(() -> MPC6(lowerBound6, upperBound6));
        Future<Integer> future7 = executor.submit(() -> MPC7(lowerBound7, upperBound7));
        Future<Integer> future8 = executor.submit(() -> MPC8(lowerBound8, upperBound8));
        Future<Integer> future9 = executor.submit(() -> MPC9(lowerBound9, upperBound9));
        Future<Integer> future10 = executor.submit(() -> MPC10(lowerBound10, upperBound10));
        Future<Integer> future11 = executor.submit(() -> MPC11(lowerBound11, upperBound11));
        Future<Integer> future12 = executor.submit(() -> MPC12(lowerBound12, upperBound12));

        executor.shutdown();
        try {
            int result1 = future1.get();
            int result2 = future2.get();
            int result3 = future3.get();
            int result4 = future4.get();
            int result5 = future5.get();
            int result6 = future6.get();
            int result7 = future7.get();
            int result8 = future8.get();
            int result9 = future9.get();
            int result10 = future10.get();
            int result11 = future11.get();
            int result12 = future12.get();
            int totalSum = result1 + result2 + result3 + result4 + result5 + result6 + result7 + result8 + result9 + result10+ result11 + result12;

            System.out.println("Total sum: " + totalSum);

            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException | ExecutionException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }
    }

    public static int MPC1(int lowerBound1, int upperBound1){
        int total = 0;
        for (int i = lowerBound1; i <= upperBound1; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC2(int lowerBound2, int upperBound2){
        int total = 0;
        for (int i = lowerBound2; i <= upperBound2; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC3(int lowerBound3, int upperBound3){
        int total = 0;
        for (int i = lowerBound3; i <= upperBound3; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC4(int lowerBound4, int upperBound4){
        int total = 0;
        for (int i = lowerBound4; i <= upperBound4; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC5(int lowerBound5, int upperBound5){
        int total = 0;
        for (int i = lowerBound5; i <= upperBound5; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC6(int lowerBound6, int upperBound6){
        int total = 0;
        for (int i = lowerBound6; i <= upperBound6; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC7(int lowerBound7, int upperBound7){
        int total = 0;
        for (int i = lowerBound7; i <= upperBound7; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC8(int lowerBound8, int upperBound8){
        int total = 0;
        for (int i = lowerBound8; i <= upperBound8; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC9(int lowerBound9, int upperBound9){
        int total = 0;
        for (int i = lowerBound9; i <= upperBound9; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC10(int lowerBound10, int upperBound10){
        int total = 0;
        for (int i = lowerBound10; i <= upperBound10; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC11(int lowerBound11, int upperBound11){
        int total = 0;
        for (int i = lowerBound11; i <= upperBound11; i++) {
            total += theList[i];
        }
        return total;
    }

    public static int MPC12(int lowerBound12, int upperBound12){
        int total = 0;
        for (int i = lowerBound12; i <= upperBound12; i++) {
            total += theList[i];
        }
        return total;
    }

    public static void main(String[] args) {
//      Test 1 mimics a single processor.
        System.out.println("Test for Single Core: ");
//        time(0);
//        SSP();
//        time(1);

        System.out.println("\nTime for Dual Cores: ");
        time(0);
        twoCores();
        time(1);

        System.out.println("\nTime for Four Cores: ");
        time(0);
        fourCores();
        time(1);

        System.out.println("\nTime for Eight Cores: ");
        time(0);
        eightCores();
        time(1);

        System.out.println("\nTime for Twelve Cores: ");
        time(0);
        twelveCores();
        time(1);
    }
}
