import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Task1 {
    public static  void main(String[] args) throws IOException {
        var br = new BufferedReader((new InputStreamReader(System.in)));
        while(true){
            int firstNum;
            int secondNum;
            int k;

            System.out.println("Введите exit или первое число ряда Фибоначчи:");
            var str = br.readLine();
            if(str == "exit")
                return;
            firstNum = Integer.parseInt(str);

            System.out.println("Введите exit или второе число ряда Фибоначчи:");
            str = br.readLine();
            if(str == "exit")
                return;
            secondNum = Integer.parseInt(str);

            System.out.println("Введите exit или номер элемента ряда Фибоначчи:");
            str = br.readLine();
            if(str == "exit")
                return;
            k = Integer.parseInt(str);

            int result = FibonacciSequence.GetNumber(firstNum,secondNum,k);
            System.out.println("Число номер k вашего ряда Фибоначи: " + result);
            System.out.println("----------------------------");
        }
    }
}

class FibonacciSequence{
    //Кеширование последовательностей Фибоначчи
    private static HashMap<String,FibonacciSequence> sequences;

    //Создать ключ для HasMap
    private static String buildKey(int firstNumber, int secondNumber){
        return firstNumber+"/"+secondNumber;
    }

    //Получить число из заданной последовательности Фибоначчи
    public static int GetNumber(int firstNumber, int secondNumber, int k){
        var seq = GetSequence(firstNumber, secondNumber);
        return  seq.GetNumber(k);
    }

    //Получить заданную последовательность Фибоначчи
    public static FibonacciSequence GetSequence(int firstNumber, int secondNumber){
        if(sequences == null)
            sequences = new HashMap<String,FibonacciSequence>();

        String key = buildKey(firstNumber,secondNumber);
        var seq = sequences.get(key);
        if(seq == null){
            seq = new FibonacciSequence(firstNumber,secondNumber);
            sequences.put(key,seq);
        }
        return seq;
    }

    private int[] numbers; //Массив с числами Фибоначчи
    private int maxNum; //Максимальное вычисленное число послеодвательности
    private final int defaultCapacity = 20; //Вместимость массива по умолчанию
    private FibonacciSequence(int firstNumber, int secondNumber){
        numbers = new int[defaultCapacity];
        numbers[0] = firstNumber;
        numbers[1] = secondNumber;
        maxNum = 1;
    }

    //Получить число номер k из данной последовательности
    public int GetNumber(int k){
        if(k-1 <= maxNum)
            return numbers[k-1];
        if(k > numbers.length){
            var newNumbers = new int[k];
            System.arraycopy(numbers,0,newNumbers,0,numbers.length);
            numbers = newNumbers;
        }
        for(int i = maxNum +1; i < k; i++){
            numbers[i]=numbers[i-2]+numbers[i-1];
        }
        maxNum = k-1;
        return numbers[k-1];
    }

    @Override
    public String toString(){
        var sb = new StringBuilder();
        sb.append(numbers[0]);
        for(int i = 1; i < maxNum; i++) {
            sb.append(' ');
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
}
