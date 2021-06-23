package com.example.leetcode.binarysearch.range;

import java.util.*;

public class Meeting {
    //sort array by starting time 1-2
//    p1: 1-3 --> 1,2
//    p2: 3-6--> 3,4,5
    // p3: 4-8 --> 4,5,6,7
    public static void main(String[] args) {
    }

    public static String largestMeeting(List<Schedule> scheduleList) {
        //sort the list by start time??

        Map<Integer, Integer> map1 = new HashMap<>();//Time-->frequency
        Map<Integer, Integer> map2 = new HashMap<>();//Time-->people

        calculateFre(scheduleList, map1, map2);

        //find the max repeated numbers
        Integer max = map1.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();

        // Caution! cases: there could be multiple timeslots at the max frequency
        //get all the time slot at max frequency
        List<Integer> timeSlots = new ArrayList<>();
        findTimeAtMaxFrequency(map1, max, timeSlots);

        if(timeSlots.isEmpty()) return "";

        //Longest consecutive subarray
        //{1,2,3,4, 6,7}
        List<Integer> meeting = getMeeting(timeSlots);
        List<Integer> people = getPeople(map2, meeting);

        int start=meeting.get(0);
        int end=meeting.get(meeting.size()-1);
        System.out.println("DEBUG");

        return String.format("The largest meeting you can have is with %s people between %s and %s.", people, start, end);
    }

    private static List<Integer> getMeeting(List<Integer> timeSlots) {
        int i=0;
        int j=0;
        int beg=i;
        int end=j;
        if(j< timeSlots.size()-1) {
            while (timeSlots.get(j) + 1 == timeSlots.get(j + 1)) {
                j++;
            }
            if (j - i > end - beg) {
                end = j;
                beg = i;
            }
            i = j;
            j++;
        }
        List<Integer> meeting = timeSlots.subList(beg, end + 1);
        return meeting;
    }

    private static List<Integer> getPeople(Map<Integer, Integer> map2, List<Integer> meeting) {
        List<Integer> people = new ArrayList<>();
        for (int timePoint: meeting) {
            if(map2.containsKey(timePoint)){
                people.add(map2.get(timePoint));
            }
        }
        return people;
    }

    private static void findTimeAtMaxFrequency(Map<Integer, Integer> map1, Integer max, List<Integer> timeSlots) {
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer fre = entry.getValue();
            Integer timePionts = entry.getKey();
            if (fre == max) {
                timeSlots.add(timePionts);
            }
        }
    }

    private static void calculateFre(List<Schedule> scheduleList, Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        for (int i = 0; i < scheduleList.size(); i++) {
            Schedule schedule = scheduleList.get(i);
            int start = schedule.start;
            int end = schedule.end;

            while (start < end) {
                map1.put(start, map1.getOrDefault(start, 0) + 1);
                map2.put(start, i);
                start++;
            }
        }
    }

    class Schedule{
        int start;
        int end;
    }
}
