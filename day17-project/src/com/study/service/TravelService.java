package com.study.service;

import com.study.pojo.Passenger;
import com.study.pojo.Travel;

import java.util.List;

public interface TravelService {

    List<Travel> getTravelList(String likeName);

    String addPassenger(Passenger passenger);

    Travel findTravelAndPassengerById(int tid);

    String deleteTravelById(String tid);

    Travel findTravelByTid(int tid);

    String toUpdate(Travel travel);

    String login(String username, String password);

    String signup(String username, String password);
}
