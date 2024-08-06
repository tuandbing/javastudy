package com.study.run03;

public class Team extends Thread{

    protected double runSpeed;

    protected double changeSpeed;

    protected double timer;

    protected int circle = 0;

    protected final double allMeter = 100.0;

    protected double currentMeter = 0;

    public Team(String name, double runSpeed, double changeSpeed) {
        super(name);
        this.runSpeed = runSpeed;
        this.changeSpeed = changeSpeed;
    }

    @Override
    public void run() {
        while(circle < 4){

            while(currentMeter < allMeter){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                currentMeter += runSpeed;

                timer++;

                System.out.println(getName() + "跑了" + String.format("%.1f", circle * 100 + currentMeter) + "米");

                // 如果剩余距离不需要一秒即可跑完
                if(allMeter - currentMeter < runSpeed){

                    try {
                        Thread.sleep((long) (1000 * (allMeter - currentMeter) / runSpeed));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    timer += (allMeter - currentMeter) / runSpeed;

                    break;

                }

            }

            if(circle < 3){
                System.out.println(getName() + "交接,交接起始时间: " + String.format("%.1f",(timer - changeSpeed))  + "交接结束时间: " + String.format("%.1f",timer));
            }

            currentMeter = 0;
            timer += changeSpeed;
            circle++;

        }

        System.out.println(getName() + "跑完了,用时" + String.format("%.1f", timer) + "秒");
    }

    public double getTimer() {
        return timer;
    }
}
