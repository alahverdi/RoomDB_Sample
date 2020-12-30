package ir.allahverdi.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.channels.AsynchronousByteChannel;

import ir.allahverdi.roomexample.database.MyRoomDb;
import ir.allahverdi.roomexample.entity.User;

public class InsertUserActivity extends AppCompatActivity {

    EditText et_firstName,
            et_lastName,
            et_email,
            et_phone;
    Button btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);

        initViews();

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // insert user into RoomDb
                User user = new User();

                user.setFirstName(et_firstName.getText().toString().trim());
                user.setLastName(et_lastName.getText().toString().trim());
                user.setEmail(et_email.getText().toString().trim());
                user.setPhoneNumber(Long.valueOf(et_phone.getText().toString().trim()));

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        MyRoomDb.getInstance(InsertUserActivity.this)
                                .userDAO()
                                .insert(user);
                    }
                });
            }
        });
    }

    private void initViews() {
        et_firstName = findViewById(R.id.et_firstName);
        et_lastName = findViewById(R.id.et_lastName);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        btn_insert = findViewById(R.id.btn_insert);
    }

}