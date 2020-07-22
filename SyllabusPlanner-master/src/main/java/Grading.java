import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grading {
    public Grading (String text) throws IOException {
        Scanner scanner = new Scanner(text);
        List<String> gradeScale = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                    String current = scanner.nextLine();
                    if (current.endsWith("%")) {
                        current = current.replaceAll("\\s+"," ");
                        gradeScale.add(current);
                    }
                    else if (current.endsWith("% ")) {
                        current = current.replaceAll("\\s+"," ");
                        gradeScale.add(current);
                    }
            }
    scanner.close();
    }
}