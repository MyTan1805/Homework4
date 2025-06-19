package com.project.homework4;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CardView cardLeaders;
    private CardView cardMuseums;
    private CardView cardWonders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bước 1: Ánh xạ các CardView từ layout XML bằng ID
        // Khai báo các biến cho CardView
        CardView cardCountries = findViewById(R.id.card_countries);
        cardLeaders = findViewById(R.id.card_leaders);
        cardMuseums = findViewById(R.id.card_museums);
        cardWonders = findViewById(R.id.card_wonders);

        // Bước 2: Gán sự kiện click cho từng CardView
        // Cách làm này sử dụng lambda expressions, rất gọn gàng và hiện đại.
        cardCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở CountriesActivity
                Intent intent = new Intent(MainActivity.this, CountriesActivity.class);
                startActivity(intent);
            }
        });

        cardLeaders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở LeadersActivity
                Intent intent = new Intent(MainActivity.this, LeadersActivity.class);
                startActivity(intent);
            }
        });

        cardMuseums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở MuseumsActivity
                Intent intent = new Intent(MainActivity.this, MuseumsActivity.class);
                startActivity(intent);
            }
        });

        cardWonders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở WondersActivity
                Intent intent = new Intent(MainActivity.this, WondersActivity.class);
                startActivity(intent);
            }
        });
    }
}