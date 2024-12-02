package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        int safeReports = calculateSafeReports();
        System.out.println("Answer is: "+safeReports);
    }

    private static int calculateSafeReports() throws FileNotFoundException {
        int safeReports = 0;

        File file = new File("src/main/resources/day2/input.txt");

        Scanner scanner = new Scanner(file);

        while(scanner.hasNext()){
            String line = scanner.nextLine();

            String[] parts = line.trim().split(" ");

            if((isAsc(parts)||isDesc(parts))&&isCorrect(parts) ){
                safeReports++;
            }
        }
        return safeReports;
    }

    private static boolean isAsc(String[] table){
        for(int i=1;i<table.length;i++){
            if(Integer.parseInt(table[i-1]) <= Integer.parseInt(table[i])){
                return false;
            }
        }
        return true;
    }

    private static boolean isDesc(String[] table){
        for(int i=1;i<table.length;i++){
            if(Integer.parseInt(table[i-1]) >= Integer.parseInt(table[i])){
                return false;
            }
        }
        return true;
    }

    private static boolean isCorrect(String[] table){
        for(int i=1;i<table.length;i++){
            if(Math.abs(Integer.parseInt(table[i-1]) - Integer.parseInt(table[i])) > 3){
                return false;
            }
        }
        return true;
    }

}
