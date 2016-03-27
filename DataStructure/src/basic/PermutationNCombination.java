package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by ivy on 2016/3/26.
 * blog: http://blog.csdn.net/beiyeqingteng/article/details/7051942
 * leetcode answer for combination
 * https://leetcode.com/discuss/86199/java-straight-forward-iteration-method-easy-to-understand
 */
public class PermutationNCombination {
    /**
     * this method can only get the permutation of a input string
     * input : abb output: [abb,bab,bba]
     * input: abc output: [abc, acb, bac, bca, cab, cba]
     */
    public static ArrayList<String> permutation(String str){
        ArrayList<String> current = new ArrayList<String>();
        if(str.length()==1){
            current.add(str);
            return current;
        }

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            // remove duplicate
            if(i > 0 && ch == str.charAt(i-1))  continue;
            String remainder = remove(str,i);
            // recursive invocation
            ArrayList<String> next = permutation(remainder);
            for(String nextStr : next) {
                current.add(ch + nextStr);
            }
        }

        return current;

    }
    /**idea: every time a new character apear, add it to the exist combination, and a new combination is just itself
    /* for example
    /* we have existing combinations [a],[a,b],[b],[a,c],[a,b,c],[b,c],[c]
    /* then we have a new character d, we can get 8 new combinations
    /* [a,d],[a,b,d],[b,d],[a,c,d],[a,b,c,d],[b,c,d],[c,d],[d]
     */
    public static List<List<Character>> combine(char[] chars) {
        List<List<Character>> list = new ArrayList<List<Character>>();
        Arrays.sort(chars);

        for(char value : chars) { // for every value in nums, check the list,
            if(list.isEmpty()) {
                list.add(new ArrayList(Arrays.asList(value)));//add current single value
            } else {
                int size = list.size();
                for(int i = 0; i < size; i++) {
                    List<Character> temp = new ArrayList<>(list.get(i)); // based on exist list
                    temp.add(value); // add value to each list
                    list.add(temp);
                }
                list.add(new ArrayList(Arrays.asList(value))); // add current single value
            }
        }

        list.add(new ArrayList<Character>());//finally ， add the empty set
        return list;
    }




    public static void main(String[] args){
       String str = "abc";
        ArrayList<String> result = permutation(str);
        System.out.println(result);
        System.out.println(result.size());
        char[] chars = new char[]{'c','b','a','d'};
        List<List<Character>> res = combine(chars);
        for(List<Character> every:res){
            System.out.println(every);
        }
        System.out.println(res.size());


    }
    private static String remove(String str, int index){
        // notice the substring method would not contains the last
        // index character
        if(index == 0) return str.substring(1);
        if (index == str.length()-1) return str.substring(0,index);
        return str.substring(0,index)+str.substring(index+1,str.length());
    }

}
