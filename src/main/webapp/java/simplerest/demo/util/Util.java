package simplerest.demo.util;

import com.google.gson.Gson;

public class Util {

    public static String toJson(Object object) {
        if (object != null) {
            Gson gson = new Gson();
            return gson.toJson(object);
        }
        return null;
    }
}
