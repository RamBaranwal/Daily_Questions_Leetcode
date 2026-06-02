class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int totalTime = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            for(int j = 0; j < waterStartTime.length; j++){
                // land -> water
                int landFinished = landStartTime[i] + landDuration[i];
                // checking which is greater land slide finised first then water slide start
                int finish1 = Math.max(landFinished, waterStartTime[j]) + waterDuration[j];

                // water -> land
                int waterFinished = waterStartTime[j] + waterDuration[j];
                int finish2 = Math.max(waterFinished, landStartTime[i]) + landDuration[i];

                totalTime = Math.min(totalTime, Math.min(finish1, finish2));
            }
        }
        return totalTime;
    }
}