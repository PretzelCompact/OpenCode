package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите n (число повторений):");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Введите m (ограничение по количеству слов)");
        int m = Integer.parseInt(br.readLine());

        System.out.println("Введите строку:");
        Arrays.stream(br.readLine().split(" "))
                .flatMap(w -> {
                    w += ", ";
                    var arr = new String[n];
                    for(int i = 0; i < n; i++)
                        arr[i] = w;
                    return Arrays.stream(arr);
                })
                .limit(m)
                .forEach(System.out::print);
    }
}
