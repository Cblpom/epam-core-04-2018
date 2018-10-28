package com.epam.homework.task24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task24Impl implements Task24 {
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {

        Map<Integer,Integer> result = new HashMap<>();

        for (Map.Entry<Integer,Integer> entry : first.entrySet()){
            result.put(entry.getKey(),entry.getValue());
        }


        for (Map.Entry<Integer,Integer> entry : second.entrySet()){
            if (result.containsKey(entry.getKey())){
                result.put(entry.getKey(),entry.getValue()+result.get(entry.getKey()));
            }else{
                result.put(entry.getKey(),entry.getValue());
            }

        }



        return result;
    }


}
