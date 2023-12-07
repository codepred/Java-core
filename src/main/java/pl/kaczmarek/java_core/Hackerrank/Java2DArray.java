package pl.kaczmarek.java_core.Hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Java2DArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int max = -999999999;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                int currentMax = arr.get(i).get(j) +  arr.get(i).get(j+1) +  arr.get(i).get(j+2);
                currentMax += arr.get(i+1).get(j+1);
                currentMax += arr.get(i+2).get(j) +  arr.get(i+2).get(j+1) +  arr.get(i+2).get(j+2);
                if(currentMax>max){
                    max = currentMax;
                }
            }
        }
        System.out.println(max);
        bufferedReader.close();
    }
}
