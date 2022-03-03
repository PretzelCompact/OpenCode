package part4;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

public class Task7 {
    private static String textPath="src/part4/text.txt";
    private static String resultPath="src/part4/result.txt";

    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу с текстом:");
        textPath = br.readLine();
        System.out.println("Введите путь сохраняемого результата:");
        resultPath = br.readLine();
        String str = "";
        int i;
        try (BufferedReader fin = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(textPath))))){
            str = fin.readLine();
        } catch (InvalidPathException e){
            System.out.print("InvalidPathException");
        } catch (IOException e){
            System.out.print("I/O Exception");
        }
        System.out.println("Исходный текст:\n" + str);
        var words = str.split(" ");
        System.out.println("Текст без дублиатов:");
        Task2.fooBar(words);
        processAnalysis(words);
    }

    private static final Character[] glaslArray = new Character[]{
            'а','о','у','ы','э','я','ё','ю','и','е'
    };
    private static void processAnalysis(String[] words){
        Counter counter = new Counter();

        Arrays.stream(words).forEach((word)->{
            char firstChar = word.toLowerCase(Locale.ROOT).charAt(0);
            boolean isGlas = Arrays.stream(glaslArray).anyMatch(c->c.equals(firstChar));
            counter.correct(isGlas);
        });

        var formater = new Formatter();
        formater.format(
                "Всего слов:%d\n" +
                "Из них:\n" +
                "Начиинаются с согласной: %d\n" +
                "Начинаются с гласной: %d\n",
                words.length, counter.sogl,counter.glas);

        try(FileOutputStream fos = new FileOutputStream(resultPath)){
            var bytes = formater.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException e){
            System.out.println("I/O Exception");
        }
    }
    private static class Counter{
        public int glas;
        public int sogl;

        public void correct(boolean isGlas){
            if(isGlas)
                glas++;
            else
                sogl++;
        }
    }
}
