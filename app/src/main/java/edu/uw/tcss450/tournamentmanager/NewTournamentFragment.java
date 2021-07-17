package edu.uw.tcss450.tournamentmanager;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTournamentFragment extends Fragment {
    private Spinner categories;
    private EditText tournamentTitle;
    private EditText tournamentYear;
    private Spinner tournamentCategory;
    private Button addTournament;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_new_tournament, container, false);
        categories = rootView.findViewById(R.id.category);
        initspinnerfooter();
        tournamentTitle = rootView.findViewById(R.id.tournament_title);
        tournamentYear = rootView.findViewById(R.id.tournament_year);
        tournamentCategory = (Spinner) rootView.findViewById(R.id.category);
        addTournament = rootView.findViewById(R.id.btn_create_tournament);
        addTournament.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(getActivity());
                myDB.addTournament(Integer.valueOf(tournamentYear.getText().toString().trim()),
                                   tournamentTitle.getText().toString().trim(),
                                   tournamentCategory.getSelectedItem().toString().trim());
            }
        });
        return rootView;
    }

    private void initspinnerfooter() {
        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add("Categories");
        categoryList.add("Pool");
        categoryList.add("Boxing");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categoryList);
        categories.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}

//        binding.btnCreateTournament.setOnClickListener(button ->
//                Navigation.findNavController(getView()).
//                navigate(MenuFragmentDirections.actionNavigationMenuToTournamentFragment()));

//        binding.btnCreateTournament.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment frag = new TournamentFragment();
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.fl_fragment_container, frag);
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                ft.addToBackStack(null);
//                ft.commit();
//            }
//        });
//
//        binding.btnViewRecords.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment frag = new RecordsFragment();
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.fl_fragment_container, frag);
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                ft.addToBackStack(null);
//                ft.commit();
//            }
//        });