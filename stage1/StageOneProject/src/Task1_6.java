import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Task1_6 implements ITask{
    @Override
    public void execute(BufferedReader br) throws IOException {
        String str = "Hello World!";
        var arr = str.toCharArray();

        var foundChars = new HashSet<Character>();

        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            if(foundChars.contains(c))
                continue;
            foundChars.add(c);
            int counter = 0;
            for(int j = i; j < arr.length; j++)
                if(arr[j]==c)
                    counter++;
            if(counter > 1)
                System.out.println(c + ": " + counter);
        }
    }
}
