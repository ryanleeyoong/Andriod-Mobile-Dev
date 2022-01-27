package com.example.week2cet3013nlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declare GUI view elements
    private EditText text_name;
    private EditText text_password;
    private Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link to the GUI element in XML file(layout file)
        text_name      = findViewById(R.id.text_username);
        text_password  = findViewById(R.id.text_password);
        button_login   = findViewById(R.id.button_login);  //R is repository file

        //provide a simple event handling
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get user input
                String name = text_name.getText().toString(); //Kotlin: val name = text_name.text.toString()
                String password = text_password.getText().toString();

                //Check the name and password length
                if(name.length() > 4 ){
                    if (password.length() >= 4) {
                        Toast.makeText(getApplicationContext(), "Welcome" + name,
                                Toast.LENGTH_LONG).show();
                    }//inner if
                    else{
                        text_password.setError("Weak Password");
                        text_password.requestFocus();
                    }
                }//end if
                else{
                    text_name.setError("Weak Username");
                    text_name.requestFocus();
                }
            }
        });


    }//end of onCreate
}//end of class