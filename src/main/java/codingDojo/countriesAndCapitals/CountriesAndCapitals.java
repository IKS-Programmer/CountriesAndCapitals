package codingDojo.countriesAndCapitals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import codingDojo.countriesAndCapitals.utils.CountriesCSVReader;

/**
 * Countries and Capitals main class
 *
 */
public class CountriesAndCapitals {
	
	public static final int NUMBER_OF_QUESTIONS = 100;
	
	public static void main(String[] args) {
		ArrayList<Country> countries = CountriesCSVReader.getCountriesList("./data/CountriesAndCapitals-EN.csv");

		Set<Integer> questionIndices = createQuestionIndices(NUMBER_OF_QUESTIONS, countries.size(), null);
		for (Integer index : questionIndices) {
			Set<Integer> optionIndices = createQuestionIndices(10, countries.size(), index);
			
			System.out.println("Wie lautet die Haupstadt von " + countries.get(index).getName() + "?");
			
			Integer[] indices = optionIndices.toArray(new Integer[optionIndices.size()]);
			for (int i = 0; i < indices.length; i++) {
				System.out.println(Character.toChars('a' + i)[0] + " " + countries.get(indices[i]).getCapital());
			}
		}
		
	}

	private static Set<Integer> createQuestionIndices(int numberOfQuestions, int numberOfPossibleQuestions, Integer initialMember) {
		
		if (numberOfQuestions <= 0) {
			throw new IllegalArgumentException("numberOfQuestions must be greater then 0");
		} 
		if (numberOfQuestions > numberOfPossibleQuestions) {
			throw new IllegalArgumentException("numberOfQuestions must be lower equal numberOfPossibleQuestions");
		}
		if (initialMember != null && (initialMember < 0 || initialMember >= numberOfPossibleQuestions)) {
			throw new IllegalArgumentException("initialMember must be between 0 and numberOfPossibleQuestions");
		}

		/*
		 * ggf. alternative Implementierung via Shuffle auf Stream von mögllichen Indices
		 */
		
		HashSet<Integer> questionIndices = new HashSet<>(numberOfPossibleQuestions);
		
		if (initialMember != null) {
			questionIndices.add(initialMember);
		}

		Random randomNumberGenerator = new Random();

		do {
			int indexCandidate = randomNumberGenerator.nextInt(numberOfPossibleQuestions);

			questionIndices.add(indexCandidate);

		} while (questionIndices.size() < numberOfQuestions);

		return questionIndices;
	}
}
