/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.entity.LocalTravel;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import com.tooqu.service.LocalTravelService;
import com.tooqu.service.PlaceService;
import com.tooqu.service.UserService;
import com.tooqu.web.ControllerBase;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dxg
 */
@Controller
public class LocalTravelController extends ControllerBase {
    @Autowired
    private UserService userService;
    
    @Autowired
    private LocalTravelService localTravelService;
    @Autowired
    private PlaceService placeService;
    
    @RequestMapping(value="/getlocalTravelByPage",method=RequestMethod.GET)
    public String actionGetArticleByPage(Model model, HttpServletResponse response)throws Exception {
        //long theUserId=Long.parseLong(request.getParameter("the_user_id"));
        
        List<LocalTravel> atcList = localTravelService.getLocalTravelListByPage(getPageContext());
        model.addAttribute("localtravel_list", atcList);
        
        return "localtravel_list";
    }
    
    @RequestMapping(value="/localTravel/detail",method=RequestMethod.GET)
    public String actionArticleDetail(Model model, HttpServletResponse response)throws Exception {
        long lctrvId=Long.parseLong(request.getParameter("localtravel_id"));
        LocalTravel lctrv =localTravelService.findLocalTravelById(lctrvId); 
        
        User theUser=lctrv.getCreator();
        
        model.addAttribute("localtravel", lctrv);
        model.addAttribute("the_user", theUser);
        
        return "localtravel-detail";
    }
    
    @RequestMapping(value="/jumpToCreateLocalTravel",method=RequestMethod.GET)
    public String actionJumpToCreateLocalTravel(Model model, HttpServletResponse response) throws Exception {

       if(request.getSession().getAttribute("user_id")==null){
            model.addAttribute("msg", "请先登录！");
            return "login";
        }
        
        return "localtravel-create";
    }
    
    @RequestMapping(value="/localTravel/create",method=RequestMethod.POST)
    public String actionCreateArticle(Model model, HttpServletResponse response) throws Exception {
        long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        //1，标题 2.最大人数  3.交通工具类型 4.收费标准（按小时，按天）5.服务城市 6.行程安排 7.费用说明 8.预订须知 
        String title=request.getParameter("title");
        int maxpeople=Integer.parseInt(request.getParameter("maxpeople"));
        int vehicletype=Integer.parseInt(request.getParameter("vehicletype"));
        int feetype=Integer.parseInt(request.getParameter("feetype"));
        
        String country=request.getParameter("country");
        String province=request.getParameter("province");
        String city=request.getParameter("city");
        String county=request.getParameter("county");
        Place temp = new Place();
        temp.setCountry(country);
        temp.setProvince(province);
        temp.setCity(city);
        temp.setCounty(county);
        Place place = placeService.findPlaceByPlace(temp);
        
        String arrangement=request.getParameter("arrangement");
        String notice=request.getParameter("notice");
        String bookrule=request.getParameter("bookrule");
        
        boolean addResult=localTravelService.createLocalTravel(userId,title,maxpeople,vehicletype,feetype,place,arrangement,notice,bookrule);
        
        if(addResult) {
           return "localtravel-audit";
        }
        
        model.addAttribute("msg","提交失败!");
        model.addAttribute("title", title);
        model.addAttribute("maxpeople", maxpeople);
        model.addAttribute("vehicletype", vehicletype);
        model.addAttribute("feetype", feetype);
        model.addAttribute("country", country);
        model.addAttribute("province", province);
        model.addAttribute("city", city);
        model.addAttribute("county", county);
        model.addAttribute("arrangement", arrangement);
        model.addAttribute("notice", notice);
        model.addAttribute("bookrule", bookrule);
        
        return "localtravel-edit";
    }
    
    @RequestMapping(value = "/localTravel/delete", method = RequestMethod.POST)
    public String ajaxDeleteLocalTravel(Model model, HttpServletResponse response) throws Exception {
        long lctrvId=Long.parseLong(request.getParameter("localtravel_id"));
        LocalTravel lctrv =localTravelService.findLocalTravelById(lctrvId); 
        
        if(localTravelService.deleteLocalTravel(lctrv)) return ajaxResponse("OK");
        
        return ajaxResponse("删除失败!");
        
    }
    
    @RequestMapping(value = "/localTravel/modify", method = RequestMethod.GET)
    public String actionModifyLocalTravel(Model model, HttpServletResponse response) throws Exception {
        
        long lctrvId=Long.parseLong(request.getParameter("localtravel_id"));
        LocalTravel lctrv =localTravelService.findLocalTravelById(lctrvId); 
        
        model.addAttribute("localtravel", lctrv);
        
        return "localtravel-modify";
        
    }
    
    @RequestMapping(value="/localTravel/modify/detail",method=RequestMethod.POST)
    public String actionModifyLocalTravelDetail(Model model, HttpServletResponse response) throws Exception {
        long lctrvId=Long.parseLong(request.getParameter("localtravel_id"));
        
        String title=request.getParameter("title");
        int maxpeople=Integer.parseInt(request.getParameter("maxpeople"));
        int vehicletype=Integer.parseInt(request.getParameter("vehicletype"));
        int feetype=Integer.parseInt(request.getParameter("feetype"));
        
        String country=request.getParameter("country");
        String province=request.getParameter("province");
        String city=request.getParameter("city");
        String county=request.getParameter("county");
        Place temp = new Place();
        temp.setCountry(country);
        temp.setProvince(province);
        temp.setCity(city);
        temp.setCounty(county);
        Place place = placeService.findPlaceByPlace(temp);
        
        String arrangement=request.getParameter("arrangement");
        String notice=request.getParameter("notice");
        String bookrule=request.getParameter("bookrule");
        
        boolean modifyResult=localTravelService.modifyLocalTravel(lctrvId,title,maxpeople,vehicletype,feetype,place,arrangement,notice,bookrule);
        
        if(modifyResult){
            model.addAttribute("msg","修改成功!");
            
            return "localtravel-sended";
        } 
        model.addAttribute("msg","提交失败!");
        model.addAttribute("title", title);
        model.addAttribute("maxpeople", maxpeople);
        model.addAttribute("vehicletype", vehicletype);
        model.addAttribute("feetype", feetype);
        model.addAttribute("country", country);
        model.addAttribute("province", province);
        model.addAttribute("city", city);
        model.addAttribute("county", county);
        model.addAttribute("arrangement", arrangement);
        model.addAttribute("notice", notice);
        model.addAttribute("bookrule", bookrule);
        
        return "localtravel-modify";
    }
    
    
}
