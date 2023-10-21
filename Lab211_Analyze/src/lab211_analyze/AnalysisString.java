/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab211_analyze;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
/**
 *
 * @author dotha
 */
public class AnalysisString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        scanner.close();

        AnalysisString analysis = new AnalysisString();
        analysis.analyzeAndDisplay(userInput);
    }

    public void analyzeAndDisplay(String input) {
        HashMap<String, List<Integer>> numberAnalysis = getNumber(input);
        HashMap<String, String> characterAnalysis = getCharacter(input);

        System.out.println("Number of characters in the string: " + input.length());
        System.out.println("All characters: " + characterAnalysis.get("allCharacters"));
        System.out.println("Uppercase characters: " + characterAnalysis.get("uppercaseCharacters"));
        System.out.println("Lowercase characters: " + characterAnalysis.get("lowercaseCharacters"));

        System.out.println("List of numbers: " + numberAnalysis.get("allNumbers"));
        System.out.println("List of even numbers: " + numberAnalysis.get("evenNumbers"));
        System.out.println("List of odd numbers: " + numberAnalysis.get("oddNumbers"));
        System.out.println("List of square numbers: " + numberAnalysis.get("squareNumbers"));

        System.out.println("Special characters: " + characterAnalysis.get("specialCharacters"));
    }

    public HashMap<String, List<Integer>> getNumber(String input) {
        HashMap<String, List<Integer>> result = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> squareNumbers = new ArrayList<>();

        Pattern pattern = Pattern.compile("[0-9]+");
        java.util.regex.Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            allNumbers.add(num);
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
            double sqrt = Math.sqrt(num);
            if (sqrt == Math.floor(sqrt) && !Double.isInfinite(sqrt)) {
                squareNumbers.add(num);
            }
        }

        result.put("allNumbers", allNumbers);
        result.put("evenNumbers", evenNumbers);
        result.put("oddNumbers", oddNumbers);
        result.put("squareNumbers", squareNumbers);

        return result;
    }

    public HashMap<String, String> getCharacter(String input) {
        HashMap<String, String> result = new HashMap<>();
        StringBuilder allCharacters = new StringBuilder();
        StringBuilder uppercaseCharacters = new StringBuilder();
        StringBuilder lowercaseCharacters = new StringBuilder();
        StringBuilder specialCharacters = new StringBuilder();

        for (char c : input.toCharArray()) {
            allCharacters.append(c);
            if (Character.isUpperCase(c)) {
                uppercaseCharacters.append(c);
            } else if (Character.isLowerCase(c)) {
                lowercaseCharacters.append(c);
            } else if (!Character.isLetterOrDigit(c)) {
                specialCharacters.append(c);
            }
        }

        result.put("allCharacters", allCharacters.toString());
        result.put("uppercaseCharacters", uppercaseCharacters.toString());
        result.put("lowercaseCharacters", lowercaseCharacters.toString());
        result.put("specialCharacters", specialCharacters.toString());

        return result;
    }
}