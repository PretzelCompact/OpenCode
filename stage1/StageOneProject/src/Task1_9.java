import java.io.BufferedReader;
import java.io.IOException;
import java.util.Locale;

public class Task1_9 implements ITask{

    @Override
    public void execute(BufferedReader br) throws IOException {
        System.out.println("Введите предложение:");
        var str = br.readLine();
        str = str.replace(" ","").toLowerCase();

        if(isPoly(str))
            System.out.println("Это палиндром");
        else
            System.out.println("Это не палиндром");
    }
    private boolean isPoly(String str){
        if(str.length()==1)
            return true;

        for(int i = 0; i <= str.length()/2;i++){
            int j = str.length()-i-1;
            if(str.charAt(i)!=str.charAt(j))
                return false;
        }
        return true;
    }
}
