package com.example.godzilla.hamper7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Yuval extends AppCompatActivity {

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuval);

        findViewById(R.id.yuvalBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Yuval.this, MainActivity.class);
                startActivity(i);
            }
        });



        Intent i = getIntent();
        String s =i.getStringExtra("name");

        while(s!=null){
            switch (i.getStringExtra("name")){
                case "Yuval_shirt1":
                    ImageView imv1 = findViewById(R.id.Yuvalshirt1);
                    imv1.setImageResource(R.drawable.yuval_shirt1);
                    break;
                case "Yuval_shirt2":
                    imv1 = findViewById(R.id.Yuvalshirt2);
                    imv1.setImageResource(R.drawable.yuval_shirt2);
                    break;
                case "Yuval_shirt1_shirt2":
                    imv1 = findViewById(R.id.Yuvalshirt1);
                    imv1.setImageResource(R.drawable.yuval_shirt1);
                    ImageView imv2 = findViewById(R.id.Yuvalshirt2);
                    imv2.setImageResource(R.drawable.yuval_shirt2);
            }

            s=null;

        }



    }
}
