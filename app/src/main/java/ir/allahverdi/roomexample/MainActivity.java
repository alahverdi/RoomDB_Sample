package ir.allahverdi.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ir.allahverdi.roomexample.adapter.AdapterListview;
import ir.allahverdi.roomexample.database.MyRoomDb;
import ir.allahverdi.roomexample.entity.User;

public class MainActivity extends AppCompatActivity {

    List<User> list = new ArrayList<>();
    User user = new User();

    AdapterListview adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        selectFromDb();
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

    private List<User> getDataFromDb() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                list = (List<User>) MyRoomDb.getInstance(MainActivity.this)
                        .userDAO()
                        .getAll();
            }
        });
        return list;
    }

    private void selectFromDb() {
        Log.e("TAG", "\n\nselectFromDb: \n\n" + list);
        adapter = new AdapterListview(this, (ArrayList<User>) list);
        listView.setAdapter(adapter);
    }
}