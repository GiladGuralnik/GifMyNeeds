package com.gifmyneeds.activities.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.gifmyneeds.R;
import com.gifmyneeds.activities.child.AddChildActivity;
import com.gifmyneeds.activities.user.SelectCategoryForBoardActivity;
import com.gifmyneeds.adapters.ChildListAdapter;

import com.gifmyneeds.models.Child;

import java.util.ArrayList;

    public class ChildListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,View.OnClickListener {

        private static final String TAG = "Main";
        static final int REQUEST_ADDCHILD = 0;

        private ArrayList<Child> childsList;    //TODO get the list from parent
        private ChildListAdapter adapter;
        private Button btnAddChild,btnSeleChild;

        private ListView childListView;
        private SearchView childSearchView;
        private Child selectedChild;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.child_list_activity_layout);

            childListView = (ListView) findViewById(R.id.listView);
            childSearchView = (SearchView) findViewById(R.id.searchView);
            btnAddChild = (Button) findViewById(R.id.btnAddChild);
            btnSeleChild = (Button) findViewById(R.id.btnSelectChild);

            btnAddChild.setOnClickListener(this);
            btnSeleChild.setOnClickListener(this);
            childListView.setTextFilterEnabled(true);
            childListView.setAdapter(adapter);

            childsList = new ArrayList<>();
            adapter = new ChildListAdapter(this, R.layout.adapter_view_child_list_layout, childsList);


            childListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    selectedChild = adapter.getItem(position);
                    view.setSelected(true);
                    Log.d(TAG,selectedChild.getFullName());
                }
            });

////check/////////
            //Intent i = getIntent();
            //Person dene = (Person)i.getSerializableExtra("Person");
            //Log.d(TAG,dene.getName());
/////////////////
            addChild();

            setupSearchView();
        }


        @Override
        public boolean onQueryTextChange(String newText)
        {
            if (TextUtils.isEmpty(newText)) {
                childListView.clearTextFilter();
            } else {
                childListView.setFilterText(newText);
            }
            return true;
        }

        @Override
        public boolean onQueryTextSubmit(String query)
        {
            return false;
        }


        @Override
        protected void onResume() {
            super.onResume();
            ChildListAdapter adapter = new ChildListAdapter(this, R.layout.adapter_view_child_list_layout, childsList);
            childListView.setAdapter(adapter);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_ADDCHILD) {
                if (resultCode == RESULT_OK) {
                    Child incomingChild = (Child)data.getSerializableExtra("child");
                    childsList.add(incomingChild);
                }
            }
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.btnAddChild:
                    startActivityForResult(new Intent(ChildListActivity.this, AddChildActivity.class), REQUEST_ADDCHILD);
                    break;

                case R.id.btnSelectChild:
                    if (selectedChild!=null) {
                        //TODO send selectedChild object to next activity
                        //finish();
                    }
                    else
                        Toast.makeText(this,R.string.no_selected_child, Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnEditChildBoard:
                    if (selectedChild!=null) {
                        Intent i = new Intent(ChildListActivity.this, SelectCategoryForBoardActivity.class);
                        i.putExtra("id",selectedChild.getId());
                        startActivity(i);
                    }
                    else
                        Toast.makeText(this,R.string.no_selected_child, Toast.LENGTH_LONG).show();
                    break;
            }
        }

        private void setupSearchView()
        {
            childSearchView.setIconifiedByDefault(false);
            childSearchView.setOnQueryTextListener(this);
            childSearchView.setSubmitButtonEnabled(true);
            childSearchView.setQueryHint("Search Here");
        }

        private void addChild(){
            ///////////////////for check/////////////////////
            Child john = null;
            Child ron = null;
            Child mira = null;
            Child dana = null;
            Child mike = null;
            try {
                john = new Child("1234","John", "5", "זכר");
                ron = new Child("4321","Ron", "8", "זכר");
                mira = new Child("1122","Mira", "3", "נקבה");
                dana = new Child("1232","Dana", "2", "נקבה");
                mike = new Child("2233","Mike", "8", "זכר");

                childsList.add(john);
                childsList.add(ron);
                childsList.add(mira);
                childsList.add(dana);
                childsList.add(mike);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ///////////////////////////////////////////////
            //TODO add childs of the appropriate father from database to childsList
        }

    }
