package day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {
    public static void main(String[] args) throws IOException {
        long sum = 0;
        char[][] input = loadInput();

        // Horizontal looking
        for (int i = 0; i < input.length; i++) {
            StringBuilder horizontal = new StringBuilder();
            for (int j = 0; j < input[i].length; j++) {
                horizontal.append(input[i][j]);
            }
            sum += wordCounter(horizontal.toString());
            sum += wordCounter(horizontal.reverse().toString());
        }

        // Vertical looking
        for (int i = 0; i < input.length; i++) {
            StringBuilder vertical = new StringBuilder();
            for (int j = 0; j < input.length; j++) {
                vertical.append(input[j][i]);
            }
            sum += wordCounter(vertical.toString());
            sum += wordCounter(vertical.reverse().toString());
        }

        // Diagonal looking
        for (int k = 0; k < 2 * input.length - 1; k++) {
            int startRow = k < input.length ? k : input.length - 1;
            int startCol = k < input.length ? 0 : k - input.length + 1;

            int i = startRow, j = startCol;
            StringBuilder diagonal = new StringBuilder();
            while (i >= 0 && j < input.length) {
                diagonal.append(input[i][j]);
                i--;
                j++;
            }
            sum += wordCounter(diagonal.toString());
            sum += wordCounter(diagonal.reverse().toString());
        }

        // Reverse diagonal looking
        for (int k = 0; k < 2 * input.length - 1; k++) {
            int startRow = k < input.length ? k : input.length - 1;
            int startCol = k < input.length ? input.length - 1 : input.length - 1 - (k - input.length + 1);

            int i = startRow, j = startCol;
            StringBuilder reverseDiagonal = new StringBuilder();
            while (i >= 0 && j >= 0) {
                reverseDiagonal.append(input[i][j]);
                i--;
                j--;
            }
            sum += wordCounter(reverseDiagonal.toString());
            sum += wordCounter(reverseDiagonal.reverse().toString());
        }

        System.out.println(sum);
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

    private static long wordCounter(String line) {
        Pattern pattern = Pattern.compile("XMAS");
        long count = 0;
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

}
