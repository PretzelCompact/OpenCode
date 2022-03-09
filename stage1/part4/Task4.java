package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Введите N (количество копий):");
            int n = Integer.parseInt(br.readLine());

            System.out.println("Введите M (используемое количество слов в строке)");
            int m = Integer.parseInt(br.readLine());

            System.out.println("Введите L (максимальное число слов в конечной строке):");
            int l = Integer.parseInt(br.readLine());

            System.out.println("Введите строку:");
            String str = myMethod(br.readLine(),n,m,l);
            System.out.println(str + "\n----------------------------");
        }
    }
    public static String myMethod(String str, int n, int m, int l){
        str = Arrays.stream(str.split(" "))
                .limit(m)
                .collect(Collectors.joining(", "));
        str+=",";

        var sb = new StringBuilder(str);
        while(n-- > 0){
            sb.append(" " + str);
        }

        var resultBuilder = new StringBuilder();
        Arrays.stream(sb.toString().split(" "))
                .limit(l)
                .forEach(w->resultBuilder.append(w + " "));

        return  resultBuilder.toString();
    }
}
