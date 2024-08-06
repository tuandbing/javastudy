package com.study.companyLottery;

import java.util.Arrays;
import java.util.Random;

public class Lottery {

    private int id = 1;

    private String strings;

    private int nums;

    private Random random = new Random();

    private int[] number = new int[7];

    public Lottery(int nums) {
        this.nums = nums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getNumber() {
        boolean flag = true;
        while(flag){
            for (int i = 0; i < 7; i++) {
                number[i] = random.nextInt(1,33);
                checkNumber(i);
            }
            flag = checkNumbers(Arrays.toString(number));
        }
        strings+=Arrays.toString(number);
        return Arrays.toString(number);
    }

    public boolean checkNumbers(String str){
        if(strings == null){
            return false;
        }
        return strings.contains(str);
    }
    public void checkNumber(int i){

        boolean flag = false;
        for (int j = 0; j < i; j++) {
            if(number[j] == number[i]){
                number[i] = random.nextInt(1,33);
                flag = true;
                break;
            }
        }

        if(flag){
            checkNumber(i);
        }

    }

}
