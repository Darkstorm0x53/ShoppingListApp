package com.example.shoplistsync;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnlog;
    Button btnjoin;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlog = findViewById(R.id.btnlog);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        btnjoin = findViewById(R.id.btnjoin);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText1.getText().toString().equals("admin") &&
                editText2.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(), "Authenticated",
                            Toast.LENGTH_SHORT).show();
                }
                else if (editText1.getText().toString().equals("admin") &&
                        !editText2.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(), "Wrong password",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Unrecognised User", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new RegFragment());
            }
        });
        }

        private void loadFragment(Fragment fragment){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
        }
    }
