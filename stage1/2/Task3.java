import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] ags) throws IOException {
        var br = new BufferedReader((new InputStreamReader(System.in)));
        var sentence = Task5.GetSentence();

        int k;
        char sym;

        System.out.println("Введите номер символа в строке:");
        k = Integer.parseInt(br.readLine());
        System.out.println("Введите новый символ:");
        sym = br.readLine().charAt(0);

        var sb = new StringBuilder();
        for(int i = 0; i < sentence.getWordsCount(); i++){
            Word word = sentence.getWordByPosition(i);
            if(k<word.getSymbolCount())
                word.ReplaceAt(sym,k);
            sb.append(word.getOriginalWord());
            sb.append(' ');
        }
        System.out.println("Преобразованная строка:" + sb.toString());
    }
}
