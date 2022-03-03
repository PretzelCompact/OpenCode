package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class Task3 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        Predicate<Integer> myFuncInterface = (n)->n%13==0;

        while(true){
            System.out.println("Введите число или exit:");
            var str = br.readLine();
            if(str.equals("exit"))
                return;
            int n = Integer.parseInt(str);
            System.out.println(
                    myFuncInterface.test(n) ? "Оно делится на 13" : "Оно не делится на 13"
            );
            System.out.println("------------------------");
        }
    }
}
