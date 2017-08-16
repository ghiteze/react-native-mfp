package com.ghiteze.mfp;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;

import com.facebook.react.bridge.ReadableMapKeySetIterator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

import org.json.JSONException;


public class Utils {

  // convert json to native map
  public static WritableMap jsonToMap(JSONObject jsonObject) throws JSONException {
    WritableMap map = new WritableNativeMap();

    Iterator<String> iterator = jsonObject.keys();

    while (iterator.hasNext()) {
      String key = iterator.next();
      Object value = jsonObject.get(key);

      if (value instanceof JSONObject) {
        map.putMap(key, jsonToMap((JSONObject) value));
      }
      else if (value instanceof  JSONArray) {
        map.putArray(key, jsonToArray((JSONArray) value));
      }
      else if (value instanceof  Boolean) {
        map.putBoolean(key, (Boolean) value);
      }
      else if (value instanceof  Integer) {
        map.putInt(key, (Integer) value);
      }
      else if (value instanceof  Double) {
        map.putDouble(key, (Double) value);
      }
      else if (value instanceof String)  {
        map.putString(key, (String) value);
      }
      else {
        map.putString(key, value.toString());
      }
    }

    return map;
  }

  // convert json to native array
  public static WritableArray jsonToArray(JSONArray jsonArray) throws JSONException {
    WritableArray array = new WritableNativeArray();

    for (int i = 0; i < jsonArray.length(); i++) {
      Object value = jsonArray.get(i);

      if (value instanceof JSONObject) {
        array.pushMap(jsonToMap((JSONObject) value));
      }
      else if (value instanceof  JSONArray) {
        array.pushArray(jsonToArray((JSONArray) value));
      }
      else if (value instanceof  Boolean) {
        array.pushBoolean((Boolean) value);
      }
      else if (value instanceof  Integer) {
        array.pushInt((Integer) value);
      }
      else if (value instanceof  Double) {
        array.pushDouble((Double) value);
      }
      else if (value instanceof String)  {
        array.pushString((String) value);
      }
      else {
        array.pushString(value.toString());
      }
    }

    return array;
  }

  // convert native map to json object
  public static JSONObject mapToJson(ReadableMap readableMap) throws JSONException {
    JSONObject jsonObject = new JSONObject();

    ReadableMapKeySetIterator iterator = readableMap.keySetIterator();

    while (iterator.hasNextKey()) {
      String key = iterator.nextKey();

      switch (readableMap.getType(key)) {
        case Null:
          jsonObject.put(key, JSONObject.NULL);
          break;
        case Boolean:
          jsonObject.put(key, readableMap.getBoolean(key));
          break;
        case Number:
          jsonObject.put(key, readableMap.getDouble(key));
          break;
        case String:
          jsonObject.put(key, readableMap.getString(key));
          break;
        case Map:
          jsonObject.put(key, mapToJson(readableMap.getMap(key)));
          break;
        case Array:
          jsonObject.put(key, arrayToJson(readableMap.getArray(key)));
          break;
      }
    }

    return jsonObject;
  }

  // convert native array to json array
  public static JSONArray arrayToJson(ReadableArray readableArray) throws JSONException {
    JSONArray jsonArray = new JSONArray();

    for (int i = 0; i < readableArray.size(); i++) {
      switch (readableArray.getType(i)) {
        case Null:
          break;
        case Boolean:
          jsonArray.put(readableArray.getBoolean(i));
          break;
        case Number:
          jsonArray.put(readableArray.getDouble(i));
          break;
        case String:
          jsonArray.put(readableArray.getString(i));
          break;
        case Map:
          jsonArray.put(mapToJson(readableArray.getMap(i)));
          break;
        case Array:
          jsonArray.put(arrayToJson(readableArray.getArray(i)));
          break;
      }
    }

    return jsonArray;
  }
}
