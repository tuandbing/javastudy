package com.study.run03;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {

        List<Team> teams = new ArrayList<>();

        List<Double> timer = new ArrayList<>();
        List<String> teamNames = new ArrayList<>();

        TreeMap<Double, String> map = new TreeMap<>();

        Team team1 = new Team("馒头1号", 9.2, 0.3);
        Team team2 = new Team("馒头2号", 9.3, 0.4);
        Team team3 = new Team("馒头3号", 9.4, 0.2);
        Team team4 = new Team("馒头4号", 9.5, 0.5);
        Team team5 = new Team("馒头5号", 9.3, 0.4);
        Team team6 = new Team("馒头6号", 9.2, 0.3);

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);
        teams.add(team5);
        teams.add(team6);

        for (Team team : teams) {
            team.start();
        }

        team1.join();
        team2.join();
        team3.join();
        team4.join();
        team5.join();
        team6.join();


        for (Team team : teams) {

            // map.put(team.timer,team.getName());
            timer.add(team.timer);
            teamNames.add(team.getName());
        }

        for (int i = 1; i < 7; i++) {
            double minTime = timer.get(0);
            int index = 0;
            for (Double time : timer) {
                if (time < minTime) {
                    minTime = time;
                    index = timer.indexOf(time);
                }
            }
            System.out.println("排名第" + i + "的是" + teamNames.get(index) + "用时" + String.format("%.2f", timer.get(index)));
            timer.remove(index);
            teamNames.remove(index);
        }

/*                int count = 1;
                for (Map.Entry<Double, String> set : map.entrySet()) {

                    System.out.println("排名第" + count++  + "的是" + set.getValue() + "用时" + String.format("%.1f",set.getKey()));

                }*/

        return;
    }


}
