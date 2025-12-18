public class strbuff {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        System.out.println(sb1.append("new line"));
        // this is the way to add the line into strbuff
        System.out.println(sb1.insert(4,"ram "));
        // this is the wa yby which we add the word between the sentence
        System.out.println(sb1.capacity());
        StringBuffer sb = new StringBuffer("navin");
         // sb -> gives size of 16 bytes
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        String s = sb1.toString();  // -> used to change Sb to str
        System.out.println(s.charAt(2));
        System.out.println(sb.indexOf(s));  // not found so giving -1
        System.out.println(sb.append("ram"));
        System.out.println(sb.equals(sb));   // -> true
        System.out.println(sb.equals(sb1));  // -> false
        // we use equals for string and stringbuffer
        System.out.println(sb.hashCode());
        System.out.println(sb.substring(4)); // gives value from the string buffer
        System.out.println(sb.substring(0, 7)); // gives value from strbuff
        System.out.println(sb.toString());
        System.out.println(s);
        System.out.println(sb1.indexOf("ram", 0));
        System.out.println(sb.replace(0,5," rohan "));
        // this is used to replace the string from starting to ending
        System.out.println(sb.delete(2, 6));
        System.out.println(sb.deleteCharAt(sb.length() - 1));
        System.out.println(sb.insert(4,"raja"));
    }
}
