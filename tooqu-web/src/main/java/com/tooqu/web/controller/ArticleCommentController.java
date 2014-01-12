/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.entity.ArticleComment;
import com.tooqu.service.ArticleCommentService;
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
public class ArticleCommentController extends ControllerBase{
    @Autowired
    private ArticleCommentService articleCommentService;
    
    @RequestMapping(value = "/articleComment/create", method = RequestMethod.POST)
    public String ajaxCreateArticleComment(Model model, HttpServletResponse response) throws Exception {
        long userId = Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        long atcId = Long.parseLong(request.getParameter("article_id"));
        
        String content = request.getParameter("comment");
        
        articleCommentService.addComment(userId, atcId, content);
        
        return ajaxResponse("OK");
    }
    
    @RequestMapping(value = "/articleComment/delete", method = RequestMethod.POST)
    public String ajaxArticleCommentDelete(Model model, HttpServletResponse response) throws Exception {
        
        long atcCmtId = Long.parseLong(request.getParameter("article_comment_id"));
        
        if(articleCommentService.deleteComment(atcCmtId)) 
            return ajaxResponse("OK");
        
        return ajaxResponse("删除失败！");
    }
    
    @RequestMapping(value = "/getArticleCmtListByPage", method = RequestMethod.POST)
    public String ajaxGetArticleCmtListByPage(Model model, HttpServletResponse response) throws Exception {
        long atcId = Long.parseLong(request.getParameter("article_id"));

        List<ArticleComment> atcCmtList = articleCommentService.getArticleCmtListById(atcId, getPageContext());
         
        JSONArray array = new JSONArray();
        JSONObject obj;
        for (int i = 0; i < atcCmtList.size(); i++) {
            ArticleComment accCmt = atcCmtList.get(i);
            obj = new JSONObject();
            
            obj.put("article_comment_id", accCmt.getArticle_comment_id());
            obj.put("user_name", accCmt.getUser().getName());
            obj.put("user_portrait", accCmt.getUser().getPortrait());
            obj.put("article_comment_time", dateToStr(accCmt.getCreateTime()));
            obj.put("article_comment_content", accCmt.getContent());

            array.put(obj);

        }
        return ajaxResponse(array);
    }
    
    @RequestMapping(value = "/articleComment/getTotalNumber", method = RequestMethod.POST)
    public String ajaxGetArticleCommentNumber(Model model, HttpServletResponse response) throws Exception {
        long atcId = Long.parseLong(request.getParameter("article_id"));
        int number =  articleCommentService.getArticleCommentNumber(atcId);
        return ajaxResponse(number);
    }
}
