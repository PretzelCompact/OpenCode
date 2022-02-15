import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] ags) throws IOException {
        var br = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Введите строку:");
        var str = br.readLine();

        var result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(Character.isAlphabetic(c) || c == ' ')
                result.append(c);
        }
        System.out.println("Форматированная строка:\n" + result);
    }
}
