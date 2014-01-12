/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.AlbumDao;
import com.tooqu.dao.PictureDao;
import com.tooqu.dao.UserDao;
import com.tooqu.entity.Album;
import com.tooqu.entity.Picture;
import com.tooqu.entity.User;
import com.tooqu.service.AlbumService;
import java.io.File;
import java.util.List;

/**
 *
 * @author guo
 */
public class AlbumServiceImpl implements AlbumService{  
   private AlbumDao albumDao;
   private PictureDao pictureDao;
   private UserDao userDao;
    @Override
    public List<Album> listAlbumByUser(long userId) {
      return albumDao.getAlbumByUser(userId);
    }
    
    @Override
    public List<Album> listAlbumByUserByPage(long userId,PageContext pageContext)
    {
        return albumDao.listAlbumByUserByPage(userId,pageContext.getStart(),pageContext.getLength());    
    }
    @Override
    public List<Picture> listPictureByAlbum(long albumId) {
      return albumDao.listPictureByAlbum(albumId);
    }
    @Override
    public List<Picture> listPictureByAlbumByPage(long albumId,PageContext pageContext) {
      return albumDao.listPictureByAlbumByPage(albumId,pageContext.getStart(),pageContext.getLength());
    }

    @Override
    public boolean createAlbum(String title,long userId,int authority,String Content) {
    User user=this.userDao.getUserByIdInitAlbumlocation(userId);
    Album album=new Album();
    album.setUser(user);
    for(Album albumiter:user.getAlbumlist())
    {
        if(albumiter.getTitle().equals(title))
            return false;
    }
    album.setTitle(title);
    album.setAuthority(authority);
    album.setContent(Content);
    String path="/tmp/user-photo/"+userId+"/"+title+"/";
    album.setImgpath(path);
    File filefolder=new File(path);
    if(!filefolder.exists())
        filefolder.mkdir();
    return     this.albumDao.insertAlbum(album);
    }

    @Override
    public boolean deleteAlbum(long albunid) {
        Album album=albumDao.getAlbumByIdInitialPic(albunid);
        for(Picture p:album.getPicturelist())
            pictureDao.deletePicture(p);
        album.getPicturelist().clear();
       return this.albumDao.deleteAlbum(albunid);
    }

    @Override
    public void addPhotoInAlbum(String filename, String content, long albumId) {
      Picture picture =new Picture();
      java.util.Date toDate=new java.util.Date();
      java.sql.Date sqlDate=new java.sql.Date(toDate.getTime());
      picture.setPath(filename);
      picture.setContent(content);
      picture.setCreateTime(sqlDate);
      this.pictureDao.insertPicture(picture);
      Album album=this.albumDao.getAlbumByIdInitialPic(albumId);
      album.getPicturelist().add(picture);
      picture.setAlbum(album);
      this.albumDao.updateAlbum(album);
    }

   @Override
    public Album getAlbumById(long albumid) {
        return this.albumDao.getAlbumByIdInitialPic(albumid);
    }

    @Override
    public void deletePhotoInAlbum(long  pId) {
        //Album album=this.albumDao.getAlbumByIdInitialPic(albumId);
        Picture picture=this.pictureDao.getPictureById(pId);
       Album album=picture.getAlbum();
        album.getPicturelist().remove(picture);
        this.pictureDao.deletePicture(picture);
        this.albumDao.updateAlbum(album);
        
    }

    @Override
    public Picture getPicById(long pid) {
      return  pictureDao.getPictureById(pid);
    }
    
    
     public AlbumDao getAlbumDao() {
        return albumDao;
    }

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    public PictureDao getPictureDao() {
        return pictureDao;
    }

    public void setPictureDao(PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    
}
