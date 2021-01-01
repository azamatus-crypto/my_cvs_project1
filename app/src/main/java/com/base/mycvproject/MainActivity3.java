package com.base.mycvproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapters.MyCvAdapters;
import Data.MyCv;
import Data.MycvViewModule;

public class MainActivity3 extends AppCompatActivity {
  private RecyclerView recyclerViewmain;
  private MycvViewModule mycvViewModule;
  private MyCvAdapters myCvAdapters;
  public List<MyCv>myCvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        myCvList=new ArrayList<>();
        recyclerViewmain=findViewById(R.id.recycklerviewmain);
        mycvViewModule= ViewModelProviders.of(this).get(MycvViewModule.class);
        myCvAdapters=new MyCvAdapters(myCvList);
        recyclerViewmain.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewmain.setAdapter(myCvAdapters);
        LiveData<List<MyCv>>mycvsfromDb=mycvViewModule.getMycvs();
        mycvsfromDb.observe(this, new Observer<List<MyCv>>() {
            @Override
            public void onChanged(List<MyCv> myCvs) {
                myCvAdapters.setMyCvList(myCvs);
            }
        });
    }

}