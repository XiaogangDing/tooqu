/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.google.code.kaptcha.Constants;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyComment;
import com.tooqu.entity.AccompanyParticipateRecord;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import com.tooqu.service.AccompanyCommentService;
import com.tooqu.service.AccompanyParticipateRecordService;
import com.tooqu.service.AccompanyService;
import com.tooqu.service.PlaceService;
import com.tooqu.service.UserService;
import com.tooqu.web.ControllerBase;
import static com.tooqu.web.ControllerBase.ALLLIST;
import java.sql.Date;
import java.util.List;
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
 * @author Dxg
 */
@Controller
public class AccompanyController extends ControllerBase {
    @Autowired
    private AccompanyService accompanyService;
    @Autowired
    private UserService userService;
    @Autowired
    private PlaceService placeService;
    @Autowired
    private AccompanyParticipateRecordService accompanyParticipateRecordService;
    @Autowired
    private AccompanyCommentService accompanyCommentService;
    
    @RequestMapping(value="/accompany",method=RequestMethod.GET)
    public String actionAllAccompanyList(Model model, HttpServletResponse response) throws Exception {

        List<Accompany> accList = accompanyService.getAccompanyListByPage(getPageContext());
        model.addAttribute("accompany_list", accList);
        
        return "accompany";
    }
    
