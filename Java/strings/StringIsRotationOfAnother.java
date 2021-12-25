package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : dheerajkumar02
 * @date : 23-12-2021
 * @project : data-structure
 */
public class StringIsRotationOfAnother {

    public static boolean isEqual(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        Queue<Character> queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
        for(char c : str1.toCharArray())
            queue1.add(c);
        for(char c : str2.toCharArray())
            queue2.add(c);
        int len = str2.length();
        int i = 0;
        while(i < len){
            i++;
            char c = queue2.peek();
            queue2.remove();
            queue2.add(c);
            if(queue2.equals(queue1)){
                System.out.println(queue1.hashCode() + " " + queue2.hashCode());
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
  //      System.out.println(isEqual("ABCD", "CDAB"));
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list1.add("ABCD");
        list2.add("ABCD");
        System.out.println(list1.equals(list2));
    }
}
