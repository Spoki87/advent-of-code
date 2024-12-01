package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        loadArrays(firstList,secondList);

        int similarityScore = calculateSimilarityScore(firstList,secondList);
        System.out.println("Answer is: "+similarityScore);
    }

    private static void loadArrays(List<Integer> firstArray, List<Integer> secondArray) throws FileNotFoundException {
        File file = new File("src/main/resources/day1/input.txt");

        Scanner scanner = new Scanner(file);

        while(scanner.hasNext()){
            String line = scanner.nextLine();

            String[] parts = line.trim().split("\\s+");

            firstArray.add(Integer.parseInt(parts[0]));
            secondArray.add(Integer.parseInt(parts[1]));
        }
    }

    private static int calculateSimilarityScore(List<Integer> firstArray, List<Integer> secondArray){
        int similarityScore = 0;

        for(int i =0;i<firstArray.size();i++){
            int counter = 0;
            for(int j=0;j<firstArray.size();j++){
                if(Objects.equals(firstArray.get(i), secondArray.get(j))){
                    counter +=1;
                }
            }
            similarityScore += firstArray.get(i)*counter;
        }

        return similarityScore;
    }
}
