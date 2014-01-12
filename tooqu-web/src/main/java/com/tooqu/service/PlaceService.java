/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.entity.Place;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface PlaceService {
    public Place findPlaceByPlace(Place place);
    public Place findPlaceById(long pid);
    public Place findPlaceByProvinceCityCounty(String province,String city,String county);
    
    public List<String> getProvinceListByCountry(String country);

    public List<String> getCityListByProvince(String province);

    public List<String> getCountyListByCity(String city);
    
    
}
