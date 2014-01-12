/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.Album;
import com.tooqu.entity.Picture;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface AlbumService {

    public List<Album> listAlbumByUser(long userId);
   public List<Album> listAlbumByUserByPage(long userId,PageContext pageContext);

    public List<Picture> listPictureByAlbum(long albumId);
    public List<Picture> listPictureByAlbumByPage(long albumId,PageContext pageContext);

    public boolean createAlbum(String title,long userId,int authority,String Content);
    public Album getAlbumById(long albumid);
    public Picture getPicById(long pid);
    public boolean deleteAlbum(long albunid);

    public void addPhotoInAlbum(String filename, String content,long albumId);

    public void deletePhotoInAlbum(long pid);

    
}
