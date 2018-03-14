package com.example.nbacademy.myapp.Activitys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nbacademy on 13/03/2018.
 */
public class Citys {

    final static List<Viagem> locais =  new ArrayList();

    public Citys() {
        locais.add(new Viagem(0,"Istambul", "Istambul", new Date(), new Date()));
        locais.add(new Viagem(1,"Kuala Lumpur", "Kuala Lumpur", new Date(), new Date()));
        locais.add(new Viagem(2,"Langkawi", "Langkawi", new Date(), new Date()));
        locais.add(new Viagem(3,"Tóquio", "Tóquio", new Date(), new Date()));
        locais.add(new Viagem(4,"Honolulu", "Honolulu", new Date(), new Date()));
        locais.add(new Viagem(5,"San Diego", "San Diego", new Date(), new Date()));
        locais.add(new Viagem(6,"Cusco/Machupicchu", "Cusco/Machupicchu", new Date(), new Date()));
        locais.add(new Viagem(7,"Buenos Aires", "Buenos Aires", new Date(), new Date()));
        locais.add(new Viagem(8,"Iguaçu", "Iguaçu", new Date(), new Date()));
        locais.add(new Viagem(9,"Rio de Janeiro", "Rio de Janeiro", new Date(), new Date()));
    }
}
