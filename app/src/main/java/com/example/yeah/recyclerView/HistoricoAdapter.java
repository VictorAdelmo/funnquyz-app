package com.example.yeah.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yeah.methods.Methods;
import com.example.yeah.R;

import java.util.List;

public class HistoricoAdapter extends RecyclerView.Adapter<HistoricoAdapter.ViewHolder>{
       private Context mContext;
       private List<ModelHistorico> mList;
       private Methods methods;

    public HistoricoAdapter(Context context, List<ModelHistorico>list) {
        mContext = context;
        mList = list;
        methods = new Methods();
        /*try {
            GifDrawable gifFromResource = new GifDrawable(mContext.getResources(), R.drawable.gif_loading_shape);
            option = new RequestOptions().centerCrop().placeholder(gifFromResource).error(gifFromResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
           }
         */
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_historico,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView nivelUser,nivelOponente;
        TextView nomeUser,nomeOponente,resultadoOponente,resultadoUser;
        ModelHistorico itemHistorico =mList.get(position);

        nivelUser = holder.nivelUser;
        nivelOponente = holder.nivelOponente;
        nomeUser = holder.nomeUser;
        nomeOponente = holder.nomeOponente;
        resultadoOponente = holder.resultadoOponente;
        resultadoUser = holder.resultadoUser;

        nivelUser.setImageResource(itemHistorico.getImgNivel());
        nivelOponente.setImageResource(itemHistorico.getImgNivel());
        nomeUser.setText(methods.mostrarNomeUser(mContext));
        nomeOponente.setText(itemHistorico.getNomeOponente());
        resultadoOponente.setText(itemHistorico.getResultadoOponente());
        resultadoUser.setText(itemHistorico.getResultadoUser());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView nivelUser,nivelOponente;
        TextView nomeUser,nomeOponente,resultadoOponente,resultadoUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nivelUser = itemView.findViewById(R.id.nivelUserHistorico);
            nivelOponente = itemView.findViewById(R.id.nivelOponenteHistorico);
            nomeUser = itemView.findViewById(R.id.nomeUserHistorico);
            nomeOponente = itemView.findViewById(R.id.nomeOponenteHistorico);
            resultadoOponente = itemView.findViewById(R.id.resultadoOponenteHistorico);
            resultadoUser = itemView.findViewById(R.id.resultadoUserHistorico);
        }
    }
}
