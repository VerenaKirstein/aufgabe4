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
public class City {
    
    String name;
    String country;
            
    /**
     * constructor for the city
     * 
     * @param name cityname
     * @param country countryname
     */
    public City(String name, String country){
        
        this.name = name;
        this.country = country;
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    
     public void setCountry(String name){
        this.country = name;
    }
    
    public String getCountry(){
        return this.country;
    }
}
