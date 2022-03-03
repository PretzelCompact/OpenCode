package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task4 {
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите n (число повторений):");
        n = Integer.parseInt(br.readLine());
        System.out.println("Введите m (ограничение по количеству слов)");
        m = Integer.parseInt(br.readLine());

        System.out.println("Введите строку:");
        var sb = new StringBuilder();
        Arrays.stream(br.readLine().split(" ")).toList().forEach(word->{
            word += ", ";
            processWord(sb,word);
        });

        System.out.println(sb.toString());
    }
    private static void processWord(StringBuilder sb, String word){
        for(int i = 0; i < n && m>0; i++, m--){
            sb.append(word);
        }
    }
}
