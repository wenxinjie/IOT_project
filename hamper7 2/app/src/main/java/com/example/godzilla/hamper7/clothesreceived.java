package com.example.godzilla.hamper7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class clothesreceived extends AppCompatActivity {

    public ImageView imv1;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothesreceived);


        findViewById(R.id.clothBk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(clothesreceived.this,MainActivity.class);
                startActivity(i);
            }
        });


        Intent i = getIntent();
        String s =i.getStringExtra("name");

        while(s!=null){
            if(s.contains("AND")){
                String[] arrayStr;
                arrayStr = s.split(" AND ");
                imv1 = findViewById(R.id.clothimag1);
                switch(arrayStr[0]){

                    case("John_shirt1"):
                        imv1.setImageResource(R.drawable.john_shirt1);
                        break;
                    case("John_shirt2"):
                        imv1.setImageResource(R.drawable.john_shirt2);
                        break;
                    case("Yuval_shirt1"):
                        imv1.setImageResource(R.drawable.yuval_shirt1);
                        break;
                    case("Yuval_shirt2"):
                        imv1.setImageResource(R.drawable.yuval_shirt2);
                        break;
                }
                ImageView imv2 = findViewById(R.id.clothimag2);
                switch(arrayStr[1]){

                    case("John_shirt1"):
                        imv2.setImageResource(R.drawable.john_shirt1);
                        break;
                    case("John_shirt2"):
                        imv2.setImageResource(R.drawable.john_shirt1);
                        break;
                    case("Yuval_shirt1"):
                        imv2.setImageResource(R.drawable.yuval_shirt1);
                        break;
                    case("Yuval_shirt2"):
                        imv2.setImageResource(R.drawable.yuval_shirt2);
                        break;
                }

            }
            else
                {
                    imv1 = findViewById(R.id.clothimag1);
                    switch (s){
                        case("John_shirt1"):
                            imv1.setImageResource(R.drawable.john_shirt1);
                            break;
                        case("John_shirt2"):
                            imv1.setImageResource(R.drawable.john_shirt2);
                            break;
                        case("Yuval_shirt1"):
                            imv1.setImageResource(R.drawable.yuval_shirt1);
                            break;
                        case("Yuval_shirt2"):
                            imv1.setImageResource(R.drawable.yuval_shirt2);
                            break;

                    }


            }

            s=null;

        }



    }
}
