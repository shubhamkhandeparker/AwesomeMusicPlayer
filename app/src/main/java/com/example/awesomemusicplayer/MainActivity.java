package com.example.awesomemusicplayer;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.Toast;

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

        //4).Previous button
        ImageButton btnPrev=findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(v->{
            Toast.makeText(this,"Go TO Previous",Toast.LENGTH_SHORT).show();
        });

        //5).Play button Center
        ImageButton btnPlayCenter=findViewById(R.id.btnPlayCenter);
        btnPlayCenter.setOnClickListener(v->{
            Toast.makeText(this,"Play/Pause toggled",Toast.LENGTH_SHORT).show();
        });

        //6).Next Button
        ImageButton btnNext=findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v->{
            Toast.makeText(this,"Go TO Next",Toast.LENGTH_SHORT).show();
        });

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