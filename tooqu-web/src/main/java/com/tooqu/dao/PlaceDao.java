/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Place;
import java.util.List;

/**
 *
 * @author hds09
 */
public interface PlaceDao {
    public Place getPlace(Place place);
    public Place findPlaceById(long id);
    public Place findPlaceByProvinceCityCounty(String province,String city,String county);
    public List<Place> getPlaceListByCountry(String country);
    public List<Place> getPlaceListByProvince(String province);
    public List<Place> getPlaceListByCity(String city);
}
