package com.example.leetcode.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SubdomainVisitCount {

    public static void main(String[] args) {
//        String[] cpdomains={"9001 discuss.leetcode.com"};
        String[] cpdomains={"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(cpdomains);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains.length < 1) return new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        String padding = " ";
        for (String complexDomain : cpdomains) {
            String[] split = complexDomain.split("\\s+");//number and domain
            Integer frequency = Integer.valueOf(split[0]);
            String[] individualDomain = split[1].split("\\.");
            String domain="";
            for (int i = individualDomain.length -1; i >=0; i--) {
                if (i != individualDomain.length - 1)
                    domain = individualDomain[i] + "." + domain;
                else
                    domain = individualDomain[i] + domain;
                map.put(domain, frequency + map.getOrDefault(domain, 0));
            }
        }


        return map.entrySet().stream().map(e -> String.valueOf(e.getValue()) + padding + e.getKey()).collect(Collectors.toList());
    }
}
