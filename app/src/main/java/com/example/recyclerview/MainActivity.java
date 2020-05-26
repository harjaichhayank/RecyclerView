package com.example.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ListProvider> arrayList = new ArrayList<>();
    String[] names,ratings;
    int[] images = {R.drawable.movie_1,R.drawable.movie_2,R.drawable.movie_3,
                    R.drawable.movie_4,R.drawable.movie_5,R.drawable.movie_6,
                    R.drawable.movie_7, R.drawable.movie_8,R.drawable.movie_9,
                    R.drawable.movie_10,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        names = getResources().getStringArray(R.array.Top_10_movies);
        ratings = getResources().getStringArray(R.array.Movie_ratings);

        int count=0;
        for (String name: names){
            ListProvider listProvider = new ListProvider(images[count],name,ratings[count]);
            arrayList.add(listProvider);
            count++;
        }
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
