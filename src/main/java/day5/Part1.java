package day5;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws IOException {
        int sum = calculate();
        System.out.println("The answer is: "+sum);
    }

    private static int calculate() throws IOException {
        File file = new File("src/main/resources/day5/input.txt");

        Scanner scanner = new Scanner(file);
        HashMap<Integer, ArrayList<Integer>> pages = new HashMap();

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if(line.isEmpty()){
                break;
            }
            String[] parts = line.trim().split("\\|");

            if(pages.containsKey(Integer.valueOf(parts[0]))){
                ArrayList<Integer> newList;
                newList = pages.get(Integer.valueOf(parts[0]));
                newList.add(Integer.valueOf(parts[1]));
                pages.put(Integer.valueOf(parts[0]),newList);
            }else{
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(Integer.valueOf(parts[1]));
                pages.put(Integer.valueOf(parts[0]), newList);
            }
        }
        System.out.println(pages);
        int sum=0;
        while(scanner.hasNext()) {
            boolean isValid = true;
            String line = scanner.nextLine();
            String[] parts = line.trim().split(",");
            //todo
            for (int i = 0; i < parts.length; i++) {

            }
            if (isValid) {
                sum += Integer.parseInt(parts[parts.length / 2]);
            }
        }
        return sum;
    }



}

