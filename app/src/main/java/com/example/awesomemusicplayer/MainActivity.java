package com.example.awesomemusicplayer;

import android.os.Bundle;
import android.view.Menu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //1).Find the Toolbar
        com.google.android.material.appbar.MaterialToolbar toolbar= findViewById(R.id.toolbar);

        //2).Set Actionbar (so the Inflation works)
        setSupportActionBar(toolbar);

        //3).Set the program the overflow icon
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this,R.drawable.ic_more_vert));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;

    }
}