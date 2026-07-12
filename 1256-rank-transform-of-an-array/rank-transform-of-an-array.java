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

        // int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sortMap.get(arr[i]);
        }
        return arr;
    }
}