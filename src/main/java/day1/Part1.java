package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        loadArrays(firstList,secondList);

        Collections.sort(firstList);
        Collections.sort(secondList);

        int distance = calculateDistance(firstList,secondList);

        System.out.println("Answer is: "+distance);
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

    private static int calculateDistance(List<Integer> firstArray, List<Integer> secondArray){
        int distance = 0;

        for(int i =0;i<firstArray.size();i++){
            int difference = Math.abs(firstArray.get(i)-secondArray.get(i));
            distance += difference;
        }
        return distance;
    }
}

