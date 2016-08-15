package com.example.user.a2fit;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String age;
    private String weight;
    private String height;
    private String gender;

    public void save(Context context) {
        //...SAVE DATA
        SharedPreferences prefs = context.getSharedPreferences("com.example.user.a2fit", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", this.name);
        editor.putString("age", this.age);
        editor.putString("weight", this.weight);
        editor.putString("height", this.height);
        editor.putString("gender", this.gender);
        editor.commit();
    }

    public boolean load(Context context) {
        boolean result = false;
        SharedPreferences prefs = context.getSharedPreferences("com.example.user.a2fit", Context.MODE_PRIVATE);
        name = prefs.getString("name", "");
        age = prefs.getString("age", "");
        weight = prefs.getString("weight", "");
        height = prefs.getString("height", "");
        gender = prefs.getString("gender", "");
        if (!name.trim().equals("")) {
            result = true;
        }
        return result;
    }

    public void logout(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("com.example.user.a2fit", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
    }

    public String toString () {
        String result = "";
        result += "name: " + name + " | ";
        result += "age: " + age + " | ";
        result += "weight: " + weight + " | ";
        result += "height: " + height + " | ";
        result += "gender: " + gender + " | ";

        return result;
    }

    public List validate () {
        List result = new ArrayList<String>();

        //VERIFY DATA
        if(name == null || name.trim().equals("")){
            result.add("Name field is empty");
        }else if(name.matches("[0-9]+") || name.length() > 35) {
            result.add("Enter valid name");
        }

        if(age == null || age.trim().equals("")){
            result.add("Age field is empty");
        }else if(age.matches("[a-zA-Z]+") || age.length() > 2) {
            result.add("Enter valid age");
        }

        if(weight == null || weight.trim().equals("")){
            result.add("Weight field is empty");
        }else if(weight.matches("[a-zA-Z]+") || (weight.length() == 1 || weight.length() > 3)) {
            result.add("Enter valid weight");
        }

        if(height == null || height.trim().equals("")){
            result.add("Height field is empty");
        }else if(height.matches("[a-zA-Z]+") || (height.length() == 2 || height.length() > 3)) {
           result.add("Enter valid height");
        }

        if(gender == null || gender.trim().equals("")){
            result.add("Choose gender");
        }

        return result;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }
}
