package com.study.dao.impl;

import com.study.dao.TravelDao;
import com.study.pojo.Passenger;
import com.study.pojo.Travel;
import com.study.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class TravelDaoImpl implements TravelDao {

    public List<Travel> getTravelList(String likeName){

        List<Travel> travels = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            if(likeName != null){
                preparedStatement = connection.prepareStatement("select  * from tb_travel where travel_name like '%"+likeName+"%'");
            }else{
                preparedStatement = connection.prepareStatement("select  * from tb_travel");
            }

            resultSet = preparedStatement.executeQuery();

            while(resultSet != null && resultSet.next()){

                int id = resultSet.getInt("id");
                int num = resultSet.getInt("num");
                double price = resultSet.getDouble("price");
                String travelName = resultSet.getString("travel_name");
                String travelDesc = resultSet.getString("travel_desc");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                String tripStart = resultSet.getString("trip_start");
                String tripEnd = resultSet.getString("trip_end");

                // 创建新的线路对象
                Travel travel = new Travel(id, travelName, travelDesc, startDate, endDate, tripStart, tripEnd, price, num);

                // 将线路添加到集合中
                travels.add(travel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }


        return travels;
    }

    @Override
    public String addPassenger(Passenger passenger) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into tb_passenger(name, sex, birthday, phone, idCard, sign_date, tid) values(?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,passenger.getName());
            preparedStatement.setInt(2,passenger.getSex());
            preparedStatement.setString(3,passenger.getBirthday());
            preparedStatement.setString(4,passenger.getPhone());
            preparedStatement.setString(5,passenger.getIdCard());
            preparedStatement.setString(6,passenger.getSignDate());
            preparedStatement.setInt(7,passenger.getTid());

            int num = preparedStatement.executeUpdate();

            return num == 1 ? "true" : "false";


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

    }

    @Override
    public Integer setTravelNum(Integer tid, String ysf) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("update tb_travel set num = num " + ysf + " 1 where id = ?");
            preparedStatement.setInt(1,tid);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

    }

    @Override
    public Travel findTravelAndPassengerById(int tid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Travel travel = new Travel();
        List<Passenger> passengers = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_passenger tp join tb_travel tr on tp.tid = tr.id where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, tid);

            resultSet = preparedStatement.executeQuery();

            while(resultSet != null && resultSet.next()){

                int id = resultSet.getInt("id");
                int sex = resultSet.getInt("sex");
                int num = resultSet.getInt("num");
                double price = resultSet.getDouble("price");
                String travelName = resultSet.getString("travel_name");
                String travelDesc = resultSet.getString("travel_desc");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                String tripStart = resultSet.getString("trip_start");
                String tripEnd = resultSet.getString("trip_end");
                travel = new Travel(id, travelName, travelDesc, startDate, endDate, tripStart, tripEnd, price, num);

                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                String phone = resultSet.getString("phone");
                String idCard = resultSet.getString("idCard");
                String signDate = resultSet.getString("sign_date");

                //创建旅客对象
                Passenger passenger = new Passenger();
                passenger.setTid(id);
                passenger.setSignDate(signDate);
                passenger.setIdCard(idCard);
                passenger.setBirthday(birthday);
                passenger.setPhone(phone);
                passenger.setName(name);
                passenger.setSex(sex);
                passengers.add(passenger);

            }
            travel.setPassengers(passengers);
            return travel;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

    }

    @Override
    public String deleteTravelById(String tid) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            // 需要先删除报名该线路的游客
            // deletePassengerByTid(tid);
            // 也可以选择 有游客的线路无法被删除
            Travel travel = new Travel();
            if(tid.length() == 1){
                travel = findTravelByTid(Integer.parseInt(tid));
                if(travel.getNum() > 0){
                    return "false00";
                }

            }else{
                for (String s : tid.split(",")) {
                    travel = findTravelByTid(Integer.parseInt(s));
                    if(travel.getNum() > 0){
                        return "false00";
                    }
                }
            }

            // 删除对应的线路
            String sql = "delete from tb_travel where id in ("+tid+")";
            preparedStatement = connection.prepareStatement(sql);
            int num = preparedStatement.executeUpdate();
            return num > 0 ? "true" : "false";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

    }

    @Override
    public Travel findTravelByTid(int tid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_travel where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,tid);

            resultSet = preparedStatement.executeQuery();

            if(resultSet != null && resultSet.next()){

                int id = resultSet.getInt("id");
                int num = resultSet.getInt("num");
                double price = resultSet.getDouble("price");
                String travelName = resultSet.getString("travel_name");
                String travelDesc = resultSet.getString("travel_desc");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                String tripStart = resultSet.getString("trip_start");
                String tripEnd = resultSet.getString("trip_end");

                return new Travel(id, travelName, travelDesc, startDate, endDate, tripStart, tripEnd, price, num);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
        return null;
    }

    @Override
    public String toUpdate(Travel travel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "update tb_travel set travel_name = ?, travel_desc = ?," +
                    " start_date = ?, end_date = ?, trip_start = ?, trip_end = ?," +
                    " price = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,travel.getTravelName());
            preparedStatement.setString(2,travel.getTravelDesc());
            preparedStatement.setString(3,travel.getStartDate());
            preparedStatement.setString(4,travel.getEndDate());
            preparedStatement.setString(5,travel.getTripStart());
            preparedStatement.setString(6,travel.getTripEnd());
            preparedStatement.setDouble(7,travel.getPrice());
            preparedStatement.setInt(8,travel.getId());

            int num = preparedStatement.executeUpdate();
            return num > 0 ? "true" : "false";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

    }

    @Override
    public String login(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_user where username = ? and password = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();

            if(resultSet != null && resultSet.next()){
                return "true";
            }else{
                return "false";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }

    @Override
    public String signup(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into tb_user(username, password) VALUES (?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            int num = preparedStatement.executeUpdate();

            return num == 1 ? "true" : "false";



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }

    public void deletePassengerByTid(String tid){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from tb_passenger where tid in ("+tid+")";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }

}
