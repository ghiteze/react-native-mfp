package com.ghiteze.mfp;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.util.Log;
import com.facebook.react.bridge.Promise;
import org.json.JSONObject;
import org.json.JSONException;
import com.facebook.react.bridge.ReadableMap;

import com.facebook.react.bridge.WritableMap;

import com.ghiteze.mfp.Utils;

public class TestModule extends ReactContextBaseJavaModule {

  public TestModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "TestModule";
  }

  @ReactMethod
  public void hello(String name, final Promise promise) {
    promise.resolve("Hello " + name);
  }

  @ReactMethod
  public void hihi(ReadableMap readableMap, final Promise promise) {
    try {
      JSONObject jsonObject = Utils.mapToJson(readableMap);

      WritableMap map = Utils.jsonToMap(jsonObject);

      promise.resolve(map);

    } catch (JSONException e) {
      promise.reject(e);
    }
  }

}
