/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.LocalTravel;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface LocalTravelDao {

    public List<LocalTravel> listLocalTravelByPage(int start, int length);

    public LocalTravel getLocalTravelById(long lctrvId);

    public boolean insertLocalTravel(LocalTravel lctrvl);

    public boolean deleteLocalTravel(LocalTravel lctrv);

    public boolean updateLocalTravel(LocalTravel lctrvl);
    
}
