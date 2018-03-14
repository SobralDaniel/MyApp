package com.example.nbacademy.myapp.database;

import android.content.Context;

import com.example.nbacademy.myapp.database.models.Activity;
import com.example.nbacademy.myapp.database.models.Category;
import com.example.nbacademy.myapp.database.models.Cost;
import com.example.nbacademy.myapp.database.models.Destination;
import com.example.nbacademy.myapp.database.models.Trip;
import com.example.nbacademy.myapp.database.models.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by NBAcademy on 13/03/2018.
 */

public class MockupData {

    public MockupData (Context context) {
        DBHelper.getInstance(context);
    }

    public User getUser() {
        User u = new User();
        u.setAge(10);
        u.setEmail("crespo@email.com");
        u.setName("Pedro Crespo");
        u.setNif("123456789");
        u.setPassword("crespo");
        u.setPhoneNumber("912023928");
        //u.create();
        return u;
    }

    public Trip getTrip() {
        User u = getUser();
        Trip trip = new Trip();
        trip.setName("Teste");
        trip.setNumPeople(3);
        trip.setStartDate(new Date(2018,3,13));
        trip.setEndDate(new Date(2018,3,17));
        trip.setPrice(250f);
        trip.setOrigin("Lisboa");
        trip.setStatus(0);
        trip.setType("Ferias");
        trip.setTotalBudget(200f);
        u.addTrip(trip);
        //trip.create();
        return trip;
    }

    public ArrayList<Destination> getDestinations() {
        Trip trip = getTrip();
        ArrayList<Destination> destinations = new ArrayList<Destination>();
        // Peru
        Destination destination = new Destination();
        destination.setInitialDate(new Date(2018,3,13));
        destination.setFinalDate(new Date(2018,3,14));
        destination.setCurrency("Euros");
        destination.setCurrencyValue(1);
        destination.setHostCost(25.0);
        destination.setMealCost(10.0);
        destination.setDestinationName("Perú");
        destination.setPercDinner(80);
        destination.setPercLunch(70);
        destination.setPercShops(20);
        destination.setPercExtras(10);
        destination.setTemperature(23.0);
        destination.setTimezone("GMT + 0");
        destination.setTripId(trip.getId());
        //destination.create();
        // Madrid
        Destination destination2 = new Destination();
        destination2.setInitialDate(new Date(2018,3,14));
        destination2.setFinalDate(new Date(2018,3,16));
        destination2.setCurrency("Euros");
        destination2.setCurrencyValue(1);
        destination2.setHostCost(40.0);
        destination2.setMealCost(12.5);
        destination2.setDestinationName("Madrid");
        destination2.setPercDinner(85);
        destination2.setPercLunch(80);
        destination2.setPercShops(20);
        destination2.setPercExtras(10);
        destination2.setTemperature(24.0);
        destination2.setTimezone("GMT + 1");
        destination2.setTripId(trip.getId());
        //destination2.create();
        // Porto
        Destination destination3 = new Destination();
        destination3.setInitialDate(new Date(2018,3,16));
        destination3.setFinalDate(new Date(2018,3,17));
        destination3.setCurrency("Euros");
        destination3.setCurrencyValue(1);
        destination3.setHostCost(22.0);
        destination3.setMealCost(7.5);
        destination3.setDestinationName("Porto");
        destination3.setPercDinner(85);
        destination3.setPercLunch(80);
        destination3.setPercShops(20);
        destination3.setPercExtras(10);
        destination3.setTemperature(21.0);
        destination3.setTimezone("GMT + 0");
        destination3.setTripId(trip.getId());
        //destination3.create();

        destinations.add(destination);
        destinations.add(destination2);
        destinations.add(destination3);

        return destinations;
    }

    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        Category categoria1 = new Category();
        categoria1.setName("Alojamento");
        //categoria1.create();
        Category categoria2 = new Category();
        categoria2.setName("Alimentacao");
        //categoria2.create();
        Category categoria3 = new Category();
        categoria3.setName("Transporte");
        //categoria3.create();
        Category categoria4 = new Category();
        categoria4.setName("Lazer");
        //categoria4.create();

        categories.add(categoria1);
        categories.add(categoria2);
        categories.add(categoria3);
        categories.add(categoria4);

        return categories;
    }

    public ArrayList<Activity> getActivities() {
        ArrayList<Activity> activities = new ArrayList<>();
        ArrayList<Category> categories = getCategories();
        // Activity 1
        Activity activity = new Activity();
        activity.setName("Hotel Peru");
        activity.setAddress("Rua do teste, 2");
        activity.setStartDate(new Date(2018,3,13));
        activity.setEndDate(new Date(2018,3,16));
        activity.setRanking(3.8f);
        activity.setCategoryId(categories.get(0).getId());
        //activity.create();
        activities.add(activity);
        // Activity 2
        Activity actividade2 = new Activity();
        actividade2.setName("Taxi");
        actividade2.setStartDate(new Date(2018,3,13));
        actividade2.setEndDate(new Date(2018,3,13));
        actividade2.setCategoryId(categories.get(2).getId());
        //actividade2.create();
        activities.add(actividade2);
        // Activity 3
        Activity actividade3 = new Activity();
        actividade3.setName("Machu Picchu");
        actividade3.setStartDate(new Date(2018,3,14));
        actividade3.setEndDate(new Date(2018,3,14));
        actividade3.setCategoryId(categories.get(3).getId());
        actividade3.create();
        activities.add(actividade3);
        // Activity 4
        Activity actividade4 = new Activity();
        actividade4.setName("Glamour Dinner");
        actividade4.setAddress("Calle Teste, 5");
        actividade4.setStartDate(new Date(2018,3,14));
        actividade4.setEndDate(new Date(2018,3,14));
        actividade4.setCategoryId(categories.get(1).getId());
        //actividade4.create();
        activities.add(actividade4);

        return activities;
    }

    public ArrayList<Cost> getCosts() {
        ArrayList<Cost> costs = new ArrayList<>();
        ArrayList<Activity> activities = getActivities();
        // Cost 1
        Cost custo1 = new Cost();
        custo1.setDate(new Date());
        custo1.setSubCategory("Taxi");
        custo1.setNumPeople(3);
        custo1.setCurrency("Perus");
        custo1.setUnitValue(3.5f);
        custo1.setRealCost(15);
        custo1.setActivityId(activities.get(1).getId());
        //custo1.create();
        costs.add(custo1);
        // Cost 2
        Cost custo2 = new Cost();
        custo2.setDate(new Date());
        custo2.setSubCategory("Machu Picchu");
        custo2.setNumPeople(3);
        custo2.setCurrency("Perus");
        custo2.setUnitValue(35);
        custo2.setRealCost(120);
        custo2.setActivityId(activities.get(3).getId());
        //custo2.create();
        costs.add(custo2);
        return costs;
    }



}
