import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class EasyGS {
    public static void main(String args[]) {
        String array[][]={
                {"Bob","87"},
                {"Mike", "35"},
                {"Bob", "52"},
                {"Jason","35"},
                {"Mike", "55"},
                {"Jessica", "99"}
        };

        //find the 2nd largest number in the array
        int arr[] = {12, 35, 1, 10, 34, 1};

        //highestAverage
        highestAverage(array);

        //iterative or math
//        boolean b = power3(28);

        // Construct a string with gievn constraints:
        //input: abcd, const: 123, o/p: abbcccd
        //input: abcde, const: 4, o/p: aaaabcde
        //also decode in the same manner
        //i/p: aabbbccccd, const:2341, o/p: abcd
        induction("abcd",234);
        deduction("aabbbccccd",2341);
    }



    public static Integer bestAverageGrade(String[][] scores)
    {
        Map<String, Integer> map=  new HashMap<>();
        for (int i=0; i<scores.length;i++){
            String name=scores[i][0];
            int score=Integer.valueOf(scores[i][1]);
            if(!map.containsKey(name)){
                map.put(name,score);
            }
        }

        return 0;
    }


    private static int highestAverage(String[][] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String key = array[i][0];
            String valueStr = array[i][1];
            Integer valueInt = Integer.valueOf(valueStr);
            int base = map.containsKey(key) == true ? map.get(key) : 0;
            if(base!=0) valueInt = (base + valueInt) / 2;
            map.put(key, valueInt);
        }
        Integer max = map.values().stream().reduce(Integer::max).get();

//        LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().
//                sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));
//        Integer value = sortedMap.entrySet().stream().reduce((e1, e2) -> e2).orElse(null).getValue();

//                map.entrySet().stream()
//                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
//                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
//        sortedMap.entrySet()

        Integer value1 = map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null).getValue();
        Integer integer = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).orElse(null).getValue();
        return value1;
    }

    private static String deduction(String str, int num) {
        //aabbbccccd
        Deque<Integer> digits = getDigits(num);
        int index=0;
        String result="";
        while(!digits.isEmpty()){
            Integer digit = digits.pop();
            index+=digit;
            char c = str.charAt(index-1);
            result=result+ String.valueOf(c);
        }
        return result;
    }

    private static String induction(String str, int num) {
        //abcd  243
        Deque<Integer> digits = getDigits(num);
        int index=0;
        String concatedStr="";
        while (!digits.isEmpty()){
            Integer frequency = digits.pop();
            String s = String.valueOf(str.charAt(index));
            concatedStr =concatedStr + String.join("", Collections.nCopies(frequency, s));
            index++;
        }
        return concatedStr;
    }

    private static Deque<Integer> getDigits( int num) {
        Deque<Integer> digits = new ArrayDeque<>();
        while (num > 0) {
            int digit = num % 10;
            digits.push(digit);
            num = num / 10;
        }
        return digits;
    }



}
