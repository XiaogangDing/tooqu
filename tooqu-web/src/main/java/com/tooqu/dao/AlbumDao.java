/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Album;
import com.tooqu.entity.Picture;
import com.tooqu.entity.User;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface AlbumDao {
  public List<Album> getAlbumByUser(long userid);
  public List<Album> listAlbumByUserByPage(long userid,int start,int length);
  public boolean insertAlbum(Album album);
  public List<Picture> listPictureByAlbum(long albumid);
  public List<Picture> listPictureByAlbumByPage(long albumid,int start,int length);
  public boolean deleteAlbum(long album);
  public Album getAlbumByIdInitialPic(long albumid);
  public void updateAlbum(Album album);
}
