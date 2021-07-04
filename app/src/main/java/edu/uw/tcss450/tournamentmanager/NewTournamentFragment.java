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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//import edu.uw.tcss450.tournamentmanager.databinding.FragmentCreateNewTournamentBinding;
//import edu.uw.tcss450.tournamentmanager.databinding.FragmentMenuBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTournamentFragment extends Fragment {
    private Spinner categories;


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
        return rootView;
    }

    private void initspinnerfooter() {
        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add("Category 1");
        categoryList.add("Category 2");
        categoryList.add("Category 3");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categoryList);
        categories.setAdapter(adapter);
//        categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Log.v("item", (String) parent.getItemAtPosition(position));
//                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//            }
//        });
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