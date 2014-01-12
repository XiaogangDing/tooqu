/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;


import com.tooqu.entity.Article;
import com.tooqu.entity.User;
import com.tooqu.service.ArticleService;
import com.tooqu.web.ControllerBase;
import java.io.File;
import java.text.SimpleDateFormat;
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
public class ArticleController extends ControllerBase {
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping(value="/getArticleByPage",method=RequestMethod.GET)
    public String actionGetArticleByPage(Model model, HttpServletResponse response)throws Exception {
        long theUserId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        List<Article> atcList = articleService.getArticleListByPage(theUserId,getPageContext());
        model.addAttribute("article_list", atcList);
        
        return "article-detail";
    }
    
    @RequestMapping(value="/articleDetail",method=RequestMethod.GET)
    public String actionArticleDetail(Model model, HttpServletResponse response)throws Exception {
        long atcId=Long.parseLong(request.getParameter("article_id"));
        Article atc =articleService.findArticleById(atcId); 
        
        User theUser=atc.getUser();
        long articleUid=theUser.getUserId();
        model.addAttribute("article", atc);
        model.addAttribute("the_user", theUser);
        
        return "article-detail";
    }
    
    @RequestMapping(value="/jumpToCreateArticle",method=RequestMethod.GET)
    public String actionJumpToCreateArticle(Model model, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user_id")==null){
            model.addAttribute("msg", "请先登录！");
            request.getSession().setAttribute("pre_page", "article-modify");
            return "login";
        }
        return "article-modify";
    }
    
    @RequestMapping(value="/articleCreate",method=RequestMethod.POST)
    public String actionCreateArticle(Model model, HttpServletResponse response) throws Exception {
        long userId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        String title=request.getParameter("title");
        String content=request.getParameter("youjiContent");
        int authority=Integer.parseInt(request.getParameter("authority"));
        
        boolean addResult=articleService.createArticle(userId,title,content,authority);
        
        if(addResult) {
            long aid = articleService.getArticleDao().getArticleId(userId, title, content);
            model.addAttribute("article_id", aid);
            model.addAttribute("content", content);
            return "article-audit";
        }
        
        model.addAttribute("msg","提交失败!");
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("authority", authority);
        
        return "article-audit";
    }
    
    @RequestMapping(value = "/articleDelete", method = RequestMethod.POST)
    public String ajaxDeleteArticle(Model model, HttpServletResponse response) throws Exception {
        long atcId=Long.parseLong(request.getParameter("article_id"));
        Article atc =articleService.findArticleById(atcId); 
        SimpleDateFormat dd = new SimpleDateFormat("yyyyMMdd");
       String path="/tmp/image/"+dd.format(atc.getCreatetime());
        this.deleteFile(new File(path));
        if(articleService.deleteArticle(atc)) return ajaxResponse("OK");
        
        return ajaxResponse("删除失败!");
        
    }
    
    @RequestMapping(value = "/articleModify", method = RequestMethod.GET)
    public String actionModifyArticle(Model model, HttpServletResponse response) throws Exception {
        
        long atcId=Long.parseLong(request.getParameter("article_id"));
        Article atc =articleService.findArticleById(atcId); 
        
        model.addAttribute("article", atc);
        
        return "article-modify";
        
    }
    
    @RequestMapping(value="/articleModifyDetail",method=RequestMethod.POST)
    public String actionModifyArticleDetail(Model model, HttpServletResponse response) throws Exception {
        long atcId=Long.parseLong(request.getParameter("article_id"));
        
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        int authority=Integer.parseInt(request.getParameter("authority"));
        
        boolean modifyResult=articleService.modifyArticle(atcId,title,content,authority);
        
        if(modifyResult){
            model.addAttribute("msg","修改成功!");
            
            return "article-sended";
        } 
        
        model.addAttribute("msg","修改失败!");
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("authority", authority);
        return "article-modify";
    }
    
    @RequestMapping(value="/articleRelease",method=RequestMethod.POST)
    public String actionReleaseArticle(Model model, HttpServletResponse response) throws Exception {
        
        long atcId = Long.parseLong(request.getParameter("article_id"));
        boolean isReleased = articleService.releaseArticle(atcId);
        
        if(isReleased){
            model.addAttribute("msg","发布成功!");
            return "article-audit";
        }
        model.addAttribute("msg","发布失败!");
        return "article-sended";
    }
}
