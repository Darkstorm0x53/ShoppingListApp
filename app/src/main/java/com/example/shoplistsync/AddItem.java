package com.example.shoplistsync;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class AddItem extends AppCompatActivity
{
    EditText item, qty, info;
    Button confirmAdd, cancelAdd;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_item_entry);
        item = findViewById(R.id.edit_item_name);
        qty = findViewById(R.id.edit_item_quantity);
        info = findViewById(R.id.edit_item_notes);
        confirmAdd = findViewById(R.id.btnConfirmItemEntry);
        cancelAdd = findViewById(R.id.btnCancelItemEntry);

        confirmAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String itemTitle, amount, userInfo;
                itemTitle = item.getText().toString();
                amount = qty.getText().toString();
                userInfo = info.getText().toString();

                DbHandler dbHandler = new DbHandler(AddItem.this);
                dbHandler.insertItemDetails(itemTitle, amount, userInfo);

                intent = new Intent(AddItem.this, DbActivity.class);
                startActivity(intent);

            }
        });
    }
}