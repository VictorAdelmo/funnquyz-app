package com.example.yeah;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yeah.methods.Methods;
import com.example.yeah.recyclerView.HistoricoAdapter;

public class HistoricoFrag extends Fragment {

    private RecyclerView recyclerView;
    private HistoricoAdapter historicoAdapter;
    private Methods methods;

    public HistoricoFrag(){
        methods = new Methods();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_historico,container,false);
        recyclerView = view.findViewById(R.id.recyclerViewHistorico);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        historicoAdapter = new HistoricoAdapter(getContext(),methods.mostrarHistorico(getContext()));
        recyclerView.setAdapter(historicoAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
