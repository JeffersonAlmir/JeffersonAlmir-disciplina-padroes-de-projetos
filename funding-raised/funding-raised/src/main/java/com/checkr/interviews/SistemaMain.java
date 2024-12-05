package com.checkr.interviews;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class SistemaMain {
    public static void main(String[] args) throws NoSuchEntryException {
        try {
           
            FundingRaised fundingRaised = new FundingRaised();
            Map<String, String> options = new HashMap<String, String> ();
            options.put("company_name", "Facebook");
            options.put("round", "a");

            System.out.print(fundingRaised.where(options).size());
           
        } catch(IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}
