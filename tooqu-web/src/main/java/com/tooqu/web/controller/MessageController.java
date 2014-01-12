/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.entity.Message;
import com.tooqu.entity.User;
import com.tooqu.service.MessageService;
import com.tooqu.service.UserService;
import com.tooqu.web.ControllerBase;
import static com.tooqu.web.ControllerBase.QS_PER_PAGE;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
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
public class MessageController extends ControllerBase {
    @Autowired
    private MessageService messageService;
//    @Autowired
//    private UserService userService;
    
    @RequestMapping(value="/getMySentMessageListByPage",method=RequestMethod.GET)
    public String actionGetMySentMessageListByPage(Model model, HttpServletResponse response)throws Exception {
        Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        List<Message> sentList = messageService.getSentMessageListByPage(userId,getPageContext());
        model.addAttribute("sent_list", sentList);
        
        int pageNum=0;
        int pp=Integer.parseInt(request.getParameter(QS_PER_PAGE));
        int total=messageService.getSentMessageList(userId).size();
        
        if(total%pp==0) pageNum=total/pp;
        else pageNum=total/pp+1;
      
        int currentPage=this.getCurrentPage();
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("currentPage",currentPage);
        
        return "";
    }
    
    @RequestMapping(value = "/getAjaxMySentMessageListByPage", method = RequestMethod.POST)
    public String ajaxGetMySentMessageListByPage(Model model, HttpServletResponse response) throws Exception {
        
        Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        List<Message> sentList = messageService.getSentMessageListByPage(userId,getPageContext());
        
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < sentList.size(); i++) {
            Message message = sentList.get(i);
            User toUser=message.getTo();
            obj = new JSONObject();
            
            obj.put("mid", message.getMid());
            obj.put("to_user_name", toUser.getName());
            obj.put("to_user_portrait", toUser.getPortrait());
            obj.put("sendtime", dateToStr(message.getSendtime()));

            array.put(obj);

        }
        int pageNum=0;
        int pp=Integer.parseInt(request.getParameter(QS_PER_PAGE));
        int total=messageService.getSentMessageList(userId).size();
        
        if(total%pp==0) pageNum=total/pp;
        else pageNum=total/pp+1;
      
        int currentPage=this.getCurrentPage();
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("currentPage",currentPage);
        
        return ajaxResponse(array);
    }
    
    @RequestMapping(value="/getMyReceiveMessageListByPage",method=RequestMethod.GET)
    public String actionGetMyReceiveMessageListByPage(Model model, HttpServletResponse response)throws Exception {
        Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        List<Message> receiveList = messageService.getReceiveMessageListByPage(userId,getPageContext());
        model.addAttribute("receive_list", receiveList);
        
        int pageNum=0;
        int pp=Integer.parseInt(request.getParameter(QS_PER_PAGE));
        int total=messageService.getReceiveMessageList(userId).size();
        
        if(total%pp==0) pageNum=total/pp;
        else pageNum=total/pp+1;
      
        int currentPage=this.getCurrentPage();
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("currentPage",currentPage);
        
        return "";
    }
    
    @RequestMapping(value = "/getAjaxMyReceiveMessageListByPage", method = RequestMethod.POST)
    public String ajaxGetMyReceiveMessageListByPage(Model model, HttpServletResponse response) throws Exception {
        
        Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        List<Message> sentList = messageService.getReceiveMessageListByPage(userId,getPageContext());
        
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < sentList.size(); i++) {
            Message message = sentList.get(i);
            User toUser=message.getFrom();
            obj = new JSONObject();
            
            obj.put("mid", message.getMid());
            obj.put("from_user_name", toUser.getName());
            obj.put("from_user_portrait", toUser.getPortrait());
            obj.put("sendtime", dateToStr(message.getSendtime()));

            array.put(obj);

        }
        int pageNum=0;
        int pp=Integer.parseInt(request.getParameter(QS_PER_PAGE));
        int total=messageService.getReceiveMessageList(userId).size();
        
        if(total%pp==0) pageNum=total/pp;
        else pageNum=total/pp+1;
      
        int currentPage=this.getCurrentPage();
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("currentPage",currentPage);
        
        return ajaxResponse(array);
    }
    
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public String ajaxSendMessage(Model model, HttpServletResponse response) throws Exception {
        
        Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        String content=request.getParameter("content");
        long toUserId=Long.parseLong(request.getParameter("toUserId"));
        
        long addResult=messageService.createMessage(userId,content,toUserId);
        
        if(addResult==0) return ajaxResponse("发送失败!");
        
        Message message = messageService.getMessageById(addResult);
        JSONObject obj = new JSONObject();
        User toUser = message.getFrom();


        obj.put("mid", message.getMid());
        obj.put("from_user_name", toUser.getName());
        obj.put("from_user_portrait", toUser.getPortrait());
        obj.put("sendtime", dateToStr(message.getSendtime()));
        
        return ajaxResponse(obj);
        
    }
    
    @RequestMapping(value = "/deleteSingleMessage", method = RequestMethod.POST)
    public String ajaxDeleteSingleMessage(Model model, HttpServletResponse response) throws Exception {
        
        //Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        long mid=Long.parseLong(request.getParameter("mid"));
        
        boolean deleteResult=messageService.deleteMessage(mid);
        
        if(!deleteResult) return ajaxResponse("删除失败!");
        
        return ajaxResponse("OK");
        
    }
    /**
     * 批量删除
     * request中加入参数message_delete_amount指代消息个数，消息Id使用mid0,mid1,mid2...
     * @param model
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/deleteManyMessage", method = RequestMethod.POST)
    public String ajaxDeleteManyMessage(Model model, HttpServletResponse response) throws Exception {
        
        //Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        int amount=Integer.parseInt(request.getParameter("message_delete_amount"));
        List<Long> midList=new ArrayList<Long>();
        
        for(int i=0;i<amount;i++){
            long mid=Long.parseLong(request.getParameter("mid"+i));
            midList.add(mid);
        }
        
        boolean deleteResult=messageService.deleteMessage(midList);
        
        if(!deleteResult) return ajaxResponse("删除失败!");
        
        return ajaxResponse("OK");
        
    }
    
    @RequestMapping(value = "/emptyMySentMessage", method = RequestMethod.POST)
    public String ajaxEmptyMySentMessage(Model model, HttpServletResponse response) throws Exception {
        
        Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        
        boolean deleteResult=messageService.emptyMySentMessage(userId);
        
        if(!deleteResult) return ajaxResponse("删除失败!");
        
        return ajaxResponse("OK");
        
    }
    
    @RequestMapping(value = "/emptyMyReceiveMessage", method = RequestMethod.POST)
    public String ajaxEmptyMyReceiveMessage(Model model, HttpServletResponse response) throws Exception {
        
        Long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        
        boolean deleteResult=messageService.emptyMyReceiveMessage(userId);
        
        if(!deleteResult) return ajaxResponse("删除失败!");
        
        return ajaxResponse("OK");
        
    }
}
