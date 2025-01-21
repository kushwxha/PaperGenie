package com.example.papergenie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PastpaperPage extends AppCompatActivity {

    private paperAdapter paperAdapter;
    private DatabaseReference databaseReference;
    private List<Paper> paperList;
    private RecyclerView recyclerView;
    private  ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastpaper_page);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        paperList = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Data");
        progressDialog.setCancelable(false);
        progressDialog.show();



        databaseReference = FirebaseDatabase.getInstance().getReference("pdfFiles");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                paperList.clear();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Paper paper = snapshot.getValue(Paper.class);
                    paperList.add(paper);
                }
                paperAdapter = new paperAdapter(PastpaperPage.this, paperList);
                recyclerView.setAdapter(paperAdapter);

                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }

                paperAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                Toast.makeText(PastpaperPage.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }


}