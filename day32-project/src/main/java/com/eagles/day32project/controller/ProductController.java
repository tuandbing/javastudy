package com.eagles.day32project.controller;

import com.eagles.day32project.pojo.Area;
import com.eagles.day32project.pojo.Business;
import com.eagles.day32project.pojo.Product;
import com.eagles.day32project.service.AreaService;
import com.eagles.day32project.service.BusinessService;
import com.eagles.day32project.service.ProductService;
import com.eagles.day32project.utils.PageUtils;
import com.eagles.day32project.vo.ProductVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private PageUtils pageUtils;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private AreaService areaService;

    /**
     * 列出所有产品信息
     * @param model
     * @param session session域对象,获取当前的商家
     * @param productVo 产品信息与当前页码信息
     * @return
     */
    @RequestMapping("/list")
    public String getList(Model model, HttpSession session, ProductVo productVo){

        // 查看域中是否存在商家信息
        Business business = (Business) session.getAttribute("business");

        System.out.println(productVo);

        // 域中没有商家信息则直接进入登录界面
        if(business == null){
            return "redirect:../business/toLog";
        }

        HashMap<String, Object> map = new HashMap<>();

        // 将商家信息存入map集合
        map.put("business",business);

        // 将商家的bid存入map
        map.put("bid",business.getId());

        model.addAttribute("business",business);
        model.addAttribute("productVo",productVo);

        // 如果需要名称模糊查询
        if(productVo.getLikeName() != null && !productVo.getLikeName().trim().equals("")){
            map.put("likeName",productVo.getLikeName());
        }

        // 如果需要产地模糊查询
        if(productVo.getLikeArea() != null && !productVo.getLikeArea().trim().equals("")){
            Area area = areaService.getAreaByName(productVo.getLikeArea());
            System.out.println("areaId ==> " + area.getId());
            map.put("areaId",area.getId());
        }

        // 如果需要上架区间模糊查询
        if(productVo.getUpTimeStart() != null && !productVo.getUpTimeStart().trim().equals("")){

            if(productVo.getUpTimeEnd() != null && !productVo.getUpTimeEnd().trim().equals("")){
                map.put("upTimeEnd",productVo.getUpTimeEnd().trim());
                map.put("upTimeStart",productVo.getUpTimeStart().trim());
            }

        }

        // 将页面信息进行初始化(更新)
        pageUtils.initPage(productVo.getCurrentPage(),4,productService.getCount(map));

        // 将页面信息存入map集合
        map.put("indexStart",pageUtils.getIndexStart());
        map.put("pageSize",pageUtils.getPageSize());

        model.addAttribute("pageUtils",pageUtils);

        // 获取商品信息
        List<Product> productList = productService.getProductList(map);

        // 将商品信息存入域中
        model.addAttribute("productList",productList);

        // 进入主页面(商品展示界面)
        return "list";

    }

    @RequestMapping("/show")
    public String showDetail(Model model, Integer id){

        // 将产品信息存入域中
        model.addAttribute("product",productService.getProductById(id));

        // 进入展示具体产品界面
        return "show";

    }

    /**
     * 删除产品(支持同时删除多个)
     * @param ids 需要删除的产品的id序列
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String ids){

        return productService.deleteProduct(ids) > 0 ? "1" : "2";

    }

    /**
     * 前往商品更新界面
     * @param model
     * @param id 产品id,用户获取产品全部信息
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Model model, Integer id){

        // 获取产品的全部信息，用于回显在前端
        model.addAttribute("product",productService.getProductById(id));

        return "update";

    }

    /**
     * 前往添加产品界面
     * @param model
     * @param username 商家名称，用于获取商家全部信息
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model,String username){

        // 获取商家全部信息
        model.addAttribute("business",businessService.getBusinessByName(username));

        return "add";
    }

    /**
     * 添加产品操作
     * @param product 需要添加的产品
     * @param bid 产品所属商家的id
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(Product product,Integer bid,Integer areaId){

        HashMap<String, Object> map = new HashMap<>();
        //TODO 添加商品是否可以注册的校验，即验证商品是否已存在

        map.put("productName",product.getProductName());
        map.put("feature",product.getFeature());
        map.put("weight",product.getWeight());
        map.put("price",product.getPrice());
        map.put("bid",bid);
        map.put("areaId",areaId);


        return productService.insertProduct(map).toString();

    }

    /**
     * 产品更新操作
     * @param product 需要更新的产品
     * @param bid 产品最终所属商家
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(Product product,Integer bid,Integer areaId){
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(product);
        System.out.println(bid);
        System.out.println(areaId);

        map.put("id",product.getId());
        map.put("productName",product.getProductName());
        map.put("feature",product.getFeature());
        map.put("weight",product.getWeight());
        map.put("price",product.getPrice());
        map.put("bid",bid);
        map.put("areaId",areaId);
        return productService.updateProduct(map) == 1 ? "1" : "2";

    }


}
