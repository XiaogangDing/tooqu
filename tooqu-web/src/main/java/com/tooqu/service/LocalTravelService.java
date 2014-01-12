/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.LocalTravel;
import com.tooqu.entity.Place;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface LocalTravelService {

    public List<LocalTravel> getLocalTravelListByPage(PageContext pageContext);

    public LocalTravel findLocalTravelById(long lctrvId);

    public boolean createLocalTravel(long userId, String title, int maxpeople, int vehicletype, int feetype, Place place, String arrangement, String notice, String bookrule);

    public boolean deleteLocalTravel(LocalTravel lctrv);

    public boolean modifyLocalTravel(long lctrvId, String title, int maxpeople, int vehicletype, int feetype, Place place, String arrangement, String notice, String bookrule);
    
}
