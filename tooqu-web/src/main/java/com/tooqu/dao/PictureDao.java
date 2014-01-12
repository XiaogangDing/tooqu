/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Album;
import com.tooqu.entity.Picture;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface PictureDao {
  public void insertPicture(Picture picture);
  public Picture getPictureById(long pid);
    public void deletePicture(Picture picture);
}
