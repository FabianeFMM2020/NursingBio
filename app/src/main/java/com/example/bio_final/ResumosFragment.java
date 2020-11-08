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


public class ResumosFragment extends Fragment {

    CardView cardD;
    CardView cardE;
    CardView cardR;
    CardView cardM,cardC, cardExcretor;


    public ResumosFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static ResumosFragment newInstance(String param1, String param2) {
        ResumosFragment fragment = new ResumosFragment();

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
        View v = inflater.inflate(R.layout.fragment_resumos, container, false);

        //Configuracoes dos componentes
        cardD = v.findViewById(R.id.cardDigestorio);
        cardR = v.findViewById(R.id.CardRespiratorio);
        cardE = v.findViewById(R.id.CardEsqueletico);
        cardM = v.findViewById(R.id.CardMuscular);
        cardC = v.findViewById(R.id.CardCardio);
        cardExcretor = v.findViewById(R.id.CardExcretor);

        //Abrir Nova Activity
        cardD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ResumoSistemaDigestorio.class);
                startActivity(i);
            }
        });
        cardR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ResumoSistemaRespiratorio.class);
                startActivity(i);
            }
        });
        cardE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ResumoSistemaEsqueletico.class);
                startActivity(i);
            }
        });
        cardM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ResumoSistemaMuscular.class);
                startActivity(i);
            }
        });
        cardExcretor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ResumoSistemaExcretor.class);
                startActivity(i);
            }
        });
        cardC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ResumoSistemaCardiovascular.class);
                startActivity(i);
            }
        });


        return v;
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
