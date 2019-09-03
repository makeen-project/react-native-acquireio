package com.acquire;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.acquireio.AcquireApp;
import com.acquireio.callbacks.UnreadMessageCount;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import org.json.JSONException;
import org.json.JSONObject;

public class RNAcquireIoModule extends ReactContextBaseJavaModule implements UnreadMessageCount {

  private final ReactApplicationContext reactContext;

  public RNAcquireIoModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAcquireIo";
  }

  @ReactMethod
  public void init(String accountId) {
    AcquireApp.init(this.getCurrentActivity().getApplication(), accountId);
    AcquireApp.getInstance().setUnreadCountListner(this);
  }

  @ReactMethod
  public void startSupportChat() {
    AcquireApp.getInstance().startSupportChat();
  }

  @ReactMethod
  public void setVisitorDetail(String name, String email, String phone, String rawPayload) {
    try {
      JSONObject payload = new JSONObject(rawPayload);
      AcquireApp.setVisitorDetail(name, email, phone, payload);
    } catch (JSONException err) {
    }
  }

  @ReactMethod
  public void logOut() {
    AcquireApp.logOut();
  }

  @ReactMethod
  public void setFireBaseToken(String token) {
    AcquireApp.setFireBaseToken(token);
  }

  @Override
  public void updateUnreadMessageCount(final int count) {
    this.reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit("onAcquireIOUnreadMessageCountChange", count);
  }
}