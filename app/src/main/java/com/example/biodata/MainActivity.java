package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnEmail, btnMap, btnCall;

        btnEmail = findViewById(R.id.btnEmail);
        btnMap = findViewById(R.id.btnMap);
        btnCall = findViewById(R.id.btnCall);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email(view);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lokasi(view);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telepon(view);
            }
        });
    }

    public void lokasi(View v) {
        Intent map = new Intent(Intent.ACTION_VIEW);
        String url = "https://www.google.com/maps/place/Kezia+snack/@-6.9930194,110.4562303,17z/data=!3m1!4b1!4m5!3m4!1s0x2e708df2a01d172f:0xfa3de94d80439775!8m2!3d-6.9930194!4d110.458419";
        map.setData(Uri.parse(url));
        startActivity(map);
    }

    public void telepon(View v) {
        String phone = "085727794099";
        Intent tel = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(tel);
    }

    public void email(View v) {
        Intent email = new Intent(Intent.ACTION_SENDTO);
        Uri uri = Uri.parse("mailto:111202113533@mhs.dinus.ac.id");
        email.setData(uri);
        email.putExtra("subject", "my subject");
        email.putExtra("body", "my message");
        startActivity(Intent.createChooser(email, "Send feedback"));
    }
}