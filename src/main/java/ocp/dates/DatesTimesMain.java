package ocp.dates;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatesTimesMain {

    public static void main(String[] args) {

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());


        System.out.println(LocalDate.of(2022, Month.APRIL, 30));

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd, yyyy 'at' hh:mm:ss a");
        System.out.println(formatter.format(localDateTime));
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("MM/dd, yyyy 'at' hh:mm:ss a Z").format(zonedDateTime));

        System.out.println(Locale.getDefault());

        System.out.println(NumberFormat.getInstance(new Locale("fr", "FR")).getCurrency());
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("fr", "FR")).getCurrency());

        var d = 1234567.444;
        var dt = new DecimalFormat("###, ###, ###.0000");
        System.out.println(dt.format(d));










    }

}
