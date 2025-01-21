package com.example.papergenie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
    CardView newPaper,pastPaper;
    MaterialButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        newPaper = findViewById(R.id.newPaperCard);
        pastPaper = findViewById(R.id.pastPaperCard);
        logout = findViewById(R.id.logoutBtn);

        newPaper.setOnClickListener(this);
        pastPaper.setOnClickListener(this);
        logout.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent i;
        int id = v.getId();
        if(id == R.id.newPaperCard){
            i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.pastPaperCard) {
            i = new Intent(this, PastpaperPage.class);
            startActivity(i);
        }else if(id == R.id.logoutBtn){
            FirebaseAuth.getInstance().signOut();
            i = new Intent(getApplicationContext(), LoginPage.class);
            startActivity(i);
        }
    }
}