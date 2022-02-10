import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;

public class Task1_7 implements ITask{

    @Override
    public void execute(BufferedReader br) throws IOException {
        int i = 100;
        while(i > 0){
            System.out.println(getOpening(i) +
                    " на столе, одна из них упала и разиблась");
            i--;
        }
    }
    public String getOpening(int number)
    {
        String result = number + " ";
        int last = number % 10;
        if(last == 1)
            result +="бутылка стояла";
        else if(last != 0 && last <= 4)
            result+="бутылки стояли";
        else
            result+="бутылок стояло";
        return  result;
    }
}
