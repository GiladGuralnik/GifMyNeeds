package com.gifmyneeds.utilities;

import android.content.SharedPreferences;
import com.gifmyneeds.models.ChildGifs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class SharedConstants {

    static public List<ChildGifs> getChildGifsListFromSharedPreference(String child_id, SharedPreferences shared_childes_gif){

        // take out all child gifs into a json
        Gson gson = new Gson();
        String json = shared_childes_gif.getString(child_id, "");

        // convert json to list
        Type type = new TypeToken<List<ChildGifs>>(){}.getType();
        List<ChildGifs> list_of_gif = gson.fromJson(json, type);

        return list_of_gif;
    }
}
