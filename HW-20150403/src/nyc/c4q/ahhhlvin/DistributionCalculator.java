package nyc.c4q.ahhhlvin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by alvin2 on 3/30/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */


public class DistributionCalculator {
    public static void main(String[] args) {
        File file = new File("/Users/alvin2/Desktop/accesscode/HW-20150403/testtext.txt");
        System.out.println(calculate(file));
    }

    public static ArrayList<String> calculate(File textFile) {
        ArrayList<String> percentDist = new ArrayList<String>();
        TreeMap<Character, Integer> distMap = new TreeMap<Character, Integer>();


        String file = textFile.toString();
        file = file.toLowerCase();
        int count = 0;


        Scanner scanner = new Scanner(file);

        while(scanner.hasNext()) {
            String word = scanner.next();
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                int encoded = (int) currentChar;

                if (encoded <= 97 || encoded >= 122) {
                    continue;
                } else if (distMap.containsKey(currentChar)) {
                    distMap.get(currentChar);
                    distMap.put(currentChar, distMap.get(currentChar)+1);
                    count++;
                } else {
                    distMap.put(currentChar, 1);
                    count++;
                }


            }


        }

        for (char character : distMap.keySet()) {
            percentDist.add(character + " = " + percentMaker(distMap.get(character), count));
        }




        return percentDist;
    }

    public static String percentMaker(double single, double total) {
        double percentage = (((single / total))*100);
        String result = percentage + "%";
        return result;
    }




}



