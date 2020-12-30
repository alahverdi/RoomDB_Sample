package ir.allahverdi.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.allahverdi.roomexample.adapter.AdapterListview;
import ir.allahverdi.roomexample.database.MyRoomDb;
import ir.allahverdi.roomexample.entity.User;

public class MainActivity extends AppCompatActivity {

    List<User> list = new ArrayList<>();

    AdapterListview adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new MyAsync().execute();
    }

    private void initViews() {
        listView = findViewById(R.id.listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Insert").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, InsertUserActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    class MyAsync extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... voids) {
            list = (List<User>) MyRoomDb.getInstance(MainActivity.this)
                    .userDAO()
                    .getAll();
            return list;
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            adapter = new AdapterListview(MainActivity.this, (ArrayList<User>) list);
            listView.setAdapter(adapter);
        }
    }

}