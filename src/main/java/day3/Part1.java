package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Character> characters = loadList();
        int sum = calculate(characters);
        System.out.println("The answer is: "+sum);
    }

    private static ArrayList<Character> loadList() throws FileNotFoundException {

        File file = new File("src/main/resources/day3/input.txt");

        Scanner scanner = new Scanner(file);

        ArrayList<Character> stringLinkedList = new ArrayList<>();

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            int index = 0;
            while(index<line.length()){
                stringLinkedList.add(line.toCharArray()[index]);
                index++;
            }
        }
        return stringLinkedList;
    }

    private static boolean isNumber(char x){
        return x == '0' || x == '1' || x == '2' || x == '3' || x == '4' || x == '5' || x == '6' || x == '7' || x == '8' || x == '9';
    }

    private static int calculate(ArrayList<Character> characters){
        int sum = 0;
        for (int i=3;i<characters.size()-3;i++){
            //pierwsza liczba jednocyfrowa
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && characters.get(i+2)==',' && isNumber(characters.get(i+3)) && characters.get(i+4)==')'){
                String number1 = String.valueOf(characters.get(i+1));
                String number2 = String.valueOf(characters.get(i+3));
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && characters.get(i+2)==',' && isNumber(characters.get(i+3)) && isNumber(characters.get(i+4))&& characters.get(i+5)==')' ){
                String number1 = String.valueOf(characters.get(i+1));
                String number2 = String.valueOf(characters.get(i+3)) + characters.get(i+4);
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && characters.get(i+2)==',' && isNumber(characters.get(i+3)) && isNumber(characters.get(i+4))&& isNumber(characters.get(i+5)) && characters.get(i+6)==')' ){
                String number1 = String.valueOf(characters.get(i+1));
                String number2 = String.valueOf(characters.get(i+3)) + characters.get(i+4)+ characters.get(i+5);
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
            //pierwsza liczba jest dwucyfrowa
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && isNumber(characters.get(i+2)) && characters.get(i+3)==',' && isNumber(characters.get(i+4)) && characters.get(i+5)==')'){
                String number1 = String.valueOf(characters.get(i+1)) + characters.get(i+2);
                String number2 = String.valueOf(characters.get(i+4));
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && isNumber(characters.get(i+2)) && characters.get(i+3)==',' && isNumber(characters.get(i+4)) && isNumber(characters.get(i+5))&& characters.get(i+6)==')'){
                String number1 = String.valueOf(characters.get(i+1)) + characters.get(i+2);
                String number2 = String.valueOf(characters.get(i+4)) + characters.get(i+5);
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && isNumber(characters.get(i+2)) && characters.get(i+3)==',' && isNumber(characters.get(i+4)) && isNumber(characters.get(i+5))&& isNumber(characters.get(i+6))&& characters.get(i+7)==')'){
                String number1 = String.valueOf(characters.get(i+1)) + characters.get(i+2);
                String number2 = String.valueOf(characters.get(i+4)) + characters.get(i+5) + characters.get(i+6);
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
            //pierwsza liczba jest trzycyfrowa
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && isNumber(characters.get(i+2)) && isNumber(characters.get(i+3))&& characters.get(i+4)==',' && isNumber(characters.get(i+5)) && characters.get(i+6)==')'){
                String number1 = String.valueOf(characters.get(i+1)) + characters.get(i+2) + characters.get(i+3);
                String number2 = String.valueOf(characters.get(i+5));
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && isNumber(characters.get(i+2)) && isNumber(characters.get(i+3))&& characters.get(i+4)==',' && isNumber(characters.get(i+5)) && isNumber(characters.get(i+6)) && characters.get(i+7)==')'){
                String number1 = String.valueOf(characters.get(i+1)) + characters.get(i+2) + characters.get(i+3);
                String number2 = String.valueOf(characters.get(i+5)) + characters.get(i+6);
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
            if(characters.get(i-3) == 'm' && characters.get(i-2) == 'u' && characters.get(i-1) == 'l' && characters.get(i) == '(' && isNumber(characters.get(i+1)) && isNumber(characters.get(i+2)) && isNumber(characters.get(i+3))&& characters.get(i+4)==',' && isNumber(characters.get(i+5)) && isNumber(characters.get(i+6)) && isNumber(characters.get(i+7)) && characters.get(i+8)==')'){
                String number1 = String.valueOf(characters.get(i+1)) + characters.get(i+2) + characters.get(i+3);
                String number2 = String.valueOf(characters.get(i+5)) + characters.get(i+6) + characters.get(i+7);
                sum = sum + (Integer.parseInt(number1) * Integer.parseInt(number2));
            }
        }
        return sum;
    }
}
