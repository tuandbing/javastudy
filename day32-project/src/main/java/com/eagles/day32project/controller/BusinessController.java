package com.eagles.day32project.controller;

import com.eagles.day32project.pojo.Business;
import com.eagles.day32project.pojo.Product;
import com.eagles.day32project.service.BusinessService;
import com.eagles.day32project.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 前往商家登录界面
     * @return
     */
    @RequestMapping("/toLog")
    public String toLog(){

        return "login";

    }

    /**
     * 对商家身份进行验证
     * @param session session域对象,存储当前登录用户信息
     * @param username 商家名称
     * @param password 商家密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpSession session, String username, String password){
        // 对商家身份进行验证(获取该信息是否有商家注册)
        Business business = businessService.login(new Business(username, password));
        if(business == null){
            return "2";
        }else{
            System.out.println(business);
            session.setAttribute("business",business);
            return "1";
        }

    }

    /**
     * 前往注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){

        return "register";

    }

    /**
     * 注册用户
     * @param business 需要注册的用户
     * @param rePassword 确认密码是否一致
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(Business business,String rePassword){

        // 检查两次密码是否一致
        if(business.getPassword().equals(rePassword)){
            // 检查用户名是否可用
            if(businessService.getBusinessByName(business.getUsername()) == null){
                return businessService.insertBusiness(business) == 1 ? "1" : "2";
            }else{
                return "4";
            }
        }else {
            return "3";
        }
    }

    /**
     * 查找所有商家(用于商品更新操作)
     * @return
     */
    @RequestMapping("/findBusinessAll")
    @ResponseBody
    public List<Business> findBusinessAll(){

        HashMap<String, Object> map = new HashMap<>();
        return businessService.getBusinessList(map);

    }

}