    @RequestMapping(value="/accompanycreate",method=RequestMethod.GET)
    public String actionCreateAccompany(Model model, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user_id")==null){
            model.addAttribute("msg", "请先登录！");
            request.getSession().setAttribute("pre_page", "accompany-create");
            return "login";
        }
        return "accompany-create";
    }

    @RequestMapping(value = "/searchAccompany", method = RequestMethod.POST)
    public String ajaxSearchAccompany(Model model, HttpServletResponse response) throws Exception {
        
        Place tempFrom = new Place();
        tempFrom.setCountry(request.getParameter("country"));
        tempFrom.setProvince(request.getParameter("province"));
        tempFrom.setCity(request.getParameter("city"));
        tempFrom.setCounty(request.getParameter("county"));              
        Place from=placeService.findPlaceByPlace(tempFrom);
        
        Place tempTo = new Place();
        tempTo.setCountry(request.getParameter("country2"));
        tempTo.setProvince(request.getParameter("province2"));
        tempTo.setCity(request.getParameter("city2"));
        tempTo.setCounty(request.getParameter("county2"));        
        Place to=placeService.findPlaceByPlace(tempTo);
        
        List<Accompany> accList = accompanyService.getSearchAccompanyByPage(from, to,getPageContext());
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < accList.size(); i++) {
            Accompany acc = accList.get(i);
            obj = new JSONObject();
            
            obj.put("id", acc.getAid());
            obj.put("name", acc.getName());
            Place departure = acc.getDeparture();
            obj.put("departure", departure.getCountry() + departure.getProvince() + departure.getCity() + departure.getCounty());
            Place destination = acc.getDestination();
            obj.put("destination", destination.getCountry() + destination.getProvince() + destination.getCity() + destination.getCounty());
            obj.put("travelTime", dateToStr(acc.getTravelTime()));
            obj.put("user_name", acc.getCreator_user().getName());
            obj.put("user_portrait", acc.getCreator_user().getPortrait());

            array.put(obj);

        }
        //logger.debug(array);

        return ajaxResponse(array);
    }
    
    @RequestMapping(value = "/getAccompanyByPage", method = RequestMethod.POST)
    public String ajaxGetAccompanyByPage(Model model, HttpServletResponse response) throws Exception {
        List<Accompany> accList = null;
        int listType = Integer.parseInt(request.getParameter("list_type"));

        if (listType == ALLLIST) {//全部分页结果
            accList = accompanyService.getAccompanyListByPage(getPageContext());

        } else if (listType == SEARCHLIST) {//搜索分页结果
            Place tempFrom = new Place();
            tempFrom.setCountry(request.getParameter("country"));
            tempFrom.setProvince(request.getParameter("province"));
            tempFrom.setCity(request.getParameter("city"));
            tempFrom.setCounty(request.getParameter("county"));
            Place from = placeService.findPlaceByPlace(tempFrom);

            Place tempTo = new Place();
            tempTo.setCountry(request.getParameter("country2"));
            tempTo.setProvince(request.getParameter("province2"));
            tempTo.setCity(request.getParameter("city2"));
            tempTo.setCounty(request.getParameter("county2"));
            Place to = placeService.findPlaceByPlace(tempTo);

            accList = accompanyService.getSearchAccompanyByPage(from, to, getPageContext());
        }
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < accList.size(); i++) {
            Accompany acc = accList.get(i);
            obj = new JSONObject();
            
            obj.put("id", acc.getAid());
            obj.put("name", acc.getName());
            Place departure = acc.getDeparture();
            obj.put("departure", departure.getCountry() + departure.getProvince() + departure.getCity() + departure.getCounty());
            Place destination = acc.getDestination();
            obj.put("destination", destination.getCountry() + destination.getProvince() + destination.getCity() + destination.getCounty());
            obj.put("travelTime", dateToStr(acc.getTravelTime()));
            obj.put("user_name", acc.getCreator_user().getName());
            obj.put("user_portrait", acc.getCreator_user().getPortrait());

            array.put(obj);

        }
        //logger.debug(array);

        return ajaxResponse(array);
    }
    
    @RequestMapping(value="/accompanyDetail",method=RequestMethod.GET)
    public String actionGetAccompanyDetail(Model model, HttpServletResponse response) throws Exception {

        Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        Long accId=Long.parseLong(request.getParameter("acc_id"));
        
        Accompany acc =accompanyService.findAccompanyById(accId);
        model.addAttribute("accompany", acc);
        
        int ifFollow=0;
        if(accompanyService.containUser(accId,userId)) ifFollow=1;
        model.addAttribute("id_follow", ifFollow);
        
        List<AccompanyParticipateRecord> accPRList=accompanyParticipateRecordService.getAPRListByAcc(acc);
        model.addAttribute("accompany_participate_record_list", accPRList);
        
        int ifParticipate=0;
        if(accompanyParticipateRecordService.containUser(accPRList,userId)) ifParticipate=1;
        model.addAttribute("if_participate", ifParticipate);
        
        List<AccompanyComment> accCmtList=accompanyCommentService.getAccCmtListByAcc(acc,getPageContext());
        model.addAttribute("accompany_comment_list",accCmtList);
        int pageNum=0;
        int pp=Integer.parseInt(request.getParameter(QS_PER_PAGE));
        int total=accompanyCommentService.getAccCmtListByAcc(acc).size();
        
        if(total%pp==0) pageNum=total/pp;
        else pageNum=total/pp+1;
      
        int currentPage=this.getCurrentPage();
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("currentPage",currentPage);
        
        return "accompany-detail";
    }
    
    
    
    @RequestMapping(value = "/followAccompany", method = RequestMethod.POST)
    public String ajaxFollowAccompany(Model model, HttpServletResponse response) throws Exception {
        
        long Uid=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        long Accid=Long.parseLong(request.getParameter("acc_id"));
        
        userService.addFollowAccompany(Uid,Accid);
        
        return ajaxResponse("OK");
    }
    
    @RequestMapping(value = "/participateAccompany", method = RequestMethod.POST)
    public String ajaxParticipateAccompany(Model model, HttpServletResponse response) throws Exception {
        
        
        Long accId=Long.parseLong(request.getParameter("acc_id"));
        Accompany acc =accompanyService.findAccompanyById(accId);
        
        AccompanyParticipateRecord accPR=new AccompanyParticipateRecord();
        accPR.setAccompany(acc);
        accPR.setNumber(Integer.parseInt(request.getParameter("number")));
        accPR.setRemark(request.getParameter("acc_participate_record_remark"));
        accPR.setUser(userService.getUserById(Long.parseLong(request.getSession().getAttribute("user_id").toString())));
        
        accompanyParticipateRecordService.addAccompanyParticipateRecord(accPR);
        
        return ajaxResponse("OK");
    }
    
    @RequestMapping(value = "/modifyAccompany", method = RequestMethod.GET)
    public String actionModifyAccompany(Model model, HttpServletResponse response) throws Exception {
        
        Long accId=Long.parseLong(request.getParameter("acc_id"));
        Accompany acc =accompanyService.findAccompanyById(accId);        
        model.addAttribute("accompany", acc);
        
        return "accompany-edit";
        
    }
    
    @RequestMapping(value="/modifyAccompanyDetail",method= RequestMethod.POST)
    public String ajaxModifyAccompanyDetail(Model model, HttpServletResponse response) throws Exception {
        //检验验证码
        String userCheckword=request.getParameter("acc_checkword");
        String checkWord=userCheckword;
                //request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        
        if(!userCheckword.equals(checkWord)){
             return ajaxResponse("验证码不符!");
        }else{
            long Uid=Long.parseLong(request.getSession().getAttribute("user_id").toString());
            User user=userService.getUserById(Uid);
            
            //logger.debug("True");
            Long accId=Long.parseLong(request.getParameter("acc_id"));
            Accompany temp =accompanyService.findAccompanyById(accId); 
            
            temp.setName(request.getParameter("acc_name"));
            temp.setType(Integer.parseInt(request.getParameter("acc_type")));
            temp.setAccType(Integer.parseInt(request.getParameter("acc_acctype")));
            temp.setAccSex(Integer.parseInt(request.getParameter("acc_sex")));
            
            Date deadline = strToDate(request.getParameter("acc_deadline_year"),
                    request.getParameter("acc_deadline_month"),
                    request.getParameter("acc_deadline_day"));
            temp.setDeadline(deadline);
            
            Date travelTime = strToDate(request.getParameter("acc_traveltime_year"),
                    request.getParameter("acc_traveltime_month"),
                    request.getParameter("acc_traveltime_day"));
            temp.setTravelTime(travelTime);        
            temp.setTravelduration(Integer.parseInt(request.getParameter("acc_travelduration")));
            temp.setAccountAmount(Integer.parseInt(request.getParameter("acc_amount")));
            temp.setAccAge(request.getParameter("acc_age"));
            temp.setAccWeight(request.getParameter("acc_weight"));
            temp.setAccHeight(request.getParameter("acc_height"));
            temp.setAccEducation(request.getParameter("acc_education"));
            temp.setAccCar(request.getParameter("acc_car"));
            temp.setAccLanguage(request.getParameter("acc_language"));
            temp.setAccLicense(request.getParameter("acc_license"));
            temp.setAccPassport(request.getParameter("acc_passport"));
            temp.setAccPick(request.getParameter("acc_pick"));
            temp.setBusinessRequirement(request.getParameter("acc_businessrequirement"));
            temp.setFeeType(request.getParameter("acc_feetype"));
            temp.setRemark(request.getParameter("acc_remark"));
            temp.setCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));
            temp.setAuthority(Integer.parseInt(request.getParameter("acc_userauthority")));
            
            Place tempFrom = new Place();
            tempFrom.setCountry(request.getParameter("country"));
            tempFrom.setProvince(request.getParameter("province"));
            tempFrom.setCity(request.getParameter("city"));
            tempFrom.setCounty(request.getParameter("county"));
            Place from = placeService.findPlaceByPlace(tempFrom);

            Place tempTo = new Place();
            tempTo.setCountry(request.getParameter("country2"));
            tempTo.setProvince(request.getParameter("province2"));
            tempTo.setCity(request.getParameter("city2"));
            tempTo.setCounty(request.getParameter("county2"));
            Place to = placeService.findPlaceByPlace(tempTo);
            
            temp.setDeparture(from);
            temp.setDestination(to); 
            temp.setCreator_user(user);
            
            
            boolean modifyResult = accompanyService.modifyAccompany(temp);

            //if(modifyResult) return ajaxResponse("OK");
            if(modifyResult){
               long aid=accompanyService.getAccompanyId(temp);
               return ajaxResponse(aid);
            }
        }
             

        return ajaxResponse("修改失败！");
    }
    
    @RequestMapping(value = "/deleteAccompany", method = RequestMethod.POST)
    public String ajaxDeleteAccompany(Model model, HttpServletResponse response) throws Exception {
        Long accId=Long.parseLong(request.getParameter("acc_id"));
        Accompany acc =accompanyService.findAccompanyById(accId); 
        
        if(accompanyService.deleteAccompany(acc)) return ajaxResponse("OK");
        
        return ajaxResponse("删除失败!");
        
    }
    
    @RequestMapping(value = "/createAccompanyStep1", method = RequestMethod.POST)
    public String ajaxExistAccompanyList(Model model, HttpServletResponse response) throws Exception {
        
        Place tempFrom = new Place();
        tempFrom.setCountry(request.getParameter("country"));
        tempFrom.setProvince(request.getParameter("province"));
        tempFrom.setCity(request.getParameter("city"));
        tempFrom.setCounty(request.getParameter("county"));
        Place from=placeService.findPlaceByPlace(tempFrom);
        
        Place tempTo = new Place();
        tempTo.setCountry(request.getParameter("country2"));
        tempTo.setProvince(request.getParameter("province2"));
        tempTo.setCity(request.getParameter("city2"));
        tempTo.setCounty(request.getParameter("county2"));        
        Place to=placeService.findPlaceByPlace(tempTo);
         
        request.getSession().setAttribute("from_place_id", from.getPid());
        request.getSession().setAttribute("to_place_id", to.getPid());

        List<Accompany> accList = accompanyService.getExistAccompanyList(from, to);
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < accList.size(); i++) {
            Accompany acc = accList.get(i);
            obj = new JSONObject();
            
            obj.put("id", acc.getAid());
            obj.put("name", acc.getName());
            Place departure = acc.getDeparture();
            obj.put("departure", departure.getCountry() + departure.getProvince() + departure.getCity() + departure.getCounty());
            Place destination = acc.getDestination();
            obj.put("destination", destination.getCountry() + destination.getProvince() + destination.getCity() + destination.getCounty());
            obj.put("travelTime", dateToStr(acc.getTravelTime()));
            obj.put("user_name", acc.getCreator_user().getName());
            obj.put("user_portrait", acc.getCreator_user().getPortrait());

            array.put(obj);

        }
        //logger.debug(array);

        return ajaxResponse(array);
    }

    
    @RequestMapping(value = "/createAccompanyStep3", method = RequestMethod.POST)
    public String ajaxAddAccompany(Model model, HttpServletResponse response) throws Exception {
        //检验验证码
        String userCheckword=request.getParameter("acc_checkword");
        String checkWord=request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        
        if(!userCheckword.equals(checkWord)){
             return ajaxResponse("验证码不符!");
        }else{
            long Uid=Long.parseLong(request.getSession().getAttribute("user_id").toString());
            User user=userService.getUserById(Uid);
            
            //logger.debug("True");
            Accompany temp=new Accompany();
            temp.setName(request.getParameter("acc_name"));
            temp.setType(Integer.parseInt(request.getParameter("acc_type")));
            temp.setAccType(Integer.parseInt(request.getParameter("acc_acctype")));
            temp.setAccSex(Integer.parseInt(request.getParameter("acc_sex")));
            
            Date deadline = strToDate(request.getParameter("acc_deadline_year"),
                    request.getParameter("acc_deadline_month"),
                    request.getParameter("acc_deadline_day"));
            temp.setDeadline(deadline);
            
            Date travelTime = strToDate(request.getParameter("acc_traveltime_year"),
                    request.getParameter("acc_traveltime_month"),
                    request.getParameter("acc_traveltime_day"));
            temp.setTravelTime(travelTime);        
            temp.setTravelduration(Integer.parseInt(request.getParameter("acc_travelduration")));
            temp.setAccountAmount(Integer.parseInt(request.getParameter("acc_amount")));
            temp.setAccAge(request.getParameter("acc_age"));
            temp.setAccWeight(request.getParameter("acc_weight"));
            temp.setAccHeight(request.getParameter("acc_height"));
            temp.setAccEducation(request.getParameter("acc_education"));
            temp.setAccCar(request.getParameter("acc_car"));
            temp.setAccLanguage(request.getParameter("acc_language"));
            temp.setAccLicense(request.getParameter("acc_license"));
            temp.setAccPassport(request.getParameter("acc_passport"));
            temp.setAccPick(request.getParameter("acc_pick"));
            temp.setBusinessRequirement(request.getParameter("acc_businessrequirement"));
            temp.setFeeType(request.getParameter("acc_feetype"));
            temp.setRemark(request.getParameter("acc_remark"));
            temp.setCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));
            temp.setAuthority(Integer.parseInt(request.getParameter("acc_userauthority")));
            
            temp.setDeparture(placeService.findPlaceById(Long.parseLong(request.getSession().getAttribute("from_place_id").toString())));
            temp.setDestination(placeService.findPlaceById(Long.parseLong(request.getSession().getAttribute("to_place_id").toString()))); 
            temp.setCreator_user(user);
            
            
            boolean ifSuccess = accompanyService.addAccompany(temp);
            
            if(ifSuccess){
               long aid=accompanyService.getAccompanyId(temp);
               return ajaxResponse(aid);
            }

            
        }
        return ajaxResponse("创建失败!");
        
    }

}

