/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aufgabe4;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherData;
import org.bitpipeline.lib.owm.WeatherData.WeatherCondition;
import org.bitpipeline.lib.owm.WeatherStatusResponse;
import org.json.JSONException;

/**
 *class to retrieve Weather Data from OpenWeatherMap
 * 
 * @author Verena Rabea
 */
public class WeatherRetriever {
     private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger("WeatherRetriever");
     private Weather  w;
     private String wc ;
    private WeatherStatusResponse currentWeather;
     
    public WeatherRetriever(){
        
    }
    /**
     * method retrieves the current weather for the defined city 
     * with the actual forecast and temperature
     * 
     * @param city the city with name and country to retrieve the weather from
     * @return the weatherData for the specific city
     * @throws UnsupportedCountryException if countryname = Australia no weatherData is retrieved and the exception is thrown
     */
    public Weather retrieve (City city)throws UnsupportedCountryException{
        
        /**
         * throw exception if country equals Australia
         */
        if (city.getCountry().equals("Australia"))
            throw new UnsupportedCountryException();
        else{
            
        OwmClient owm = new OwmClient ();
       
        double temp=0;
        
        try {
            /**
             * get the weather Data for the specific city
             */
            currentWeather = owm.currentWeatherAtCity(city.getName(),city.getCountry());
            if (currentWeather.hasWeatherStatus ()) {
                   WeatherData weather = currentWeather.getWeatherStatus().get(0);
                 WeatherCondition weatherCondition = weather.getWeatherConditions().get(0);
              
                 /**
                  * get the current weather
                  */
                  wc = weatherCondition.getDescription();
                 temp = weather.getTemp()-273;
          
        }
        } catch (IOException ex) {
            Logger.getLogger(WeatherRetriever.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(WeatherRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return new Weather(city.getName(),wc,temp);  
        }
    }

    @Override
    public String toString() {
        return "WeatherRetriever{" + "w=" + w + ", currentWeather=" + currentWeather + '}';
    }
}
