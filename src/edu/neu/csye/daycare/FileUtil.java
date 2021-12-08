package edu.neu.csye.daycare;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
/*
    Class to handle File reading and writing operations
*/

    public List<String> readCsv(String filePath) throws IOException {
        FileReader fin = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fin);

        List<String> csv = new ArrayList<>();
        String lineArray;

        while((lineArray = br.readLine()) != null) {
            csv.add(lineArray);
        }

        return csv;
    }

    public void writeToCsv(String FilePath, String[] arr) throws IOException {
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

}
