package com.gifmyneeds.activities.menus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gifmyneeds.R;
import com.gifmyneeds.activities.child.GifBoardActivity;
import com.gifmyneeds.models.ChildGifs;

import java.util.ArrayList;

import java.util.List;

import static com.gifmyneeds.utilities.SharedConstants.getChildGifsListFromSharedPreference;

public class ChildMenuActivity extends AppCompatActivity {
    private SharedPreferences table_childes_gif;
    private List<ChildGifs> childGifs;
    private ArrayList<String> categories;
    private ArrayList<Integer> images;

    private GridView gridView;

    public ChildMenuActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_menu_activity_layout);

        gridView = findViewById(R.id.gridview);
        categories = new ArrayList<>();
        images = new ArrayList<>();

       //add();

        final Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        childGifs = getChildGifsListFromSharedPreference(id, table_childes_gif);

        addCatagogyToList();
        addImageToList();

        CustomAdapter customAdpter = new CustomAdapter();
        gridView.setAdapter(customAdpter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent instant = new Intent(ChildMenuActivity.this, GifBoardActivity.class);
                instant.putExtra("childGif", childGifs.get(position));
                startActivity(instant);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View viewl = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView name = viewl.findViewById(R.id.fruits);
            ImageView image = viewl.findViewById(R.id.images);

            name.setText((categories.get((position))));
            image.setImageResource(images.get(position));

            return viewl;
        }
    }

    void addCatagogyToList() {
        String str = null;
        for (ChildGifs obj : childGifs) {
            str = obj.getCategory();
            categories.add(str);
        }
    }

    void addImageToList() {
        for (String obj : categories) {
            int resID = getResources().getIdentifier(obj , "drawable", getPackageName());
            images.add(resID);
        }
    }

/**
     void add() {
     table_childes_gif = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
     ArrayList<String> category_list = new ArrayList<String>();

     String[] array = {"bla1", "bla2", "bla3"};

     ArrayList<String> lst = new ArrayList<String>(Arrays.asList(array));

     String child_id = "1234";

     List<ChildGifs> testList = new ArrayList<ChildGifs>();

     ChildGifs obj = new ChildGifs(child_id, "eat", lst);
     ChildGifs obj1 = new ChildGifs(child_id, "drink", lst);

     testList.add(obj);
     testList.add(obj1);

     Gson gson = new Gson();
     String json = gson.toJson(testList);

     SharedPreferences.Editor editor = table_childes_gif.edit();

     //editor.clear();

     editor.putString(child_id, json);

     editor.commit();
     }
**/
}