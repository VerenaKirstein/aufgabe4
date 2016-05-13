/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aufgabe4;


/**
 *
 * @author Verena Rabea
 */
public class Weather {
    
    String cityName;
    String description;
    double temp;
    
    /**
     * constructor for Weather
     * 
     * @param cityName the name of the city to retrieve the weather from
     * @param description the actual weather description
     * @param temp the temperature in the city
     */
    public Weather(String cityName, String description, double temp){
        this.description = description;
        this.temp = temp;
        this.cityName = cityName;
        
    }

    @Override
    public String toString() {
        return "Weather{" + "cityName=" + cityName + ", description=" + description + ", temperature=" + temp + '}';
    }

    
    
   

   
    
}
