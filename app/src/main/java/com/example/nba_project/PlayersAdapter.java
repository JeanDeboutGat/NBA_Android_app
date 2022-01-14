package com.example.nba_project;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nba_project.data.model.NbaPlayer;

import java.util.List;
import java.util.Objects;


public class PlayersAdapter extends  RecyclerView.Adapter<PlayersAdapter.MyviewHolder> {

    public static final String EXTRA_MESSAGE = "com.example.api_balldontlie.MESSAGE";
    private List<NbaPlayer> players;
    Context context;

    public PlayersAdapter(Context context, List<NbaPlayer> players) {
        this.players = players;
        this.context = context;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_layout, parent, false);
        return new MyviewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.lastname.setText(players.get(position).getLastName());
        holder.firstname.setText(players.get(position).getFirstName());
        holder.position.setText(players.get(position).getPosition());

        if(Objects.nonNull(players.get(position).getHeightFeet())){
            holder.height.setText(players.get(position).getHeightFeet().toString());
        }else{
            holder.height.setText("No info");
        }

        if(Objects.nonNull(players.get(position).getPosition())){
            holder.position.setText(players.get(position).getPosition());
        }else{
            holder.position.setText("No info");
        }
    }

    @Override
    public int getItemCount() {
        if (players != null) {
            return players.size();
        }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView lastname;
        private TextView firstname;
        private TextView position;
        private TextView height;
        private ImageView logo;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            lastname = (TextView) itemView.findViewById(R.id.player_lastname);
            firstname = (TextView) itemView.findViewById(R.id.player_firstname);
            position = (TextView) itemView.findViewById(R.id.position);
            height = (TextView) itemView.findViewById(R.id.height);
            Log.d("logo","logo"+itemView.findViewById(R.id.logo));
        }
    }
}
