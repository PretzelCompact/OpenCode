package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Task6 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("Введите число простых чисел:");
            int n = Integer.parseInt(br.readLine());

            IntStream.generate(new PrimeSup()).limit(n).forEach(p->System.out.print(p+", "));
            System.out.print("\n-------------------------------\n");
        }

    }
    private static class PrimeSup implements IntSupplier{
        int lastNum = 1;
        HashSet<Integer> primes = new HashSet<>();

        @Override
        public int getAsInt(){
            boolean isPrime;
            do{
                lastNum++;
                isPrime = primes.stream().allMatch((p)->lastNum%p!=0);
            } while(!isPrime);

            primes.add(lastNum);
            return lastNum;
        }
    }
}
