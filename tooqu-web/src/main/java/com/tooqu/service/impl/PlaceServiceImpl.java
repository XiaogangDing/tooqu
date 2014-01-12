/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.dao.PlaceDao;
import com.tooqu.entity.Place;
import com.tooqu.service.PlaceService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class PlaceServiceImpl implements PlaceService{
    private PlaceDao placeDao;

    public PlaceDao getPlaceDao() {
        return placeDao;
    }

    public void setPlaceDao(PlaceDao placedao) {
        this.placeDao = placedao;
    }
    @Override
    public Place findPlaceByPlace(Place place){
        return placeDao.getPlace(place);
    }

    @Override
    public Place findPlaceById(long pid) {
       return placeDao.findPlaceById(pid);
    }

    @Override
    public List<String> getProvinceListByCountry(String country) {
       List<String> result=new ArrayList<String>();
       List<Place> tmp=this.placeDao.getPlaceListByCountry(country);
       for(int i=0;i<tmp.size();i++){
           if(!result.contains(tmp.get(i).getProvince())){
           result.add(tmp.get(i).getProvince());
       }
      }
       return result;
    }

    @Override
    public List<String> getCityListByProvince(String province) {
     List<String> result=new ArrayList<String>();
       List<Place> tmp=this.placeDao.getPlaceListByProvince(province);
       for(int i=0;i<tmp.size();i++){
           if(!result.contains(tmp.get(i).getCity())){
           result.add(tmp.get(i).getCity());
       }
      }
       return result;
    }

    @Override
    public List<String> getCountyListByCity(String city) {
         List<String> result=new ArrayList<String>();
       List<Place> tmp=this.placeDao.getPlaceListByCity(city);
       for(int i=0;i<tmp.size();i++){
           if(!result.contains(tmp.get(i).getCounty())){
           result.add(tmp.get(i).getCounty());
       }
      }
       return result;
    }

    @Override
    public Place findPlaceByProvinceCityCounty(String province,String city, String county) {
     return  placeDao.findPlaceByProvinceCityCounty(province,city,county);
    }




    
}
