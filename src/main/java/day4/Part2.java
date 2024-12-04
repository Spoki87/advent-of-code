package day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws IOException {
        char[][] input = loadInput();

        int sum = calculate(input);

        System.out.println("Answer is: "+sum);
    }


    private static int calculate(char[][] input){
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] == 'A'){
                    try {
                        if (input[i - 1][j - 1] == 'M' && input[i - 1][j + 1] == 'M' && input[i + 1][j - 1] == 'S' && input[i + 1][j + 1] == 'S') {
                            sum++;
                        }
                        if (input[i - 1][j - 1] == 'M' && input[i - 1][j + 1] == 'S' && input[i + 1][j - 1] == 'M' && input[i + 1][j + 1] == 'S') {
                            sum++;
                        }
                        if (input[i - 1][j - 1] == 'S' && input[i - 1][j + 1] == 'M' && input[i + 1][j - 1] == 'S' && input[i + 1][j + 1] == 'M') {
                            sum++;
                        }
                        if (input[i - 1][j - 1] == 'S' && input[i - 1][j + 1] == 'S' && input[i + 1][j - 1] == 'M' && input[i + 1][j + 1] == 'M') {
                            sum++;
                        }
                    }catch(Exception e){
                        //System.out.println("Out of range");
                    }
                }
            }

        }

        return sum;
    }

    private static char[][] loadInput() throws IOException {
        File file = new File("src/main/resources/day4/input.txt");
        Path path = Paths.get("src/main/resources/day4/input.txt");

        Scanner scanner = new Scanner(file);
        int size = (int) Files.lines(path).count();
        char[][] table = new char[size][size];

        int index = 0;
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                table[index][i] = line.charAt(i);
            }
            index++;
        }
        return table;
    }
}
