package org.ftninformatika.termin19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    RecyclerView rvList;
    List<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        setupRV();

    }
    private void setupRV(){
        rvList=findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);
        MyAdapter adapter=new MyAdapter(data,this);
        rvList.setAdapter(adapter);
    }

    private void getData(){
        data=new ArrayList<>();
        for(int i=0;i<20;i++){
        data.add("Element "+i);
        }
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,data.get(position), Toast.LENGTH_SHORT).show();
    }
}
