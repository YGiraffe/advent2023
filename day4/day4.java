import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class day4 {
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

        int numLines = 0;
        while (input2.hasNextLine()) {
            input2.nextLine();
            numLines++;
        }
        input2.close();

        int[] cardCopies = new int[numLines];
        for (int i = 0; i < cardCopies.length; i++) {
            cardCopies[i] = 1;
        }
        int total = 0;
        int i = 0;
        while (input.hasNextLine()) {
            String lineString = input.nextLine();
            int points = 0;
            String winningNumbers = lineString.substring(0, lineString.indexOf("|"));
            Scanner line = new Scanner(lineString.substring(lineString.indexOf("|") + 1));

            while (line.hasNext()) {
                String curNumber = line.next();
                if (winningNumbers.indexOf(" " + curNumber + " ") != -1) {
                    points++;
                    // System.out.println("winning number: " + curNumber);
                }
            }

            int copies = cardCopies[i];
            for (int j = 0; j < points; j++) {
                cardCopies[i + j + 1] += copies;
            }
            line.close();
            i++;
        }

        for (int j = 0; j < cardCopies.length; j++) {
            System.out.println("copies of card " + j + ": " + cardCopies[j]);
            total += cardCopies[j];
        }

        input.close();
        System.out.println(total);
    }
}
