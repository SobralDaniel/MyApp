package com.example.nbacademy.myapp.database.api;

/**
 * Created by nbacademy on 09/03/2018.
 */
public interface IUser extends ITable {

    int getId();

    int getAge();

    void setAge(int age);

    String getName();

    void setName(String name);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getNif();

    void setNif(String nif);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);
}
