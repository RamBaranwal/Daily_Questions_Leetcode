class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0; 
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < nums1.length  && j < nums2.length){
            if(nums1[i] == nums2[j]){
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int k = entry.getValue();
            while(k > 0){
                list.add(entry.getKey());
                k--;
            }
        }

        int[] arr = list.stream()
               .mapToInt(Integer::intValue)
               .toArray();

        return arr;
    }
}