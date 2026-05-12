class Solution {
    public int minimumEffort(int[][] tasks) {
        long min = tasks[0][1];
        long max = 0;
        for(int i = 0; i < tasks.length; i++){
            if(tasks[i][1] > min){
                min = tasks[i][1];
            }
            max += tasks[i][1];
        }
        // when we take a and b that is already took form of the array it become it self elemt 
        // do need to make it like tasks[a][0] - tasks[a][1];
        Arrays.sort(tasks, (a, b) -> {
            int diff1 = a[1] - a[0];
            int diff2 = b[1] - b[0];
            return diff2 - diff1;
        });
        // System.out.println(Arrays.deepToString(tasks));
        long ans = max;
        while (min <= max) {
            long mid = min + (max - min) / 2;
            long currEnergy = mid;
            boolean possible = true;
            for (int[] task : tasks) {
                if (task[1] > currEnergy) {
                    possible = false;
                    break;
                }
                currEnergy -= task[0];
            }
            if (possible) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (int) ans;
    }
}