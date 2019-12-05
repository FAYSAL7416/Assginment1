package com.momen.faysalAssginment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

   private Button back;
    private Toolbar toolbar;

    RecyclerView recyclerView;
    Myadapter myadapter;
    String [] title, dese;
    int[] Images ={
            R.drawable.noname,R.drawable.mash,R.drawable.sakib,
            R.drawable.tamin,R.drawable.mustafiz,R.drawable.mahmudullah,
            R.drawable.rubel,R.drawable.safiuddin,R.drawable.mushfiqur,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        back=findViewById(R.id.back_btn_id);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.super.onBackPressed();
//                Intent intent=new Intent(getApplicationContext(),Main.class);
//                startActivity(intent);


            }
        });

        //add to toolbar back button
        toolbar=(Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);




        //add Recyclerview
        recyclerView=findViewById(R.id.recyclerviewid);
        title=getResources().getStringArray(R.array.CricketerName);
        dese=getResources().getStringArray(R.array.CricketerDetails);
        myadapter= new Myadapter(this,title,dese,Images);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myadapter.setOnItmClickListener(new Myadapter.Clicklistener() {
            @Override
            public void OnItmClick(int position, View v) {

                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG).show();
            }
            @Override
            public void OnItmlongClick(int position, View v) {

                Toast.makeText(getApplicationContext(), "LongClick", Toast.LENGTH_LONG).show();
            }
        });


    }
}
