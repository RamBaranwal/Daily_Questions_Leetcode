class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        TreeMap<Integer, Integer> sortMap = new TreeMap<>(map);
        int rank = 1;
        for(Integer key : sortMap.keySet()){
            sortMap.put(key, rank++);
        }
        // for(HashMap.Entry<Integer, Integer> entry : sortMap.entrySet()){
        //     System.out.println(entry.getKey() + " -> " + entry.getValue());
        // }
        // return new int[] {0, 0};

        int[][] res = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            res[i][0] = arr[i];
            res[i][1] = sortMap.get(arr[i]);
        }

        int[] last = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            last[i] = res[i][1];
        }
        return last;
    }
}