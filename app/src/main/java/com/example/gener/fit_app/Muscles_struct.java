package com.example.gener.fit_app;

/**
 * Created by gener on 21/08/2018.
 */

public class Muscles_struct {
    private String name;
    private String muscle_id;

    public Muscles_struct(String name, String id) {
        this.name = name;
        this.muscle_id = id;
    }
    public String getMuscle_id() {
        return muscle_id;
    }
    public String getName() {
        return name;
    }
}
