package com.example.intentdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class SecondActivity extends AppCompatActivity {
    public  static  final  String NAME = "NAME";
    public static  final String AGE = "AGE";
    private TextView nameText,ageText;
    private String name;
    private   int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acivity);
        nameText = findViewById(R.id.mName);
        ageText = findViewById( R.id.mAge);


        Intent i = getIntent();

        name = i.getStringExtra(NAME);
        age = i.getIntExtra(AGE, 0);

        nameText.setText("hii!" +name);
        ageText.setText("your age is" +age);


    }
    public  void  onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Confirm Exit");

        alertDialogBuilder.setIcon(R.drawable.ic_exit);

        alertDialogBuilder.setMessage("Are You Sure You Want to Exit ?");

        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(SecondActivity.this,"You Clicked on cancel",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}