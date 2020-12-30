package ir.allahverdi.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import ir.allahverdi.roomexample.database.MyRoomDb;
import ir.allahverdi.roomexample.entity.User;

public class MainActivity extends AppCompatActivity {

    List<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                list = MyRoomDb.getInstance(MainActivity.this)
                        .userDAO()
                        .getAll();
            }
        });
        return list;
    }
}