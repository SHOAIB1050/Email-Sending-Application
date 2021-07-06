package com.example.bscsmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText subject;
    EditText message;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().isEmpty() && !subject.getText().toString().isEmpty() && !message.getText().toString().isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, new String[]{subject.getText().toString()});
                    intent.putExtra(Intent.EXTRA_TEXT, new String[]{message.getText().toString()});
                    //intent.setType("message/rfc822");
                    intent.setData(Uri.parse("mailto:"));
                    if(intent.resolveActivity(getPackageManager())!= null){
                        startActivity(intent);
                    }

                }
                else {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}