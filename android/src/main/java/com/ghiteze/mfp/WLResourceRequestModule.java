package com.ghiteze.mfp;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.bridge.Promise;
import com.worklight.wlclient.api.WLResourceRequest;
import org.json.JSONException;
import java.net.URI;
import android.util.Log;

import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import com.facebook.react.uimanager.IllegalViewOperationException;

public class WLResourceRequestModule extends ReactContextBaseJavaModule {

  public WLResourceRequestModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "WLResourceRequestModule";
  }

  @ReactMethod
  public void makeRequest(String url, String method, final Promise promise) {
    try {
      WLResourceRequest request = new WLResourceRequest(URI.create(url), method);
      request.send(new WLResponseListener() {
        public void onSuccess(WLResponse response) {
          promise.resolve(response.getResponseText());
          Log.d("Success", response.getResponseText());
        }
        public void onFailure(WLFailResponse response) {
          promise.reject(response.getErrorStatusCode(), response.getErrorMsg());
          Log.d("Failure", response.getErrorMsg());
        }
      });

    } catch (IllegalViewOperationException e) {
      promise.reject("failure" , e.getMessage(), e);
    }
  }
}
