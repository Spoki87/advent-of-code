package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        String input = loadInput();
        int sum = calculate(input);
        System.out.println("The answer is: "+sum);
    }

    private static String loadInput() throws FileNotFoundException {

        File file = new File("src/main/resources/day3/input.txt");

        Scanner scanner = new Scanner(file);

        String input = "";

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            input = input + line;
        }
        return input;
    }

    private static int calculate(String input){
        int sum = 0;

        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|don't\\(\\)|do\\(\\)");
        Matcher matcher = pattern.matcher(input);

        boolean isEnable = true;
        while (matcher.find()) {
            if(matcher.group().equals("do()")){
                isEnable = true;
            }else if(matcher.group().equals("don't()")){
                isEnable = false;
            }else{
                if(isEnable){
                    int firstNumber = Integer.parseInt(matcher.group(1));
                    int secondNumber = Integer.parseInt(matcher.group(2));
                    sum += firstNumber * secondNumber;
                }
            }
        }
        return sum;
    }
}
