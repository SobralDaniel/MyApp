package com.example.nbacademy.myapp.grupo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> alimentacao = new ArrayList<String>();
        alimentacao.add("Almoço");
        alimentacao.add("Jantar");

        List<String> transporte = new ArrayList<String>();
        transporte.add("Avião");
        transporte.add("Barco");
        transporte.add("Taxi");

        List<String> alojamento = new ArrayList<String>();
        alojamento.add("Hotel");
        alojamento.add("Rua");

        expandableListDetail.put("Alimentação", alimentacao);
        expandableListDetail.put("Transporte", transporte);
        expandableListDetail.put("Alojamento", alojamento);
        return expandableListDetail;
    }
}
