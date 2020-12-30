package ir.allahverdi.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InsertUserActivity extends AppCompatActivity {

    EditText et_firsrName,
            et_lastName,
            et_email,
            et_phone;
    Button btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);

        initViews();
    }

    private void initViews() {
        et_firsrName = findViewById(R.id.et_firsrName);
        et_lastName = findViewById(R.id.et_lastName);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        btn_insert = findViewById(R.id.btn_insert);
    }

}