package pl.kaczmarek.java_core.Hackerrank;


import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;



public class Java1DArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for(int i=0; i<n; i++) {
            List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            for (int j = 0; j < a.size(); j++) {
                System.out.println(a.get(j));
            }

        }

        bufferedReader.close();
    }
}
