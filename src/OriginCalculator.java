import java.util.ArrayList;
import java.util.Arrays;

public class OriginCalculator {
    int[][] get2DMatrix(ArrayList<ArrayList<Integer>> sensorLocation) {
        int[][] arr = new int[100][100];
        Arrays.fill(arr, 0);

        ArrayList<Integer[]> tempList = new ArrayList<>();
        for (ArrayList<Integer> intList : sensorLocation){
            tempList.add((Integer [])intList.toArray());
        }

        //Convert to array of arrays - 2D array
        int [][]list = (int[][])tempList.toArray();

        for(int i = 0; i < list.length; i++) {
            arr[list[i][0]][list[i][0]] = 1;
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
