package com.study.servlet;

import com.study.pojo.Passenger;
import com.study.pojo.Travel;
import com.study.service.TravelService;
import com.study.service.impl.TravelServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/travel")
public class TravelServlet extends HttpServlet {
    private final TravelService travelService = new TravelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 处理中文乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String flag = request.getParameter("flag");

        if(flag != null && flag.equals("list")){
            travelList(request,response);
        }else if(flag != null && flag.equals("addPassenger")){
            addPassenger(request,response);
        }else if(flag != null && flag.equals("toTravelAdd")){
            toTravelAdd(request,response);
        }else if (flag != null && flag.equals("findTravelAndPassengerById")){
            findTravelAndPassengerById(request,response);
        }else if (flag != null && flag.equals("deleteTravelById")){
            deleteTravelById(request,response);
        }else if (flag != null && flag.equals("findTravelByTid")){
            findTravelByTid(request,response);
        }else if (flag != null && flag.equals("toUpdate")){
            toUpdate(request,response);
        }else if (flag != null && flag.equals("login")){
            login(request,response);
        }else if (flag != null && flag.equals("signup")){
            signup(request,response);
        }


    }

    public void signup(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String flag = travelService.signup(username,password);

        if(flag.equals("true")){
            request.getSession().setAttribute("username",username);
            travelList(request,response);
        }else{
            request.setAttribute("msg","注册");
            try {
                request.getRequestDispatcher("jsp/login.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String flag = travelService.login(username,password);

        if(flag.equals("true")){
            request.getSession().setAttribute("username",username);
            travelList(request,response);
        }else{
            request.setAttribute("msg","用户名或密码失败");
            try {
                request.getRequestDispatcher("jsp/login.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void toUpdate(HttpServletRequest request, HttpServletResponse response) {
        //获取客户端的数据
        String id = request.getParameter("id");
        String travelName = request.getParameter("travelName");
        String travelDesc = request.getParameter("travelDesc");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String tripStart = request.getParameter("tripStart");
        String tripEnd = request.getParameter("tripEnd");
        String price = request.getParameter("price");
        String num = request.getParameter("num");


        //创建一个student对象
        Travel travel = new Travel(Integer.parseInt(id),travelName,travelDesc,startDate,endDate,tripStart,tripEnd,Double.parseDouble(price),Integer.parseInt(num));

        String flag = travelService.toUpdate(travel);

        try {
            response.getWriter().print(flag);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void findTravelByTid(HttpServletRequest request, HttpServletResponse response) {
        String tid = request.getParameter("tid");
        Travel travel = travelService.findTravelByTid(Integer.parseInt(tid));

        request.setAttribute("travel",travel);
        try {
            request.getRequestDispatcher("/jsp/travel-update.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteTravelById(HttpServletRequest request, HttpServletResponse response) {
        String tid = request.getParameter("tid");
        if(tid!=null && tid.length() > 1){
            tid =tid.substring(1);
        }
        System.out.println(tid);
        String flag = travelService.deleteTravelById(tid);
        try {
            response.getWriter().print(flag);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void findTravelAndPassengerById(HttpServletRequest request, HttpServletResponse response) {
        String tid = request.getParameter("tid");
        Travel travel = travelService.findTravelAndPassengerById(Integer.parseInt(tid));
        request.setAttribute("travel",travel);
        try {
            request.getRequestDispatcher("/jsp/find-passenger.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void toTravelAdd(HttpServletRequest request, HttpServletResponse response) {

        ServletContext context = getServletContext();
        context.setAttribute("tid",request.getParameter("tid"));
        try {
            response.sendRedirect("http://localhost:8082/web/jsp/travel-add.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void addPassenger(HttpServletRequest request, HttpServletResponse response) {
        String tid = request.getParameter("tid");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");

        //创建游客对象
        Passenger passenger = new Passenger();
        passenger.setBirthday(birthday);
        passenger.setIdCard(idCard);
        passenger.setPhone(phone);
        passenger.setSex(Integer.parseInt(sex));
        passenger.setName(name);
        passenger.setTid(Integer.parseInt(tid));

        //调用业务层
        String flag = travelService.addPassenger(passenger);
        try {
            response.getWriter().print(flag);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void travelList(HttpServletRequest request, HttpServletResponse response) {

        String likeName = request.getParameter("likeName");

        // 获取线路信息
        List<Travel> travels = travelService.getTravelList(likeName);

        // 将线路信息存储到域中
        request.setAttribute("travels",travels);

        request.setAttribute("likeName",likeName);

        try {
            request.getRequestDispatcher("/jsp/travel-list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
