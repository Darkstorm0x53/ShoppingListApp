package com.example.shoplistsync;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    Button btnlog;
    Button btnjoin;
    EditText editText1;
    EditText editText2;

    public void emptyCredentials()
   {
       editText1.setText(""); // make text null on activity access
       editText2.setText(""); // make text null on activity access
   }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlog = findViewById(R.id.btnlog); // login button
        btnjoin = findViewById(R.id.btnjoin); // register button
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        final Intent[] authenticated = new Intent[1];

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(editText1.getText().toString().equals("admin") &&
                editText2.getText().toString().equals("admin"))
                {
                    authenticated[0] = new Intent(MainActivity.this, DbActivity.class);
                    startActivity(authenticated[0]);
                }
                else if (editText1.getText().toString().equals("admin") &&
                        !editText2.getText().toString().equals("admin"))
                {
                    Toast.makeText(getApplicationContext(), "Wrong password",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Unrecognised User",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnjoin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadFragment(new RegFragment());
            }
        });
    }

        private void loadFragment(Fragment fragment)
        {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
        }
    }
