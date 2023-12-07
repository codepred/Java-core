package pl.kaczmarek.java_core.Hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<String> names = new ArrayList<String>();
        for(int i=0; i<testCases; i++){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            names.add(fname);
        }
//        names.stream().sorted((word1, word2)-> word1.compareTo(word2) ).forEach(s -> System.out.println(s));
         Collections.sort(names);
    }
}
