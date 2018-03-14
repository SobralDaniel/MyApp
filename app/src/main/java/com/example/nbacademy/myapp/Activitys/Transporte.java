package com.example.nbacademy.myapp.Activitys;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbacademy on 11/03/2018.
 */
public class Transporte {

    static List<Activitie> transportes = new ArrayList();
    private static int ids;

    public Transporte() {

        transportes.add(new Activitie(1000, "Carro", "T", "Transporte", null, 30.0, 0.0, 0.0, 0.0 ,0.0));
        transportes.add(new Activitie(999, "Comboio", "T", "Transporte", null, 10.0,  0.0, 0.0, 0.0 ,0.0));
        transportes.add(new Activitie(998, "Avião", "T", "Transporte", null, 100.0,  0.0, 0.0, 0.0 ,0.0));
        transportes.add(new Activitie(997, "Metro", "T", "Transporte", null, 7.5,  0.0, 0.0, 0.0 ,0.0));
        transportes.add(new Activitie(996, "Caminhada", "T", "Transporte", null, 0.0,  0.0, 0.0, 0.0 ,0.0));
        ids = 5;
    }

    public static Activitie getT(int id){
        Activitie toReturn = null;
        for(int i = 0; i < transportes.size(); i++){
            if(transportes.get(i).getId() == id){
                toReturn = transportes.get(i);
                break;
            }
        }
        return toReturn;
    }

    public static int getids(){
        return ids;
    }
}
