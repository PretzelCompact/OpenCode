import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) throws IOException {
        var sentence = GetSentence();
        System.out.println("Разбираем строку, а затем снова собираем:");
        System.out.println(sentence.getOriginalSentence());
    }
    public static Sentence GetSentence() throws IOException{
        var br = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Введите предложение");
        var str = br.readLine();
        var sentence = new Sentence(str.split(" "));
        return sentence;
    }
}
