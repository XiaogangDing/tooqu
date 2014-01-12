package com.tooqu.web.controller;

import com.tooqu.entity.Album;
import com.tooqu.entity.Picture;
import com.tooqu.service.AlbumService;
import com.tooqu.web.ControllerBase;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author hao
 */
@Controller
public class AlbumController extends ControllerBase {
    @Autowired
    private AlbumService albumService;
     @RequestMapping(value = "/ListAlbum", method = RequestMethod.GET)
     public String actionGetAlbumListByPage(Model model, HttpServletResponse response) throws Exception {
        long theUserId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        List<Album> atcList = albumService.listAlbumByUserByPage(theUserId,getPageContext());
        model.addAttribute("article_list", atcList);
         
         return "";
     }
     @RequestMapping(value = "/ListPicture", method = RequestMethod.GET)
     public String actionListPictureByAlbum(Model model, HttpServletResponse response) throws Exception {
        long albumId=Long.parseLong(request.getParameter("albumId"));
        
        List<Picture> picList = albumService.listPictureByAlbumByPage(albumId,getPageContext());
        model.addAttribute("picture_list", picList);
         
         return "";
     }
     @RequestMapping(value = "/CreateAlbum", method = RequestMethod.GET)
     public String actionCreateAlbum(Model model, HttpServletResponse response) throws Exception {
         long theUserId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
         String title=request.getParameter("albumtitle");
         int authority=Integer.parseInt(request.getParameter("authority"));
         String Content=request.getParameter("content");

         if(albumService.createAlbum(title,theUserId,authority,Content))
         return "advance-user";
         else 
         return "homepage";
     }
        @RequestMapping(value = "/albumDelete", method = RequestMethod.POST)
    public String ajaxDeleteAlbum(Model model, HttpServletResponse response) throws Exception {
//        long albumId=Long.parseLong(request.getParameter("album"));
        long albumId=9;
        
            //删除文件夹
        Album album=albumService.getAlbumById(albumId);
        if(album==null) return ajaxResponse("删除失败!");
       this.deleteFile(new File(album.getImgpath()));
       
        if(albumService.deleteAlbum(albumId)) return ajaxResponse("OK");
        
        return ajaxResponse("删除失败!");
        
        
    }
       
        
        
        @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String actionDeleteAlbum(Model model, HttpServletResponse response) throws Exception {
//        long albumId=Long.parseLong(request.getParameter("album"));
         long albumId=1;
        
            //删除文件夹
        Album album=albumService.getAlbumById(albumId);
        if(album==null) return "homepage";
       this.deleteFile(new File(album.getImgpath()));
       
        if(albumService.deleteAlbum(albumId)) return "advance-user";
        else return "homepage";
        
        
    }
    
}
