import java.util.Arrays;
import java.util.Scanner;

public class BrainSignals {

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello!!");
        int velocity;
        int num = 5;
        int[] time = new int[num];
        int[][] sensorLocation = new int[num][2];
        System.out.println("enter 1 || 2");
        if(sc.nextInt() == 1) {
            time[0] = 10;
            time[1] = 1;
            time[2] = 2;
            time[3] = 3;
            time[4] = 4;

            velocity = 1;
            //num = 5;

            sensorLocation[0][1] = 0;
           //todo add sensor values

        } else {
        ManualValues manualValues = new ManualValues();
        manualValues.putValues();
        }
        int dist = calculateDistance(time, velocity);
        int[][] arr = get2DMatrix(sensorLocation);
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; i < arr[0].length; j++) {
                if (arr[i][j] == 1)
                    helper(arr, speed, i, j);
            }
        }
    }

    int[][] get2DMatrix(int[][] sensorLocation) {
        int[][] arr = new int[100][100];
        Arrays.fill(arr, 0);
        for(int i = 0; i < sensorLocation.length; i ++) {
            int row = sensorLocation[i][0];
            int col = sensorLocation[i][1];
            arr[row][col] = 1;
        }
        return arr;
    }

    int calculateDistance(int timeHere, int velocityHere) {
        return timeHere * velocityHere;
    }

    int[][] helper(int[][] arr, int distance, int i, int j) {
        int loc[][] = {{0, 0}};
        if(arr == null || distance > arr.length || distance > arr[0].length)
            return loc;
        int max = 1;
        //int[][] loc = new int[0][2];
        while(i - distance >= 0 && i + distance < arr.length && j - distance >= 0 && j + distance < arr[1].length) {
            int mini = Math.max(0, i - distance);
            int maxi = Math.min(arr.length, i + distance);
            int minj = Math.max(0, j - distance);
            int maxj = Math.min(arr[0].length, j + distance);
            for(int k = mini; k < maxi; k++) {
                for(int l = minj; l < maxj; l++) {
                    int sq = (k-i)*(k-i) + (l-j)*(l-j);
                    if(sq <= distance*distance) {
                        arr[k][l] += Math.min(arr[k][l], 1);
                    }
                    if(arr[k][l] > max) {
                        max = arr[k][l];
                        loc[0][0] = k;
                        loc[0][1] = l;
                    }
                }
            }
        }
        return loc;
        }
}

