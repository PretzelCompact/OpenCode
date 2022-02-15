import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] ags) throws IOException {
        var sentence = Task5.GetSentence();

        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        var sbMin = new StringBuilder();
        var sbMax = new StringBuilder();

        for(int i = 0; i < sentence.getWordsCount(); i++){
            var word = sentence.getWordByPosition(i);
            int length = word.getSymbolCount();

            if(length < minLength){
                minLength = length;
                sbMin = new StringBuilder(word.getOriginalWord());
            } else if (length == minLength){
                sbMin.append(' ');
                sbMin.append(word.getOriginalWord());
            }

            if(length > maxLength){
                maxLength = length;
                sbMax = new StringBuilder(word.getOriginalWord());
            } else if (length == maxLength){
                sbMax.append(' ');
                sbMax.append(word.getOriginalWord());
            }
        }

        System.out.println("Слова минимальной длины:");
        System.out.println(sbMin.toString());

        System.out.println("Слова максимальной длины:");
        System.out.println(sbMax.toString());
    }
}
