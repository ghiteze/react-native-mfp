package com.ghiteze.mfp;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import org.json.JSONException;


public class Utils {

  // convert json to native map
  public static WritableMap jsonToMap(JSONObject jsonObject) throws JSONException {
    WritableMap map = new WritableNativeMap();
    return map;
  }

  // convert json to native array
  public static WritableArray jsonToArray(JSONArray jsonArray) throws JSONException {
    WritableArray array = new WritableNativeArray();
    return array;
  }

  // convert native map to json object
  public static JSONObject mapToJson(ReadableMap readableMap) throws JSONException {
    JSONObject jsonObject = new JSONObject();
    return jsonObject;
  }

  // convert native array to json array
  public static JSONArray arrayToJson(ReadableArray readableArray) throws JSONException {
    JSONArray jsonArray = new JSONArray();
    return jsonArray;
  }
}
