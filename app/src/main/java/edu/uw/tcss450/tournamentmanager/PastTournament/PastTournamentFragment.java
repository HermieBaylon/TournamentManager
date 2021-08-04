package edu.uw.tcss450.tournamentmanager.PastTournament;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import edu.uw.tcss450.tournamentmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastTournamentFragment extends Fragment {
    RecyclerView recyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> tYearList, tNameList, tCategoryList;
    ArrayList<String> tWinnerList, tFinalistList;
    ArrayList<String> tResultList;
    TournamentRVAdapter tournamentRVAdapter;

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
        tWinnerList = new ArrayList<>();
        tFinalistList = new ArrayList<>();
        tResultList = new ArrayList<>();

        storeDataInArrays();

//        tournamentRVAdapter = new TournamentRVAdapter(getActivity(), tYearList, tNameList,
//                                tCategoryList, tWinnerList, tFinalistList, tResultList);
        tournamentRVAdapter = new TournamentRVAdapter(getActivity(), tYearList, tNameList,
                tCategoryList, tWinnerList, tFinalistList);
        recyclerView.setAdapter(tournamentRVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(getActivity(), "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                tYearList.add(cursor.getString(0));
                tNameList.add(cursor.getString(1));
                tCategoryList.add(cursor.getString(2));
                tWinnerList.add(cursor.getString(3));
                tFinalistList.add(cursor.getString(4));
                //tResultList.add(cursor.getString(5));
            }
        }
    }
}












