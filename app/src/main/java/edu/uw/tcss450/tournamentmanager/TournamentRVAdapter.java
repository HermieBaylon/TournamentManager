package edu.uw.tcss450.tournamentmanager;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TournamentRVAdapter extends RecyclerView.Adapter<TournamentRVAdapter.MyViewHolder> {

    private Context context;
    private ArrayList tYearList, tNameList, tCategoryList;

    TournamentRVAdapter(Context context, ArrayList tYearList, ArrayList tNameList, ArrayList tCategoryList) {
        this.context = context;
        this.tYearList = tYearList;
        this.tNameList = tNameList;
        this.tCategoryList = tCategoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(context);
        View view = inflate.inflate(R.layout.tournament_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tYearText.setText(String.valueOf(tYearList.get(position)));
        holder.tNameText.setText(String.valueOf(tNameList.get(position)));
    }

    @Override
    public int getItemCount() {
        return tYearList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tYearText, tNameText, tCategoryText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tYearText = itemView.findViewById(R.id.tournament_year_txt);
            tNameText = itemView.findViewById(R.id.tournament_title_txt);
        }
    }
}
