package com.example.nba_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nba_project.data.model.Team;

import java.util.List;

public class RecyclerAdapterTeams extends  RecyclerView.Adapter<RecyclerAdapterTeams.MyviewHolder> {

    public static final String EXTRA_MESSAGE = "com.example.api_balldontlie.MESSAGE";
    private List<Team> teams;
    Context context;


    public RecyclerAdapterTeams(Context context, List<Team> teams) {
        this.teams = teams;
        this.context = context;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerAdapterTeams.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_layout, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterTeams.MyviewHolder holder, int position) {
        holder.division.setText(teams.get(position).getDivision());
        holder.city.setText(teams.get(position).getCity());
        holder.fullname.setText(teams.get(position).getFullName());
        holder.abreviation.setText(teams.get(position).getAbbreviation());
        holder.id = teams.get(position).getId();
        //holder.logo.setImageResource(R.drawable.testlogo);


        holder.constraint_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Team_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("division", holder.division.getText().toString());
                bundle.putString("city", holder.city.getText().toString());
                bundle.putString("fullname", holder.fullname.getText().toString());
                bundle.putString("abreviation", holder.abreviation.getText().toString());
                bundle.putInt("id", holder.id);

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        if (teams != null) {
            return teams.size();
        }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout constraint_layout;
        private TextView abreviation;
        private TextView city;
        private TextView fullname;
        private TextView division;
        private ImageView logo;
        private int id;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            abreviation = (TextView) itemView.findViewById(R.id.abreviation);
            city = (TextView) itemView.findViewById(R.id.player_lastname);
            fullname = (TextView) itemView.findViewById(R.id.player_firstname);
            division = (TextView) itemView.findViewById(R.id.division);
            constraint_layout = (ConstraintLayout) itemView.findViewById(R.id.constraint_layout);
            logo = (ImageView) itemView.findViewById(R.id.logo);
        }
    }
}
