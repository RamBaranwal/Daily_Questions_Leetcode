class Solution {
    public List<String> letterCombinations(String digits) {
        String[] phone = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
        };
        List<String> list = new ArrayList<>();
        backTracking(list, phone, digits, 0, new StringBuilder());
        return list;
    }
    private void backTracking(List<String> list, String[] phone, String digits, int index, StringBuilder current){
        if(index == digits.length()){
            list.add(current.toString());
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];
        for(char ch : letters.toCharArray()){
            current.append(ch);
            backTracking(list, phone, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}