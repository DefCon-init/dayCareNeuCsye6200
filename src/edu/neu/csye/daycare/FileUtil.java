package edu.neu.csye.daycare;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class FileUtil {
/*
    Class to handle File reading and writing operations
*/

    public static List<String> readCsv(String filePath) throws IOException {
        FileReader fin = new FileReader(filePath);
        try (BufferedReader br = new BufferedReader(fin)) {
            List<String> csv = new ArrayList<>();
            String lineArray;

            while((lineArray = br.readLine()) != null) {
                csv.add(lineArray);
            }

            return csv;
        }
    }

    public static void writeToCsv(String FilePath, String[] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FilePath));

        Arrays.stream(arr).forEach(str -> {
            try {
                bw.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bw.close();
    }

    public static int DobToAge(Date d) {
        Calendar todayDate = new GregorianCalendar();
        Calendar bday = new GregorianCalendar();
        bday.setTime(d);
        int yearsInBetween = todayDate.get(Calendar.YEAR) - bday.get(Calendar.YEAR);
        int monthsDiff = todayDate.get(Calendar.MONTH) - bday.get(Calendar.MONTH);
        int ageInMonths = yearsInBetween*12 + monthsDiff;

        return ageInMonths;
    }

    public static String DateToString(Date d) {
        String datef = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH).format(d);
        return datef;
    }

}
