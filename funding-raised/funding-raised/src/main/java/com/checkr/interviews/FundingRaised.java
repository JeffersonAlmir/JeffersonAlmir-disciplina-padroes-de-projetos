package com.checkr.interviews;

import java.util.*;
import java.io.IOException;

// import das classes do tipo filter
import com.checkr.interviews.filter.CityFilter;
import com.checkr.interviews.filter.CompanyFilter;
import com.checkr.interviews.filter.Filter;
import com.checkr.interviews.filter.RoundFilter;
import com.checkr.interviews.filter.StatesFilter;



public class FundingRaised  {

    private ReaderService fileReader;
    private final List<Filter> listFilter;
    private ConvertSevice csvConvert;
    
    
    
    public FundingRaised() {
        this.fileReader = new ReaderCSV();
        this.csvConvert = new ConvertSevice();
        this.listFilter = new ArrayList<Filter>();

        listFilter.add(new CompanyFilter());
        listFilter.add(new CityFilter());
        listFilter.add(new StatesFilter());
        listFilter.add(new RoundFilter());

    }
    
    public List<String[]> getFilteredDataByKey(Filter objetoFilter, List<String[]> csvData, Map<String, String> options){
        String key = objetoFilter.getName();

        if(options.containsKey(key) ){ 
            csvData = objetoFilter.getFilteredData(csvData, options);
        }
        return csvData;
    }

    public List<Map<String, String>> where(Map<String, String> options)  throws IOException  {
        
        List<String[]> csvData = fileReader.readCsvFile("./startup_funding.csv");
       
        for(Filter filter : listFilter){
            csvData = getFilteredDataByKey(filter, csvData, options);
        }
        return csvConvert.convertToList(csvData);
    }


    public Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
 
        List<String[]> csvData = fileReader.readCsvFile("./startup_funding.csv");
        Map<String, String> mapped = new HashMap<String, String> ();

        for (Filter filter : listFilter) {
            filter.filterDataAndMap(csvData, options, mapped);
            if (!mapped.isEmpty()) {
                return mapped; 
            } else {
                throw new NoSuchEntryException();
            }
        }
        throw new NoSuchEntryException();
    }

    
}


