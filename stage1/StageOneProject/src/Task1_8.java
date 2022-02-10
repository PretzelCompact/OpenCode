import java.io.BufferedReader;
import java.io.IOException;

public class Task1_8 implements ITask{
    @Override
    public void execute(BufferedReader br) throws IOException {
        System.out.println("Введите математическое выражение:");
        var str = br.readLine();
        System.out.println("Ответ: " + CalculatePlusMinus(str));

    }
    private double CalculatePlusMinus(String str){
        for(int i = 0; i < str.length(); i++){
            var c = str.charAt(i);
            if(c == '+' || c == '-'){
                double left = CalculateMultDiv(str.substring(0,i));
                var right = str.substring(i+1,str.length());
                if(c == '+')
                    return left + CalculatePlusMinus(right);
                else
                    return left - CalculatePlusMinus(right);
            }
        }
        return CalculateMultDiv(str);
    }
    private double CalculateMultDiv(String str){
        for(int i = 0; i < str.length(); i++){
            var c = str.charAt(i);
            if(c == '*' || c == '/'){
                double left = Double.parseDouble(str.substring(0,i));
                var right = str.substring(i+1,str.length());
                if(c == '*')
                    return left * CalculateMultDiv(right);
                else
                    return left / CalculateMultDiv(right);
            }
        }
        return Double.parseDouble(str);
    }
}
