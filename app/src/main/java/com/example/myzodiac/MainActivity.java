package com.example.myzodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etDate;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDate=findViewById(R.id.etDate);
        btnSubmit=findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date=etDate.getText().toString();
                if(date.isEmpty())  //User didn't enter anything
                {
                    Toast.makeText(MainActivity.this,"Enter the Date",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(date.length()!=10) //Input Format was wrong i.e. not in dd-mm-yyyy
                {
                    Toast.makeText(MainActivity.this,"Incorrect Format",Toast.LENGTH_SHORT).show();
                    return;
                }
                int day,month;
                day=Integer.parseInt(date.substring(0,2));
                month=Integer.parseInt(date.substring(3,5));
                boolean isCorrect=dateCheck(day,month);
                if(isCorrect) //if the enterd date is correct
                {
                    Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra("day",day);
                    intent.putExtra("month",month);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this,"Incorrect Date",Toast.LENGTH_SHORT).show();


            }
        });
    }

    private boolean dateCheck(int day,int month)
    {
        if(day<1||day>31||month<1||month>12)
            return false;

        switch(month)
        {
            case 4:
            case 6:
            case 9:
            case 11:
             if(day==31)
                 return false;
            case 2:
                if(day>29)
                    return false;

        }
        return true;
    }
}
