package nyc.c4q.ahhhlvin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by alvin2 on 3/30/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 *
 * Create a class to calculate the distribution of characters in the contents of a text file. Your class called DistributionCalculator should implement a method calculate(File textFile) which accepts as input a Text file. It reads the contents of the file and returns an ArrayList which contains the distribution/percentage of characters (a-z) in the text file. You should lowercase lines before you do the calculation. Call the calculate method from main and print the distribution. You can ignore characters which do not belong in the range(a-z) for doing your calculation.
 *
 */


public class DistributionCalculator {
    public static void main(String[] args) {
        File file = new File("/Users/alvin2/Desktop/accesscode/HW-20150403/testtext.txt");
        System.out.println(calculate(file));
    }

    public static ArrayList<String> calculate(File textFile) {
        ArrayList<String> percentDist = new ArrayList<String>();
        TreeMap<Character, Integer> distMap = new TreeMap<Character, Integer>();

        // converts textFile to a string and then converts that string to all lowercase
        String file = textFile.toString();
        file = file.toLowerCase();
        int count = 0;


        Scanner scanner = new Scanner(file);

        while(scanner.hasNext()) {
            String word = scanner.next();
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                int encoded = (int) currentChar;

                if (encoded < 97 || encoded > 122) {
                    continue;
                } else if (distMap.containsKey(currentChar)) {
                    distMap.put(currentChar, distMap.get(currentChar)+1);
                    count++;
                } else {
                    distMap.put(currentChar, 1);
                    count++;
                }


            }


        }

        // This adds each character and the count of how many times the character appeared and places it into the TreeMap
        for (char character : distMap.keySet()) {
            percentDist.add(character + " = " + percentMaker(distMap.get(character), count));
        }

        return percentDist;
    }

    // I created a separate method here that converts the number of times each character appears into a percentage
    public static String percentMaker(double single, double total) {

        double percentage = (((single / total))*100);
        String result = percentage + "%";
        return result;

    }


}



