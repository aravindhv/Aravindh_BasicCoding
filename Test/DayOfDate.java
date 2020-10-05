import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DayOfDate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String day = in.next();
        String month = in.next();
        String year = in.next();
        String input_date = day + "/" + month + "/" + year;
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            DateFormat format2 = new SimpleDateFormat("EEEE");
            String final_day = format2.format(format1.parse(input_date));
            System.out.println(final_day.toUpperCase());
        }
        catch(Exception e){}
    }
}
