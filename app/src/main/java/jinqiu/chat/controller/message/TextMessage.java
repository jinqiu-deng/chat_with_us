package jinqiu.chat.controller.message;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class TextMessage {

    public TextMessage(String message) throws JSONException {
        JSONObject jsonValue = new JSONObject(message);
        this.context = jsonValue.getString(CONTEXT);
        this.timestamp = jsonValue.getLong(TIME_STAMP);
        this.userType = jsonValue.getInt(USER_TYPE);
    }

    public TextMessage(int userType, Long timestamp, String context) {
        this.userType = userType;
        this.timestamp = timestamp;
        this.context = context;
    }

    @Override
    public String toString() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(USER_TYPE, this.userType);
            jsonObject.put(TIME_STAMP, this.timestamp);
            jsonObject.put(CONTEXT, this.context);
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i(TAG, "Cannot convert to Json string");
            return "";
        }
    }

    public int getUserType() {
        return userType;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getContext() {
        return context;
    }

    final private static String USER_TYPE = "USER_TYPE";
    final public static int CLIENT = 0;
    final public static int COMPANY = 1;
    private int userType;

    final private static String TIME_STAMP = "TIME_STAMP";
    private Long timestamp; // epoch

    final private static String CONTEXT = "CONTEXT";
    private String context;

    private static final String TAG = "TextMessage";
}