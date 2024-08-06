package com.study.service.impl;

import com.study.dao.TravelDao;
import com.study.dao.impl.TravelDaoImpl;
import com.study.pojo.Passenger;
import com.study.pojo.Travel;
import com.study.service.TravelService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TravelServiceImpl implements TravelService {

    TravelDao travelDao = new TravelDaoImpl();
    public List<Travel> getTravelList(String likeName){
        return travelDao.getTravelList(likeName);
    }

    @Override
    public String addPassenger(Passenger passenger) {


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String time = simpleDateFormat.format(date);
        passenger.setSignDate(time);

        Integer flag = travelDao.setTravelNum(passenger.getTid(), "+");
        if (flag == 1){
            return travelDao.addPassenger(passenger);
        }
        return "false";
    }

    @Override
    public Travel findTravelAndPassengerById(int tid) {
        return travelDao.findTravelAndPassengerById(tid);
    }

    @Override
    public String deleteTravelById(String tid) {
        return travelDao.deleteTravelById(tid);
    }

    @Override
    public Travel findTravelByTid(int tid) {
        return travelDao.findTravelByTid(tid);
    }

    @Override
    public String toUpdate(Travel travel) {
        return travelDao.toUpdate(travel);
    }

    @Override
    public String login(String username, String password) {
        return travelDao.login(username,password);
    }

    @Override
    public String signup(String username, String password) {
        return travelDao.signup(username,password);
    }


}
