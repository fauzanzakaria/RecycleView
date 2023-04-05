package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.recycleview.adapter.ContactAdapter;
import com.example.recycleview.model.Contact;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Deklarasi
    RecyclerView recyclerView;
    ContactAdapter kontakAdapter;
    ArrayList<Contact> _kontakList;
    Button _btAddData;
    int[] foto = {R.drawable.ava1,R.drawable.ava2,R.drawable.ava3,R.drawable.ava4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btAddData = findViewById(R.id.AddData);
        _btAddData.setOnClickListener(this);
        loadData();
        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rv_ID);
        kontakAdapter = new ContactAdapter(_kontakList, this);
        recyclerView.setAdapter(kontakAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addData(){
        Random random = new Random();
        int choose = random.nextInt(3);
        _kontakList.add(new Contact(foto[choose],"newData "+(_kontakList.size()-1),"newdata@gmail.com"));
    }

    private void loadData(){
        _kontakList = new ArrayList<>();
        _kontakList.add(new Contact(foto[0],"Fauzan","fauzan@gmail.com"));
        _kontakList.add(new Contact(foto[1],"Zakaria","zakaria@gmail.com"));
        _kontakList.add(new Contact(foto[2],"Hermansah","hermansah@gmail.com"));
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == _btAddData.getId()){
            addData();
            kontakAdapter.notifyDataSetChanged();
        }
    }
}