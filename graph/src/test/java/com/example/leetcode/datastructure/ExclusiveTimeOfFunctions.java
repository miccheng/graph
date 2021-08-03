package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    ArrayDeque<Log> stack=new ArrayDeque<>();
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        int len=logs.size();
        for(int i=0;i<len;i++){
            Log log=new Log(logs.get(i));
            if("start".equals(log.status)){
                stack.push(log);
            }else{//end
                Log previous=stack.pop();
                result[log.id]+=log.val-previous.val+1;
                if(!stack.isEmpty()){
                    result[stack.peek().id]-=log.val-previous.val+1;
                }
            }
        }
        return result;
    }


    class Log{
        int id;
        String status;
        int val;
        Log(String content){
            String[] info=content.split(":");
            this.id=Integer.valueOf(info[0]);
            this.status=info[1];
            this.val=Integer.valueOf(info[2]);
        }
    }
}
