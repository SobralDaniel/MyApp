package com.example.nbacademy.myapp.Activitys;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nbacademy.myapp.R;

import java.util.List;

/**
 * Created by nbacademy on 08/03/2018.
 */
public class AdapterListView2 extends BaseAdapter {


    private final List<Activitie> activitiesList;
    private final Activity act;


    public AdapterListView2(List<Activitie> activitiesList, Activity act) {
        this.activitiesList = activitiesList;
        this.act = act;
    }

    @Override
    public int getCount() {
        return activitiesList.size();
    }

    @Override
    public Object getItem(int position) {
        return activitiesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Log.d("eee", position + "");
        Log.d("eee", activitiesList.get(position).getCity());
        if(activitiesList.get(position).getType().equals("T")){
            View view = act.getLayoutInflater()
                    .inflate(R.layout.list_transportes, parent, false);
            Activitie  act = activitiesList.get(position);

            TextView nome = (TextView)
                    view.findViewById(R.id.lista_activitie_personalizada_nome);
            TextView descricao = (TextView)
                    view.findViewById(R.id.lista_activitie_personalizada_descricao);
            ImageView imagem = (ImageView)
                    view.findViewById(R.id.lista_activitie_personalizada_imagem);


            ImagesEnum imagesEnum = act.getImagesEnum();
            if(imagesEnum != null) {
                if (imagesEnum.equals(ImagesEnum.Lisbon)) {
                    imagem.setImageResource(R.mipmap.ic_lisbon);
                } else if (imagesEnum.equals(ImagesEnum.Marrocos)) {
                    imagem.setImageResource(R.mipmap.ic_marrocos);
                }
            }
            //populando as Views
            nome.setText(act.getName());
            Log.d("teste", act.getName());
            descricao.setText(act.getCity());

            return view;
        }else{
            View view = act.getLayoutInflater()
                    .inflate(R.layout.list_activitie, parent, false);
            Activitie  act = activitiesList.get(position);
            Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);

            deleteBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    //do something
                    activitiesList.remove(position); //or some other task
                    activitiesList.remove(position+1); //or some other task
                    notifyDataSetChanged();
                }
            });

            TextView nome = (TextView)
                    view.findViewById(R.id.lista_activitie_personalizada_nome);
            TextView descricao = (TextView)
                    view.findViewById(R.id.lista_activitie_personalizada_descricao);
            ImageView imagem = (ImageView)
                    view.findViewById(R.id.lista_activitie_personalizada_imagem);


            ImagesEnum imagesEnum = act.getImagesEnum();
            if(imagesEnum != null) {
                if (imagesEnum.equals(ImagesEnum.Lisbon)) {
                    imagem.setImageResource(R.mipmap.ic_lisbon);
                } else if (imagesEnum.equals(ImagesEnum.Marrocos)) {
                    imagem.setImageResource(R.mipmap.ic_marrocos);
                }
            }
            //populando as Views
            nome.setText(act.getName());
            Log.d("teste", act.getName());
            descricao.setText(act.getCity());

            return view;
        }

    }


}
