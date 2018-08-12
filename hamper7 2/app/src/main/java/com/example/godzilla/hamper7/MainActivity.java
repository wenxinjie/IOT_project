package com.example.godzilla.hamper7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private Message msg1 =new Message();
    private Message msg2 = new Message();
    public ImageView imvJon;
    static String clothesInfo= "";



    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            Toast.makeText(MainActivity.this,(String)msg.obj,Toast.LENGTH_SHORT).show();

        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent iJon =new Intent(MainActivity.this,Jon.class);
        final Intent iYuval =new Intent(MainActivity.this,Yuval.class);
        final Intent iXinjie =new Intent(MainActivity.this,Xinjie.class);
        final Intent cloth = new Intent(MainActivity.this,clothesreceived.class);



        findViewById(R.id.btnXinjie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Xinjie.class);
                startActivity(i);
            }
        });


        findViewById(R.id.btnJon).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                System.out.println(clothesInfo+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                if(clothesInfo.contains("John")&&clothesInfo.contains("shirt1")&&clothesInfo.contains("shirt2")&&(!clothesInfo.contains("Yuval"))){
                    iJon.putExtra("name","John_shirt1_shirt2");
                    startActivity(iJon);
                }

                else if (clothesInfo.contains("John")&&clothesInfo.contains("shirt1")&&(!clothesInfo.contains("John','name':'shirt2"))){
                    iJon.putExtra("name","John_shirt1");
                    startActivity(iJon);
                }
                else if(clothesInfo.contains("John")&&clothesInfo.contains("shirt2")&&(!clothesInfo.contains("John','name':'shirt1"))){
                    iJon.putExtra("name","John_shirt2");
                    startActivity(iJon);
                }
                else {startActivity(iJon);

                }


            }
        });

        findViewById(R.id.btnYuval).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(clothesInfo+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                if(clothesInfo.contains("Yuval")&&clothesInfo.contains("shirt1")&&clothesInfo.contains("shirt2")&&(!clothesInfo.contains("John"))){
                    iYuval.putExtra("name","Yuval_shirt1_shirt2");
                    startActivity(iYuval);
                }

                else if (clothesInfo.contains("Yuval")&&clothesInfo.contains("shirt1")&&(!clothesInfo.contains("'Yuval','name':'shirt2"))){
                    iYuval.putExtra("name","Yuval_shirt1");
                    startActivity(iYuval);
                }
                else if(clothesInfo.contains("Yuval")&&clothesInfo.contains("shirt2")&&(!clothesInfo.contains("'Yuval','name':'shirt1"))){
                    iYuval.putExtra("name","Yuval_shirt2");
                    startActivity(iYuval);
                }
                else {startActivity(iYuval);

                }

            }
        });

        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View v) {
                new AsyncTask<String,Void,Void>(){
                    @Override
                    protected Void doInBackground(String... strings) {
                        try {
                            URL url= new URL(strings[0]);
                            URLConnection connection = url.openConnection();
                            InputStream is =connection.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is,"utf-8");
                            BufferedReader br = new BufferedReader(isr);
                            String line="";

                            StringBuilder result=new StringBuilder();
                            while((line=br.readLine())!=null){
                                System.out.println(line+"1");
                                result.append(line);
                                clothesInfo=line;
                            }

//                            msg.obj=result.toString();
//                            Handler handler = new Handler();
//                            handler.sendMessage(msg);
//                            clothesInfo=(String)msg.obj;

                            br.close();
                            isr.close();
                            is.close();

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        String value2= "";

                        JSONObject myJsonObject = null;
                        try {
                            myJsonObject = new JSONObject(clothesInfo);
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            assert myJsonObject != null;
                            value2 = myJsonObject.getString("item");
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }

                        String[] arrayStr;

                        arrayStr = value2.split(",");
                        String[] arrayStr1 = arrayStr;
                        String s1;

                        int a;
                        for (a = 0; a < arrayStr.length; a++) {
                            System.out.println(arrayStr[a]);
                            s1=arrayStr[a].replace("{","").replace("}","").replace("[","").replace("]","");
                            System.out.println(s1);
                            arrayStr1[a]=s1;

//
//                            if (arrayStr[a].contains("John")&&arrayStr[a+1].contains("shirt1")) {
//
//                                msg1.obj="Jon_shirt1";
//
//                                handler.sendMessage(msg1);
//
//
//                                try {
//                                    Thread.sleep(2000);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//
//
//                                System.out.println("have Jon's shirt1");
//
//                                cloth.putExtra("name","Jon_shirt1");
//
//                                startActivity(cloth);
//
//
//
//                            } else if (arrayStr[a].contains("Yuval")&&arrayStr[a+1].contains("shirt2")) {
//
//                                msg2.obj="Yuval_shirt2";
//
//                                handler.sendMessage(msg2);
//
//
//                                try {
//                                    Thread.sleep(2000);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//
//
//                                cloth.putExtra("name","Yuval_shirt2");
//
//                                startActivity(cloth);
//
//                                System.out.println("have Yuval's shirt2");
//
//
//
//                            }
                        }


                        int b =arrayStr1.length;
                        System.out.println(b+"<<<<<<<<<<<<<,");
                        String Shirt="";
                        String Shirt2="";
                        String Shirt3="";

                        switch(b){
                            case(2):
                                if(arrayStr1[0].contains("John")){
                                    if(arrayStr1[1].contains("shirt1")){
                                        Shirt = "John_shirt1";
                                    }
                                    else if(arrayStr1[1].contains("shirt2")){
                                        Shirt = "John_shirt2";
                                    }
                                }
                                else if(arrayStr1[0].contains("Yuval")){
                                    if(arrayStr1[1].contains("shirt1")){
                                        Shirt = "Yuval_shirt1";
                                    }
                                    else if(arrayStr1[1].contains("shirt2")){
                                        Shirt = "Yuval_shirt2";
                                    }
                                }

                                msg1.obj=Shirt;
                                System.out.println(arrayStr1[1]);

                                System.out.println(Shirt+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

                                handler.sendMessage(msg1);


                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                cloth.putExtra("name",Shirt);

                                startActivity(cloth);
                                break;

                            case(4):{

                                if(arrayStr1[0].contains("John")){
                                    if(arrayStr1[2].contains("John")){
                                        Shirt2 ="John_shirt1";
                                        Shirt3="John_shirt2";


                                    }
                                    else if (arrayStr1[2].contains("Yuval")){
                                        if(arrayStr1[1].contains("shirt1")){
                                            Shirt2="John_shirt1";
                                        }
                                        else{Shirt2="John_shirt2";}
                                        if(arrayStr1[3].contains("shirt1")){
                                            Shirt3="Yuval_shirt1";
                                        }
                                        else{Shirt3 = "Yuval_shirt2";}

                                    }


                             }
                             else if (arrayStr1[0].contains("Yuval")){


                                    if(arrayStr1[2].contains("Yuval")){
                                        Shirt2 ="Yuval_shirt1";
                                        Shirt3="Yuval_shirt2";


                                    }
                                    else if (arrayStr1[2].contains("John")){
                                        if(arrayStr1[1].contains("shirt1")){
                                            Shirt2="Yuval_shirt1";
                                        }
                                        else{Shirt2="Yuval_shirt2";}
                                        if(arrayStr1[3].contains("shirt1")){
                                            Shirt3="John_shirt1";
                                        }
                                        else{Shirt3 = "John_shirt2";}

                                    }

                                }

                                msg1.obj=Shirt2+" AND "+Shirt3;

                                handler.sendMessage(msg1);


                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                cloth.putExtra("name",Shirt2+" AND "+Shirt3);

                                startActivity(cloth);
                                break;
                            }


                        }



                        System.out.println(value2);
                        System.out.println(arrayStr1[1]);
                        return null;
                    }

                }.execute("http://160.39.218.78:8080");


            }
        });


    }


}
