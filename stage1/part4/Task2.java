package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class Task2 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите предложение:");
        fooBar(br.readLine().split(" "));
    }
    public static void fooBar(String[] words){
        var sentence = new Sentence(words);
        Predicate<Integer> myPredicate = (pos)->{
            var checkingWord = sentence.getWordByPosition(pos).getOriginalWord();
            for(int n = 0; n < pos;n++){
                if(sentence.getWordByPosition(n).getOriginalWord().equals(checkingWord))
                    return true;
            }
            return false;
        };

        int i = 0;
        while(i < sentence.getWordsCount()){
            if(!myPredicate.test(i))
                System.out.print(sentence.getWordByPosition(i).getOriginalWord() + ' ');
            i++;
        }
    }
}
