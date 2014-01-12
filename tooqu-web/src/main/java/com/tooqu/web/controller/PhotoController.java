/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.google.code.kaptcha.Producer;
import com.tooqu.entity.Album;
import com.tooqu.entity.Picture;

import com.tooqu.service.PlaceService;

import com.tooqu.mailer.LocalMailSender;
import com.tooqu.service.AlbumService;

import com.tooqu.service.UserService;
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
 * @author guo
 */
@Controller
public class PhotoController extends ControllerBase {

    @Autowired
    private UserService userService;
    @Autowired
    private AlbumService albumService;
    
    
    
    private Producer captchaProducer = null;

    @Autowired
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }
    
    @RequestMapping(value = "/listAllAlbum", method = RequestMethod.GET)
    public String actionListUserAlbum(Model model, HttpServletResponse response) throws Exception {
        long userId = Long.parseLong(request.getSession().getAttribute("user_id").toString());
        
        List<Album> albumList = albumService.listAlbumByUser(userId);
        return "user-album";
    }

    @RequestMapping(value = "/listAllPhoto", method = RequestMethod.GET)
    public String actionListUserPhoto(Model model, HttpServletResponse response) throws Exception {
        long userId = Long.parseLong(request.getSession().getAttribute("user_id").toString());
        long albumId = 2;
        
        List<Picture> pictureList = albumService.listPictureByAlbum( albumId);
        model.addAttribute("photoList", null);
        return "user-photo";
    }
    
    @RequestMapping(value = "/create/album", method = RequestMethod.POST)
    public String ajaxCreateAlbum(Model model, HttpServletResponse response) throws Exception {
        
//        albumService.createAlbum();
        
        return ajaxResponse("OK");
    }
    
    @RequestMapping(value = "/remove/album", method = RequestMethod.POST)
    public String ajaxRemoveAlbum(Model model, HttpServletResponse response) throws Exception {
        long albunid = 2;
        albumService.deleteAlbum(albunid);
        
        return ajaxResponse("OK");
    }
    
    @RequestMapping(value = "/add/photo", method = RequestMethod.POST)
    public String ajaxAddPhoto(Model model, HttpServletResponse response) throws Exception {
        File file = null;
        long albumId = 2;
//        albumService.addPhotoInAlbum(file, albumId);
        return ajaxResponse("OK");
    }
    
 @RequestMapping(value = "/pictureDelete", method = RequestMethod.POST)
    public String ajaxAddPicture(Model model, HttpServletResponse response) throws Exception {
        long pictureId=Long.parseLong(request.getParameter("picture_id"));
        Picture picture=albumService.getPicById(pictureId);
        this.deleteFile(new File(picture.getPath()));
        albumService.deletePhotoInAlbum(pictureId);
         return ajaxResponse("OK");
        
       // return ajaxResponse("删除失败!");
        
        
    }
       @RequestMapping(value = "/Picture/{userId}/upload", method = RequestMethod.POST)
    public String actionUploadPhoto(@PathVariable("userId") long userId, @RequestParam("file") MultipartFile file,
    @RequestParam("album_id") long albumId  ,HttpServletResponse response) throws IOException {
        
        
        if (file == null || file.isEmpty()) {
            response.getWriter().append("No file uploaded!!!");
        }
        try {
            if (!file.isEmpty()) {
                Album album=albumService.getAlbumById(albumId);
                String Dir=album.getImgpath();
                File destfile = new File(String.format(Dir+"/%d.jpg", System.currentTimeMillis()));
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                if (suffix.equalsIgnoreCase(".jpg")) {
                    String portrait=destfile.getAbsolutePath();
                    String content=request.getParameter("content");
                    String filename=request.getParameter("filename");
                     albumService.addPhotoInAlbum(filename, content, albumId);
                    file.transferTo(destfile);
                    response.getWriter().append(Dir+"/" + destfile.getName());
                } else {
                    response.getWriter().append("incorrect format!");
                }
            } else {
                response.getWriter().append("unknow error!");
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }    
    
    
}
