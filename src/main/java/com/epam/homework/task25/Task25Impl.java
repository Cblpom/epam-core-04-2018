package com.epam.homework.task25;

public class Task25Impl implements Task25 {
    @Override
    public boolean isNormalBrackets(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                sum++;
            } else {
                sum--;
            }
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }


}
