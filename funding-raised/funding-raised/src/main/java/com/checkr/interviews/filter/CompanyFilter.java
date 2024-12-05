package com.checkr.interviews.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompanyFilter extends Filter {

    
    public CompanyFilter() {
        super("company_name");
    }
     
    @Override
    public List<String[]> getFilteredData(List<String[]> csvData, Map<String, String> options) {
        List<String[]> results = new ArrayList<String[]>();
        for(int i = 0; i < csvData.size(); i++) {
            if(csvData.get(i)[1].equals(options.get(this.getName()))) {
                results.add(csvData.get(i));
            }
        }
        csvData = results;
        return csvData;
    }

    @Override
    public void filterDataAndMap(List<String[]> csvData, Map<String, String> options, Map<String, String> mapped) {
        if(!options.containsKey(this.getName())) {
            return;
        }
        for(int i = 0; i < csvData.size(); i++){

            if(csvData.get(i)[9].equals(options.get(this.getName()))) {
                mapped.put("permalink", csvData.get(i)[0]);
                mapped.put("company_name", csvData.get(i)[1]);
                mapped.put("number_employees", csvData.get(i)[2]);
                mapped.put("category", csvData.get(i)[3]);
                mapped.put("city", csvData.get(i)[4]);
                mapped.put("state", csvData.get(i)[5]);
                mapped.put("funded_date", csvData.get(i)[6]);
                mapped.put("raised_amount", csvData.get(i)[7]);
                mapped.put("raised_currency", csvData.get(i)[8]);
                mapped.put("round", csvData.get(i)[9]);
                break;
            } 
                
        }
        
    }
    
}
