import java.io.BufferedReader;
import java.io.IOException;

public class Task1_5 implements ITask{

    @Override
    public void execute(BufferedReader br) throws IOException {
        String str = "Hello World!";
        for(char c : str.toCharArray()){
            System.out.println(c + " " + (int)c);
        }
    }
}
