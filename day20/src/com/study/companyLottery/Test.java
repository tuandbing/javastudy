package com.study.companyLottery;

public class Test {
    public static void main(String[] args) {

        Lottery lottery = new Lottery(100);

        BackDoor backDoor = new BackDoor("Back",lottery);
        FrontDoor frontDoor = new FrontDoor("Front",lottery);

        frontDoor.start();
        backDoor.start();

        try {
            frontDoor.join();
            backDoor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        int backCount = backDoor.count;
        int frontCount = frontDoor.count;

        System.out.println("从前门入场的员工总共: "+backCount+" 位员工");
        System.out.println("从后门入场的员工总共: "+frontCount+" 位员工");

    }
}
