package com.example.bio_final;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FlashCardsFragment extends Fragment {

    private CardView Card1, Card2, Card3, Card4, Card5, Card6;


    public FlashCardsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FlashCardsFragment newInstance(String param1, String param2) {
        FlashCardsFragment fragment = new FlashCardsFragment();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flashcards, container, false);

        //Configuracoes dos componentes
        Card1 = view.findViewById(R.id.carddigestorio);
        Card2 = view.findViewById(R.id.cardrespiratorio);
        Card3 = view.findViewById(R.id.cardesqueletico);
        Card4 = view.findViewById(R.id.cardmuscular);
        Card5 = view.findViewById(R.id.cardcardio);
        Card6 = view.findViewById(R.id.cardexcetor);

        //Abrir Nova Activity
        Card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FlashCardDigestorio.class);
                startActivity(i);
            }
        });
        Card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FlashCardRespiratorio.class);
                startActivity(i);
            }
        });
        Card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FlashCardEsqueletico.class);
                startActivity(i);
            }
        });
        Card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FlashCardMuscular.class);
                startActivity(i);
            }
        });
        Card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FlashCardCardiovascular.class);
                startActivity(i);
            }
        });
        Card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FlashCardExcretor.class);
                startActivity(i);
            }
        });

        return view;
    }

    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
