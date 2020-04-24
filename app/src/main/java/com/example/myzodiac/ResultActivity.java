package com.example.myzodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvSign;
    ImageView ivSign;
    Button btnSearch;

    String zodiac;
    final String website="https://www.astrology-zodiac-signs.com/zodiac-signs/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvSign=findViewById(R.id.tvSign);
        ivSign=findViewById(R.id.ivSign);
        btnSearch=findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse(website+zodiac);
                Intent intent=new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        setZodiac();
        tvSign.setText(zodiac.toUpperCase());
        setImage();

    }

    private void setZodiac()
    {
        int day,month;
        day=getIntent().getIntExtra("day",1);
        month=getIntent().getIntExtra("month",1);

        switch(month)
        {
            case 1:
                if(day<20) zodiac="capricorn";
                else  zodiac="aquarius"; break;
            case 2:
                if(day<19) zodiac="aquarius";
                else  zodiac="pisces"; break;
            case 3:
                if(day<21) zodiac="pisces";
                else  zodiac="aries"; break;
            case 4:
                if(day<20) zodiac="aries";
                else  zodiac="taurus"; break;
            case 5:
                if(day<21) zodiac="taurus";
                else  zodiac="gemini"; break;
            case 6:
                if(day<21) zodiac="gemini";
                else  zodiac="cancer"; break;
            case 7:
                if(day<23) zodiac="cancer";
                else  zodiac="leo"; break;
            case 8:
                if(day<23) zodiac="leo";
                else  zodiac="virgo"; break;
            case 9:
                if(day<23) zodiac="virgo";
                else  zodiac="libra"; break;
            case 10:
                if(day<23) zodiac="libra";
                else  zodiac="scorpio"; break;
            case 11:
                if(day<22) zodiac="scorpio";
                else  zodiac="sagittarius"; break;
            case 12:
                if(day<22) zodiac="sagittarius";
                else  zodiac="capricorn"; break;
        }
    }

    private void setImage()
    {
        switch (zodiac)
        {
            case "aries":
                ivSign.setImageResource(R.drawable.aries);
                break;
            case "taurus":
                ivSign.setImageResource(R.drawable.taurus);
                break;
            case "gemini":
                ivSign.setImageResource(R.drawable.gemini);
                break;
            case "cancer":
                ivSign.setImageResource(R.drawable.cancer);
                break;
            case "leo":
                ivSign.setImageResource(R.drawable.leo);
                break;
            case "virgo":
                ivSign.setImageResource(R.drawable.virgo);
                break;
            case "libra":
                ivSign.setImageResource(R.drawable.libra);
                break;
            case "scorpio":
                ivSign.setImageResource(R.drawable.scorpio);
                break;
            case "sagittarius":
                ivSign.setImageResource(R.drawable.sagittarius);
                break;
            case "capricorn":
                ivSign.setImageResource(R.drawable.capricorn);
                break;
            case "aquarius":
                ivSign.setImageResource(R.drawable.aquarius);
                break;
            default:
                ivSign.setImageResource(R.drawable.pisces);
        }
    }
}
