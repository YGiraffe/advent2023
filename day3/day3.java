import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class day3 {
    private static Scanner input;
    private static Scanner input2;
    
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            input = new Scanner(file);
            input2 = new Scanner(file);
        } catch (FileNotFoundException x) {
            // file not found
        }

        int total = 0;
        int numLines = 0;

        while (input2.hasNextLine()) {
            input2.nextLine();
            numLines++;
        }
        input2.close();

        String[] inputArray = new String[numLines];
        int curLine = 0;
        while (input.hasNextLine()) {
            inputArray[curLine] = input.nextLine();
            // while (inputArray[curLine].indexOf(".") != -1) {
            //     inputArray[curLine] = inputArray[curLine].replace(".", "");
            // }
            // System.out.println(inputArray[curLine]);
            curLine++;
        }

        int[][] intArray = new int[numLines][20];

        for (int i = 0; i < numLines; i++) {
            int curNumber = 0;
            int curIndex = 0;
            for (int j = 0; j < inputArray[0].length(); j++) {
                // System.out.println(inputArray[i].charAt(j));
                if (Character.isDigit(inputArray[i].charAt(j))) {
                    curNumber = curNumber * 10 + Character.getNumericValue(inputArray[i].charAt(j));
                }
                else if (curNumber != 0) {
                    // System.out.println(curNumber);
                    intArray[i][curIndex] = curNumber;
                    curIndex++;
                    curNumber = 0;
                }
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                if (intArray[i][j] != 0) {
                    // System.out.println(intArray[i][j]);
                    int sIndex = inputArray[i].indexOf(Integer.toString(intArray[i][j]));
                    int numDigits = String.valueOf(intArray[i][j]).length();
                    boolean check = false;
                    for (int k = 0; k < numDigits; k++) {
                        if (checkBox(inputArray, i, sIndex + k)) {
                            check = true;
                        }
                    }
                    if (check) {
                        if (i == 92) {
                            System.out.println("adding " + intArray[i][j] + " to total");
                        }
                        total += intArray[i][j];
                    }
                    // inputArray[i] = inputArray[i].replace(Integer.toString(intArray[i][j]), "");
                }
            }
        }
        
        input.close();
        System.out.println(total);
    }

    public static boolean checkBox(String[] array, int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i > -1 && i < array.length && j > -1 && j < array[i].length()) {
                    if (!Character.isDigit(array[i].charAt(j)) && array[i].charAt(j) != '.') {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}