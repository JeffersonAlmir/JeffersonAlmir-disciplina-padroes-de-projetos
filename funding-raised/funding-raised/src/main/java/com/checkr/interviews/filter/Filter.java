package com.checkr.interviews.filter;


import java.util.List;
import java.util.Map;

public abstract class Filter {
    private final String name;



    public Filter(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public abstract List<String[]> getFilteredData( List<String[]> csvData, Map<String, String> options);


    
    public abstract void filterDataAndMap(List<String[]> csvData, Map<String, String> options, Map<String, String> mapped);
    

    

        
    
}
