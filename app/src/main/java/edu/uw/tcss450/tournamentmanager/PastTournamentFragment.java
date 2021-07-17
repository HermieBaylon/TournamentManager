package edu.uw.tcss450.tournamentmanager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastTournamentFragment extends Fragment {
    RecyclerView recyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> tYearList, tNameList, tCategoryList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_past_tournament, container, false);
        recyclerView = rootView.findViewById(R.id.rv_Tournaments);
        myDB = new MyDatabaseHelper(getActivity());
        tYearList = new ArrayList<>();
        tNameList = new ArrayList<>();
        tCategoryList = new ArrayList<>();
        return rootView;
    }
}