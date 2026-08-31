class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int remove = 0;
        int ope = 0;
        for(int i = 0; i < list.size(); i++){
            if(remove >= arr.length / 2){
                break;
            }
            remove += list.get(i).getValue();
            ope++;
        }
        return ope;
    }
}