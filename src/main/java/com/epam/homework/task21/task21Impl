package com.epam.homework.task21;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class task21Impl implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {

        List<String> strings = new ArrayList<>();
        String line;

        BufferedReader reader = new BufferedReader(new FileReader(input));

        while ((line = reader.readLine()) != null) {
            strings.add(line);
        }
        Collections.reverse(strings);

        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        for (String lines : strings) {
                writer.write(lines);
                writer.newLine();
        }
        writer.flush();
        writer.close();
        reader.close();
        return strings;
    }

    public static void main(String[] args) throws IOException {
        String input = "C:\\Users\\Matvey\\Desktop\\input.txt";
        String output = "C:\\Users\\Matvey\\Desktop\\output.txt";

        task21Impl run = new task21Impl();
        run.reverseFile(new File(input), new File(output));
    }
}

