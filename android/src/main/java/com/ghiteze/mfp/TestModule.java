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
import com.facebook.react.bridge.ReadableMapKeySetIterator;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

import com.ghitze.mfp.Utils;

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
  public void hihi(ReadableMap readableMap, final Promise promise) throws JSONException {
    try {
      JSONObject object = new JSONObject();
      ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
      WritableMap map = new WritableNativeMap();

      while (iterator.hasNextKey()) {
        String key = iterator.nextKey();
        switch (readableMap.getType(key)) {
          case Null:
            object.put(key, JSONObject.NULL);
            break;
          case Boolean:
            object.put(key, readableMap.getBoolean(key));
            break;
          case Number:
            object.put(key, readableMap.getDouble(key));
            break;
          case String:
            object.put(key, readableMap.getString(key));
            break;
        }
      }

      Log.d("Object", "O" + object);

      map.putString("name", "my name");
      map.putInt("age", 10001);

      Log.d("Object", "O1" + map);

      promise.resolve(map);

    } catch (JSONException e) {
      Log.d("Error", "E" + e);
      promise.reject(e);
    }
  }

}
