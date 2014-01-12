/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.tooqu.encryption.MD5;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;

import com.tooqu.entity.UserInfo;
import com.tooqu.service.PlaceService;

import com.tooqu.mailer.LocalMailSender;
import com.tooqu.service.AccompanyService;
import com.tooqu.service.AccountService;

import com.tooqu.service.UserService;
import com.tooqu.web.ControllerBase;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author guo
 */
@Controller
public class HomeController extends ControllerBase {

    @Autowired
    private UserService userService;
    @Autowired
    private PlaceService placeService;
    
    
    private LocalMailSender mailSender;
    
    private Producer captchaProducer = null;

    @Autowired
    public void setMailSender(LocalMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Autowired
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String actionAccompanyList(Model model, HttpServletResponse response) throws Exception {
        String country="中国";
        List<String> provincelist=placeService.getProvinceListByCountry(country);
        model.addAttribute("listLength", provincelist.size());
        model.addAttribute("provinceList", provincelist);
        
        return "homepage";
    }
    @RequestMapping(value = "/advanceSearch", method = RequestMethod.GET)
    public String actionJumpToAdvanceSearch(Model model, HttpServletResponse response) throws Exception {        
        return "advanceSearch";
    }
    
    @RequestMapping("/upload")
    public String actionUpload(Model model) {
        model.addAttribute("target", request.getParameter("t"));
        return "file-upload";
    }
    
    @RequestMapping(value = "/captchaImage", method = RequestMethod.GET)
    public String actionGetCaptchaImage(Model model, HttpServletResponse response) throws Exception {
        //when one want get the captcha string just produced in the frontend
        //you shall just String code = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        // and then you can match the right code with the user passed code(request.getParam...)
        
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text  
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out  
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
    
    @RequestMapping(value = "/searchUserByQQ", method = RequestMethod.POST)
    public String ajaxSearchUserByQQ(Model model, HttpServletResponse response) throws Exception {
        String qq = request.getParameter("qq");
        User user = userService.getUserByQQ(qq);
        if (user == null) {
            return ajaxResponse("用户不存在！");
        }
        JSONObject obj = new JSONObject();
        obj.put("id", user.getUserId());
        obj.put("name", user.getName());
        obj.put("portrait", user.getPortrait());
        obj.put("type", user.getTypeStr());
        obj.put("sex", user.getSexStr());
        obj.put("birthday", dateToStr(user.getUinfo().getBirthday()));
        obj.put("height", user.getUinfo().getHeight());
        obj.put("education", user.getUinfo().getEducation());
        obj.put("job", user.getUinfo().getJob());
        obj.put("language", user.getUinfo().getUser_language());
        obj.put("passport", user.getUinfo().getPassport());
        obj.put("intro", user.getUinfo().getIntro());

        return ajaxResponse(obj);  
    }
    
    @RequestMapping(value = "/bannerSearchUser", method = RequestMethod.POST)
    public String actionBannerSearchUser(Model model, HttpServletResponse response) throws Exception {
        int type=Integer.parseInt(request.getParameter("type"));
        int sex=Integer.parseInt(request.getParameter("sex"));
        Place tempFrom = new Place();
        tempFrom.setCountry("中国");
        tempFrom.setProvince(request.getParameter("select_province"));
        tempFrom.setCity(request.getParameter("select_city"));
        tempFrom.setCounty(request.getParameter("select_county"));              
        Place place=placeService.findPlaceByPlace(tempFrom);
       String p=request.getParameter("p");
       int listSize=userService.getUserList(type, sex, place).size();
//       int pageNum=(1+userService.getUserList(type, sex, place).size())/getDefaultPerpage();
       int pageNum=listSize%getDefaultPerpage()==0?(listSize/getDefaultPerpage()):(listSize/getDefaultPerpage()+1);
       int currentPage=this.getCurrentPage();
        List<User> userList=userService.getUserListByPage(type,sex,place,getPageContext());
//        List<UserInfo> userInfoList=userService.getUserInfoList(userList);
        model.addAttribute("userList", userList);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("currentPage",currentPage);
        request.getSession().setAttribute("pageNum", pageNum);
//        model.addAttribute("userInfoList", userInfoList);        
        return "search-result";
    }
      @RequestMapping(value = "/bannerSearchUserByPage", method = RequestMethod.POST)
    public String ajaxBannerSearchUser(Model model, HttpServletResponse response) throws Exception {
        int type=Integer.parseInt(request.getParameter("type"));
        int sex=Integer.parseInt(request.getParameter("sex"));
        Place tempFrom = new Place();
        tempFrom.setCountry("中国");
        tempFrom.setProvince(request.getParameter("select_province"));
        tempFrom.setCity(request.getParameter("select_city"));
        tempFrom.setCounty(request.getParameter("select_county"));              
        Place place=placeService.findPlaceByPlace(tempFrom);
       String p=request.getParameter("p");
       int listSize=userService.getUserList(type, sex, place).size();
//       int pageNum=(1+userService.getUserList(type, sex, place).size())/getDefaultPerpage();
       int pageNum=listSize%getDefaultPerpage()==0?(listSize/getDefaultPerpage()):(listSize/getDefaultPerpage()+1);
//       int currentPage=this.getCurrentPage();
        List<User> userList=userService.getUserListByPage(type,sex,place,getPageContext());
        
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < userList.size(); i++) {
            obj = new JSONObject();
            
            obj.put("user", userList.get(i));

            array.put(obj);

        }
        obj=new JSONObject();
        obj.put("userList", array);
        JSONArray array2=new JSONArray();
        array2.put(obj);
        obj=new JSONObject();
        obj.put("pageNum",pageNum);
        array2.put(obj);
//        obj=new JSONObject();
//        obj.put("cuurentPage",currentPage);
//        array2.put(obj);
        

        //logger.debug(array);


        request.getSession().setAttribute("pageNum", pageNum);
//        model.addAttribute("userInfoList", userInfoList); 
        return ajaxResponse(array2);
    }
    
    
    
//    @RequestMapping(value = "/bannerSearchUserByPage", method = RequestMethod.POST)
//    public String actionBannerSearchUserByPage(Model model, HttpServletResponse response) throws Exception {
//        int type=Integer.parseInt(request.getParameter("type"));
//        int sex=Integer.parseInt(request.getParameter("sex"));
//        Place tempFrom = new Place();
//        tempFrom.setCountry(request.getParameter("country"));
//        tempFrom.setProvince(request.getParameter("province"));
//        tempFrom.setCity(request.getParameter("city"));
//        tempFrom.setCounty(request.getParameter("county"));              
//        Place place=placeService.findPlaceByPlace(tempFrom);
//        
//        List<User> userList=userService.getUserListByPage(type,sex,place,getPageContext());
//        List<UserInfo> userInfoList=userService.getUserInfoList(userList);
//        model.addAttribute("userList", userList);
//        model.addAttribute("userInfoList", userInfoList);
//        
//        
//        return "homepage";
//    }
    
    
    
    
    
    /**
     * 高级搜索，结果少,故不采用分页
     * @param model
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/advanceSearchUser", method = RequestMethod.POST)
    public String actionAdvanceSearchUser(Model model, HttpServletResponse response) throws Exception {
        int type=Integer.parseInt(request.getParameter("type"));
        int sex=Integer.parseInt(request.getParameter("sex"));
        
        Place tempFrom = new Place();
        tempFrom.setCountry(request.getParameter("country"));
        tempFrom.setProvince(request.getParameter("province"));
        tempFrom.setCity(request.getParameter("city"));
        tempFrom.setCounty(request.getParameter("county"));              
        Place place = placeService.findPlaceByPlace(tempFrom);
        String ageRange = request.getParameter("age");
        int yearFrom = ageToYear(Integer.parseInt(ageRange.split(",")[1]));
        int yearTo = ageToYear(Integer.parseInt(ageRange.split(",")[0]));
        String height = request.getParameter("height");
        double heightFrom = Double.parseDouble(height.split(",")[0]);
        double heightTo = Double.parseDouble(height.split(",")[1]);
        
        String education=request.getParameter("degree");
        String job=request.getParameter("job");
        String language=request.getParameter("language");
        String passport=request.getParameter("passport");
        String license=request.getParameter("license");

        List<User> userList = userService.getUserList(type,sex,place,yearFrom,yearTo,heightFrom,heightTo,
                education,job,language,passport,license);
        List<UserInfo> userInfoList = userService.getUserInfoList(userList);
        
        model.addAttribute("userList", userList);
        model.addAttribute("userInfoList", userInfoList);
        
        
        return "advanceSearch";
    }
    
    
    
//    @RequestMapping(value = "/sendmail/test", method = RequestMethod.GET)
//    public String actionTest(Model model, HttpServletResponse response) throws Exception {
//        mailSender.send("noreply@tooqu.com", "xsj420848196@163.com", "some test of the mail", "it ok");
//        return "accompany";
//    }
    
    @RequestMapping(value = "/getProvinceByCountry", method = RequestMethod.POST)
    public String ajaxGetProvince(Model model, HttpServletResponse response) throws Exception {
        String country=request.getParameter("select_country");
        
        List<String> provincelist=placeService.getProvinceListByCountry(country);
        
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < provincelist.size(); i++) {
            obj = new JSONObject();
            
            obj.put("province", provincelist.get(i));

            array.put(obj);

        }
        //logger.debug(array);

        return ajaxResponse(array);
    }
    
    @RequestMapping(value = "/getCityByProvince", method = RequestMethod.POST)
    public String ajaxGetCity(Model model, HttpServletResponse response) throws Exception {
        String province=request.getParameter("select_province");
        List<String> citylist=placeService.getCityListByProvince(province);
        
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < citylist.size(); i++) {
            obj = new JSONObject();
            
            obj.put("city", citylist.get(i));

            array.put(obj);

        }
        //logger.debug(array);

        return ajaxResponse(array);
    }
    
    @RequestMapping(value = "/getCountyByCity", method = RequestMethod.POST)
    public String ajaxGetCounty(Model model, HttpServletResponse response) throws Exception {
        String city=request.getParameter("select_city");
        List<String> countylist=placeService.getCountyListByCity(city);
        
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < countylist.size(); i++) {
            obj = new JSONObject();
            
            obj.put("county", countylist.get(i));

            array.put(obj);

        }
        //logger.debug(array);

        return ajaxResponse(array);
    }
    
}
