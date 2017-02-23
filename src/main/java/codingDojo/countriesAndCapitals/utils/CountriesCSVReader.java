package codingDojo.countriesAndCapitals.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import codingDojo.countriesAndCapitals.Country;

public class CountriesCSVReader {
	
	public static ArrayList<Country> getCountriesList(String csvFile) {
		ArrayList<Country> countries = new ArrayList<>();
		
		String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                countries.add(new Country(country[0], country[1]));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return countries;
	}

}
