package web.tools;

import org.json.JSONObject;

/**
 * Created by kylin on 03/12/2016.
 * All rights reserved.
 */
public class MyResponse {

    public static String success(Object data){
        JSONObject object = new JSONObject();
        object.put("condition","success");
        object.put("data",data);
        return object.toString();
    }

    public static String failure(String errorCode,String message,Object data){
        JSONObject object = new JSONObject();
        object.put("condition","fail");
        object.put("error_code",errorCode);
        object.put("message",message);
        object.put("data",data);
        return object.toString();
    }

}
