import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class day2 {
    private static Scanner input;
    
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException x) {
            // file not found
        }

        int total = 0;
        while (input.hasNextLine()) {
            String lineString = input.nextLine();
            Scanner line = new Scanner(lineString);
            line.next();
            String idString = line.next();
            int colonIndex = idString.indexOf(':');
            int id = Integer.parseInt(idString.substring(0, colonIndex));
            // System.out.println(id);

            int maxRed = 0;
            int maxBlue = 0;
            int maxGreen = 0;
            while (line.hasNext()) {
                int number = line.nextInt();
                String color = line.next();
                if (!(color.indexOf(';') == -1 && color.indexOf(',') == -1)) {
                    color = color.substring(0, color.length() - 1);
                }

                if (color.equals("blue")) {
                    if (number > maxBlue) {
                        maxBlue = number;
                    }
                }
                else if (color.equals("green")) {
                    if (number > maxGreen) {
                        maxGreen = number;
                    }
                }
                else if (color.equals("red")) {
                    if (number > maxRed) {
                        maxRed = number;
                    }
                }
            }

            total += (maxBlue * maxGreen * maxRed);
            line.close();
        }
        input.close();
        System.out.println(total);
    }
}