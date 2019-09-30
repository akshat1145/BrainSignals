import javafx.beans.property.ReadOnlyIntegerWrapper;

import java.util.*;

public class ManualValues {
    public void putValues() {

        Scanner sc = new Scanner(System.in);
        int velocity;
        int num = 5;

        HashMap<Integer, Integer>  sensorTime = new HashMap<>();
        System.out.println("Enter the number of sensors");
        num = sc.nextInt();
        System.out.println("Enter the velocity");
        velocity = sc.nextInt();
        ArrayList<ArrayList<Integer>> sensorLocation = new ArrayList<>();

        for(int i = 0; i < num; i ++) {
            System.out.println("Enter the x %s value" + i);
            int row = sc.nextInt();
            System.out.println("Enter the y %s value" + i);
            int col = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();
            Arrays.asList(row, col);
            sensorLocation.add(list);

            System.out.println("Enter Time %s for each sensor" + i);
            int time = sc.nextInt();
            sensorTime.put((row*100+col), time);

        }

        OriginCalculator originCalculator = new OriginCalculator();

        int[][] arr = originCalculator.get2DMatrix(sensorLocation);
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; i < arr[0].length; j++) {
                if (sensorLocation.contains(Arrays.asList(i, j))) {
                    int dist = originCalculator.calculateDistance(sensorTime.get((i * 100 + j)), velocity);
                    System.out.println(Arrays.deepToString(originCalculator.helper(arr, dist, i, j)));
                }
            }
        }

    }

}
