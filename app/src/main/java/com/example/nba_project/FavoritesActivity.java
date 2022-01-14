package com.example.nba_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nba_project.data.entity.FavoriteTeam;

import java.util.List;

    public class FavoritesActivity extends AppCompatActivity {
    private RecyclerView favoritesListRV;
    private FavoritesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        favoritesListRV = (RecyclerView) findViewById(R.id.favorites_list_recyclerView);
        favoritesListRV.setHasFixedSize(true);
        favoritesListRV.setLayoutManager(new LinearLayoutManager(this));
        getFavoritesList();
    }

    private void getFavoritesList() {
        List<FavoriteTeam> FavoritesList=MainActivity.favoritesDatabase.favoriteDAO().getFavoriteData();
        adapter=new FavoritesAdapter(FavoritesList,getApplicationContext(),this.retrieveTeamsLogosExtra());
        favoritesListRV.setAdapter(adapter);
    }

    private  int[] retrieveTeamsLogosExtra(){
        Bundle extras = getIntent().getExtras();
        return extras.getIntArray("teams_logos");
    }
}