import java.io.IOException;
import java.util.*;

public class DateSchedule {
    public DateSchedule (String text) throws IOException {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9","01", "02", "03", "04", "05", "06", "07", "08", "09"};
        List<String> gradeScale = new ArrayList<String>();
        Scanner scanner = new Scanner(text);
        HashMap<String, String> workDates = new HashMap<String, String>();

        while (scanner.hasNextLine()) {
            String current = scanner.nextLine();
            if (stringContainsItemFromList(current, months) && stringContainsItemFromList(current, days)) {
                String split[] = current.split(" ", 3);
                workDates.put(split[0] + split[1], split[2].replaceAll("[0-9]", ""));
            }
            else if (stringContainsItemFromList(current, months) ){
                String split[] = current.split(" ", 2);
                workDates.put(split[0], split[1]);
            }
        }
    }

    public static boolean stringContainsItemFromList(String inputStr, String[] items) {
        return Arrays.stream(items).parallel().anyMatch(inputStr::contains);
    }


}