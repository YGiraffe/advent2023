import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class reader {
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
            
        }
        input.close();
        System.out.println(total);
    }
}
