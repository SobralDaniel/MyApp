package com.example.nbacademy.myapp.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.nbacademy.myapp.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MainActivity_Activitys extends AppCompatActivity {
    public LayoutInflater layoutInflater;
    public LinearLayout linearLayout;
    public HorizontalScrollView horizontalScrollView;

    public TabHost host;
     int finalI = 0;
    public Viagem viagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity__activitys);

        host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

new Citys();
        new Suggestions();
        new Transporte();

        final Button sugestions = (Button) findViewById(R.id.s);
        final Button buttonMeuPercurso = (Button) findViewById(R.id.meuP);
        Button alimentacao = (Button) findViewById(R.id.cb) ;

        sugestions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // sgestionsActivitie(v);
            }
        });

        buttonMeuPercurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //meuPercurso(v);
            }
        });

        alimentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alimentacao(v);
            }
        });



        final List<Viagem> locais =  new ArrayList();
        locais.add(new Viagem(0,"Istambul", "Istambul", new Date(), new Date()));
        locais.add(new Viagem(1,"Kuala Lumpur", "Kuala Lumpur", new Date(), new Date()));
        locais.add(new Viagem(2,"Lanokawi", "Lanokawi", new Date(), new Date()));
        locais.add(new Viagem(3,"Tóquio", "Tóquio", new Date(), new Date()));
        locais.add(new Viagem(4,"Honolulu", "Honolulu", new Date(), new Date()));
        locais.add(new Viagem(5,"San Diego", "San Diego", new Date(), new Date()));
        locais.add(new Viagem(6,"Cusco/Machupicchu", "Cusco/Machupicchu", new Date(), new Date()));
        locais.add(new Viagem(7,"Buenos Aires", "Buenos Aires", new Date(), new Date()));
        locais.add(new Viagem(8,"Iguaçu", "Iguaçu", new Date(), new Date()));
        locais.add(new Viagem(9,"Rio de Janeiro", "Rio de Janeiro", new Date(), new Date()));


        final TextView datas = (TextView) findViewById(R.id.dates);
        datas.setText(locais.get(0).getDataInicio().toString());
        host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        for (Viagem local : locais) {
            TabHost.TabSpec spec = host.newTabSpec(local.getId()+"");
            spec.setContent(R.id.tab1);
            spec.setIndicator(local.getOrigem());
            host.addTab(spec);
        }

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {

                Log.d("eee", tabId);

                for(int i = 0; i < locais.size(); i++){

                    if((i+"").equals(tabId+"")){
                        Log.d("eee", i+ " cenas ");
                        datas.setText(locais.get(i).getDataInicio().toString());

                        Button sugestions = (Button) findViewById(R.id.s);
                        assert sugestions != null;
                        finalI   = i;
                        final int  ff= i;
                        sugestions.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                viagem = locais.get(ff);
                                sgestionsActivitie(v, ff);
                            }
                        });
                    }
                }


                sugestions.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                         sgestionsActivitie(v, finalI);
                    }
                });

                buttonMeuPercurso.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        meuPercurso(v, finalI);
                    }
                });

                Log.d("eee", tabId);
            }});

        //layoutInflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        //horizontalScrollView=(HorizontalScrollView)findViewById(R.id.horizontal_scroll_view);
        //linearLayout=(LinearLayout)findViewById(R.id.img_gallery);


        //setUpHorizontalSView(locais);
    }

    private void setUpHorizontalSView(List<Viagem> locais)
    {

        //String name[]={"Purse","Camera", "Fashion", "teste", "teste1", "teste2"};

        Iterator<Viagem> iterator = locais.iterator();
        while(iterator.hasNext()) {
            View view = layoutInflater.inflate(R.layout.scroll_view_item, linearLayout, false);
            LinearLayout scroll_item_layout=(LinearLayout) view.findViewById(R.id.scroll_item_Layout);
            Button item_name=(Button)view.findViewById(R.id.scroll_item_name);

            item_name.setText(iterator.next().getOrigem());



            if (!iterator.hasNext())
            {
                scroll_item_layout.setBackgroundResource(android.R.color.transparent);
            }
            linearLayout.addView(view);
        }


        //Button local = (Button) findViewById(R.id.scroll_item_name);

        horizontalScrollView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    TextView datas = (TextView) findViewById(R.id.dates);
                    //datas.setText();
                }
                return false;
            }
        });
    }


    public void sgestionsActivitie(View view, int i) {
        Intent intent = new Intent(this, SuggestionsActivity.class);
        intent.putExtra("id", i);
        startActivity(intent);
    }

    public void meuPercurso(View view, int i) {
        Intent intent = new Intent(this, MeuPercurso.class);
        intent.putExtra("id", i);
        startActivity(intent);
    }

    public void alimentacao(View view) {
        Intent intent = new Intent(this, AlimentacaoActivity.class);
        startActivity(intent);
    }
}
