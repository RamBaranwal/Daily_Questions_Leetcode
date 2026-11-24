class ProductOfNumbers {
    int size;
    ArrayList<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        size = 0;
    }
    
    public void add(int num) {
        list.add(num);
        size++;
    }
    
    public int getProduct(int k) {
        if(k > size){
            return -1;
        }
        int mul = 1;
        int temp = size - 1;
        while(k > 0){
            mul *= list.get(temp);
            temp--;
            k--;
        }
        return mul;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */