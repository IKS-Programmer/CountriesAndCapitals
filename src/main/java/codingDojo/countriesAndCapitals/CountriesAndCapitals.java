package codingDojo.countriesAndCapitals;

import java.util.ArrayList;

import codingDojo.countriesAndCapitals.utils.CountriesCSVReader;

/**
 * Countries and Capitals main class
 *
 */
public class CountriesAndCapitals 
{
    public static void main( String[] args )
    {
        ArrayList<Country> countries = CountriesCSVReader.getCountriesList("./data/CountriesAndCapitals-EN.csv");
        
        for (Country country : countries) {
			System.out.println(country.getName() + "\t->\t" + country.getCapital());
		}
    }
}
