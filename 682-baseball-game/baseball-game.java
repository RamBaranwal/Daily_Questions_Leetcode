class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < operations.length; i++){
            if(operations[i].equals("D")){
                if(list.size() < 1){
                    return -1;
                }
                list.add(2 * list.get(list.size() - 1));
            }
            else if(operations[i].equals("C")){
                if(list.size() < 1){
                    return -1;
                }
                list.remove(list.size() - 1);
            }
            else if(operations[i].equals("+")){
                if(list.size() < 2){
                    return -1;
                }
                list.add(list.get(list.size() - 2) + list.get(list.size() - 1));
            }
            else{
                list.add(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }

        return sum;
    }
}