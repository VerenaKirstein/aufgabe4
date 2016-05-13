/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aufgabe4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Verena Rabea
 */
public class Test {
    
     private static final Logger LOG = LogManager.getLogger("Aufgabe4");
    public static void main(String[] args) {
        WeatherRetriever retriever = new WeatherRetriever();

        LOG.info(retriever);        
        try {
            Weather weather = retriever.retrieve(new City("Bochum", "Germany"));
            LOG.info(weather);
        }
        catch (UnsupportedCountryException e) {
            LOG.error("This country is not supported", e);
        }

        try {
            Weather weather = retriever.retrieve(new City("Sydney", "Australia"));
            LOG.info(weather);
        }
        catch (UnsupportedCountryException e) {
            LOG.error("This country is not supported", e);
        }
    }   
}
