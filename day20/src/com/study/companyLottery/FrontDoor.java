package com.study.companyLottery;

public class FrontDoor extends Thread{

    protected int count;
    private final Lottery lottery;

    public FrontDoor(String name, Lottery lottery) {
        super(name);
        this.lottery = lottery;
    }

    @Override
    public void run() {
        while (lottery.getNums() > 0){

            synchronized (lottery){

                if(lottery.getNums() > 0){
                    System.out.println("编号为: "+ lottery.getId() + "的员工 从前门 入场!" +
                            " 拿到的双色球彩票号码是: " + lottery.getNumber());
                    lottery.setId(lottery.getId() + 1);
                    lottery.setNums(lottery.getNums() - 1);
                    count++;
                }else{
                    return;
                }

            }
        }
    }

    public int getCount() {
        return count;
    }
}
