package huggychat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import io.huggy.chatsdk.HuggyChat;
import io.huggy.chatsdk.HuggyNotification;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class echoes a string called from JavaScript.
 */
public class HuggyChatBridge extends CordovaPlugin {

     @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.i("BRIDGE", action);

        if (action.equals("openHuggyChat")) {
            String sdkId = args.getString(0);
            String title = args.getString(1);
            this.openHuggyChat(sdkId, title, callbackContext);

            return true;
        }
        else if (action.equals("handleNotification")) {
            this.handleNotification();

            return true;
        }
        else if (action.equals("notify")) {
            Map<String, String> payload  = this.toMap(args.getJSONObject(0));

            String title = args.getString(1);
            String message = args.getString(1);

            this.notify(payload, title, message);

            return true;
        }
        else if (action.equals("notifyAppInForeground")) {
            this.notifyAppInForeground();

            return true;
        }
        else if (action.equals("notNotifyAppInForeground")) {
            this.notNotifyAppInForeground();

            return true;
        }
        else if (action.equals("execute")) {
            String method = args.getString(0);
            String params = args.getString(1);
            String[] paramsArray = params.split(";");
            
            this.execute(method, paramsArray);

            return true;
        }

        return false;
    }

    private static Map<String, String> toMap(JSONObject object) throws JSONException {
        Map<String, String> map = new HashMap<>();
        Iterator keys = object.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            map.put(key, object.get(key).toString());
        }
        return map;
    }

    private void openHuggyChat(String sdkId, String title, CallbackContext callbackContext) {
        HuggyChat.getInstance(sdkId);
        
        Context context = this.cordova.getActivity().getApplicationContext();
        Intent intent = new Intent(context, huggychat.HuggyChatActivity.class);

        Bundle b = new Bundle();
        b.putString("title", title);
        b.putString("actionBarBackground", preferences.getString("huggychatActionBarBackgroundColor", "#FFFFFF"));
        b.putString("actionBarText", preferences.getString("huggychatActionBarTextColor", "#000000"));
        intent.putExtras(b);

        this.cordova.getActivity().startActivity(intent);
    }

    private void handleNotification(){
        Context context = this.cordova.getActivity().getApplicationContext();

        HuggyNotification.getInstance(context);
    }

    private void notify(Map<String,String> payload, String title, String message) {        
        Context context = this.cordova.getActivity().getApplicationContext();
        Bundle bundle = this.cordova.getActivity().getApplicationInfo().metaData;
        HuggyNotification.getInstance(context).notify(payload, bundle.getInt("io.huggy.chatsdk.notification_icon"), title, message);
    }

    public HuggyNotification notifyAppInForeground() {
        HuggyNotification.getInstance().notifyAppInForeground();

        return HuggyNotification.getInstance();
    }

    public HuggyNotification notNotifyAppInForeground() {
        HuggyNotification.getInstance().notNotifyAppInForeground();
        
        return HuggyNotification.getInstance();
    }

    public void execute(String function, String args[]) {
        HuggyChat.getInstance().callApiMethod(function, args);
    }
}
