package com.example.leetcode.recursivestring;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombination {
    public static void main(String args[]){
        String digits="23";
        letterCombinations(digits);
    }

    private static void collectAllCombination(String digits) {
        //store mapping
        String [] mapping={"","","abc","def","ghi","jkl","","","",""};

        //find combination
        List<String> result = lookCombination(digits, mapping, 0);
        System.out.println();
    }

    private static List<String> lookCombination(String digits, String[] mapping, int index) {
        List<String> result = new ArrayList<>();
        //base case
        if (index >= digits.length()) {
            result.add("");//must add ""
            return result;
        }

        //body
        int current = digits.charAt(index)-'0';//important
//        int numericValue = Character.getNumericValue(digits.charAt(index));
        String curMapping = mapping[current];
        for (char c : curMapping.toCharArray()) {
            List<String> list = lookCombination(digits, mapping, index + 1);
            for (String str : list) {
                result.add(c + "" + str);
            }
        }

        return result;
    }


    Map<String, List<String>> map = new HashMap<>();

    public LetterCombination() {
        createMappings();
    }

    //hashmap mapping
    public void createMappings() {
        map.put("2", Lists.newArrayList("a","b","c"));
        map.put("3", Lists.newArrayList("d","e","f"));
        map.put("4", Lists.newArrayList("g","h","i"));
        //to be modified
        map.put("5", Lists.newArrayList("a","b","c"));
        map.put("6", Lists.newArrayList("a","b","c"));
        map.put("7", Lists.newArrayList("a","b","c"));
        map.put("8", Lists.newArrayList("a","b","c"));
        map.put("9", Lists.newArrayList("a","b","c"));

    }

    //iterative
    public List<String> findCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        if ("".equals(digits)) return new ArrayList<String>();

        for (int i = 0; i < digits.length(); i++) {
            String current = String.valueOf(digits.charAt(i)); // 2
            List<String> letters = map.get(current); // a, b, c
            if (i == 0) {
                result.addAll(letters);
            } else {
                int size = letters.size();
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    String s = letters.get(j);
                    List<String> collect = result.stream().map(e -> e + s).collect(Collectors.toList());
                    temp.addAll(collect);
                }
                result = temp;
            }
        }

        return result;
    }



    static String[][] mapping={{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};

    public static List<String> letterCombinations(String digits) {
        if("".equals(digits)) return new ArrayList<String>();
        return recursive(digits);
    }

    public static List<String> recursive(String digits){
        List<String> res=new ArrayList<>();
        if("".equals(digits)) {
            res.add("");
            return res;
        }

        String current=digits.substring(0,1);
        String remain=digits.substring(1);
        List<String> tmp=recursive(remain);

        String [] prefix=mapping[Integer.valueOf(current)];
        for(String str: prefix){
            List<String> result=tmp.stream().map(e->str+e).collect(Collectors.toList());
            res.addAll(result);
        }
        return res;
    }

}
