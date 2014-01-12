/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web;

import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Guo
 */
public class JSONHelper {

    public static Object toModel(JSONObject obj) throws JSONException {
        return toMap(obj);
    }

    public static Object toModel(JSONArray obj) throws JSONException {
        return toList(obj);
    }

    private static Map<String, Object> toMap(JSONObject obj) throws JSONException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Iterator it = obj.keys();
        while (it.hasNext()) {
            String key = it.next().toString();
            Object value = obj.get(key);
            if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            } else if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }
            map.put(key, value);
        }
        return map;
    }

    private static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList(array.length());
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            } else if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }
            list.add(value);
        }
        return list;
    }
}