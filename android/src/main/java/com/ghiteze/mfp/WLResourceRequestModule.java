package com.ghiteze.mfp;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.bridge.Promise;
import com.worklight.wlclient.api.WLResourceRequest;

public class WLResourceRequestModule extends ReactContextBaseJavaModule {

  public WLResourceRequestModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "WLResourceRequestModule";
  }

  @ReactMethod
  public void hello(String name, final Promise promise) {
    promise.resolve("Hello " + name);
  }
}
