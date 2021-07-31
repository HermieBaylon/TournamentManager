package edu.uw.tcss450.tournamentmanager.PastTournament;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import edu.uw.tcss450.tournamentmanager.Player;
import edu.uw.tcss450.tournamentmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTournamentFragment extends Fragment {
    private Spinner categories;
    private EditText tournamentTitle;
    private EditText tournamentYear;
    private Spinner tournamentCategory;
    private Button addTournament;
    private Button updateTournament;
    private EditText playersText;

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
        updateTournament = rootView.findViewById(R.id.btn_update_tournament);
        playersText = (EditText) rootView.findViewById(R.id.players_txt);




        addTournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(getActivity());
                myDB.addTournament(Integer.valueOf(tournamentYear.getText().toString().trim()),
                                   tournamentTitle.getText().toString().trim(),
                                   tournamentCategory.getSelectedItem().toString().trim());
            }
        });

        updateTournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tournament tournament = new Tournament();
                String text = playersText.getText().toString().trim();
                String players[] = text.split("\\r?\\n");
                String p1[] = players[0].split(" ");
                String p2[] = players[1].split(" ");
                Player player1 = new Player(p1[0], Integer.parseInt(p1[1]));
                Player player2 = new Player(p2[0], Integer.parseInt(p2[1]));
                tournament.play(player1, player2);
                String winner = tournament.getWinner()+" [" +tournament.getWinnerScore()+"]";
                String finalist = tournament.getFinalist()+" ["+tournament.getFinalistScore()+"]";

                MyDatabaseHelper myDB = new MyDatabaseHelper(getActivity());
                                myDB.updateTournament(Integer.valueOf(tournamentYear.getText().toString().trim()),
                                        tournamentTitle.getText().toString().trim(),
                                        tournamentCategory.getSelectedItem().toString().trim(),
                                        winner,
                                        finalist);
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