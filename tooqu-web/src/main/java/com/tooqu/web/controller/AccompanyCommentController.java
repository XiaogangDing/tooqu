/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyComment;
import com.tooqu.entity.User;
import com.tooqu.service.AccompanyCommentService;
import com.tooqu.service.AccompanyService;
import com.tooqu.service.UserService;
import com.tooqu.web.ControllerBase;
import static com.tooqu.web.ControllerBase.QS_PER_PAGE;
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
public class AccompanyCommentController extends ControllerBase {
    @Autowired
    private AccompanyCommentService accompanyCommentService;
    @Autowired
    private AccompanyService accompanyService;
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/accompanyComment/create", method = RequestMethod.POST)
    public String ajaxCreateAccompanyComment(Model model, HttpServletResponse response) throws Exception {
        long Uid=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        User user=userService.getUserById(Uid);
        
        long accId=Long.parseLong(request.getParameter("acc_id"));
        Accompany acc =accompanyService.findAccompanyById(accId); 
        
        AccompanyComment accCmt=new AccompanyComment();
        accCmt.setAccompany(acc);
        accCmt.setContent(request.getParameter("acc_comment_content"));
        accCmt.setFrom(user);
        accCmt.setCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));
        
        accompanyCommentService.addComment(accCmt);
        
        return ajaxResponse("OK");
    }      
    
    @RequestMapping(value = "/accompanyComment/delete", method = RequestMethod.POST)
    public String ajaxCreateAccompanyDelete(Model model, HttpServletResponse response) throws Exception {
        String accCmtId=request.getParameter("acc_comment_id");
        AccompanyComment accCmt=accompanyCommentService.findAccompanyCmtById(Integer.parseInt(accCmtId));
        
        if(accompanyCommentService.deleteComment(accCmt)) return ajaxResponse("OK");
        
        return ajaxResponse("删除失败！");
    }
    
    @RequestMapping(value = "/getAccompanyCmtListByPage", method = RequestMethod.POST)
    public String ajaxGetAccompanyCmtListByPage(Model model, HttpServletResponse response) throws Exception {
         long accId=Long.parseLong(request.getParameter("acc_id"));
        Accompany acc =accompanyService.findAccompanyById(accId);
         List<AccompanyComment> accCmtList=accompanyCommentService.getAccCmtListByAcc(acc,getPageContext(2));
         
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < accCmtList.size(); i++) {
            AccompanyComment accCmt = accCmtList.get(i);
            obj = new JSONObject();
            
            obj.put("acc_cmt_id", accCmt.getAc_id());
            obj.put("user_name", accCmt.getFrom().getName());
            obj.put("user_portrait", accCmt.getFrom().getPortrait());
            obj.put("acc_cmt_time",timestampToStr(accCmt.getCreateTime()));
            obj.put("acc_cmt_content", accCmt.getContent());

            array.put(obj);

        }
        int pageNum=0;
        int pp=Integer.parseInt(request.getParameter(QS_PER_PAGE));
        int total=accompanyCommentService.getAccCmtListByAcc(acc).size();
        
        if(total%pp==0) pageNum=total/pp;
        else pageNum=total/pp+1;
      
        int currentPage=this.getCurrentPage();
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("currentPage",currentPage);
        
        return ajaxResponse(array);
    }
}
