package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Task5 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("Введите число или exit:");
            var str = br.readLine();
            if(str.equals("exit"))
                return;

            int n = Integer.parseInt(str);
            if(n <= 0){
                System.out.println("Число должно быть больше нуля");
                continue;
            }

            var stream = IntStream.generate(new FibaSup());
            boolean exists = stream.limit(46).anyMatch((number)->number == n);
            System.out.println(
                    exists ? "Оно входит в ряд Фибы" : "Оно не входит в ряд Фибы"
            );
            System.out.println("----------------------");
            stream.close();
        }
    }
    private static class FibaSup implements IntSupplier{
        int prev = 0;
        int cur = 1;

        @Override
        public int getAsInt(){
            int result = cur;
            cur += prev;
            prev = result;
            return result;
        }
    }
}