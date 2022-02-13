import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bonus {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] params;
        boolean result;

        while(true){
            params = new boolean[4];
            for(int i = 0; i < params.length; i++){
                System.out.println("Введите bool x"+(i+1)+":");
                params[i] = Boolean.parseBoolean((br.readLine()));
            }

            System.out.println("1-СДНФ\n"+
                    "2-СКНФ\n"+
                    "3-Полином Жегалкина\n"+
                    "4-Brute solution");

            switch(br.readLine()){
                case "1":
                    result=sdnf(params[0],params[1],params[2],params[3]);
                    break;
                case "2":
                    result=sknf(params[0],params[1],params[2],params[3]);
                    break;
                case "3":
                    result=zhegalkinPolynominal(params[0],params[1],params[2],params[3]);
                    break;
                case "4":
                    result=vLob(params[0],params[1],params[2],params[3]);
                    break;
                default:
                    return;
            }
            System.out.println("Output: " + result);
            System.out.println(("----------------------------"));
        }
    }
    //Совершенная дизъюнктивная нормальная форма
    public static boolean sdnf(boolean x1, boolean x2, boolean x3, boolean x4){
        return !x1 && !x2 && x3 && x4 ||
                !x1 && x2 && !x3 && x4 ||
                !x1 && x2 && x3 && !x4 ||
                x1 && !x2 && !x3 && x4 ||
                x1 && !x2 && x3 && !x4 ||
                x1 && x2 && !x3 && !x4;
    }
    //Совершенная конъюнктивная нормальная форма
    public static boolean sknf(boolean x1, boolean x2, boolean x3, boolean x4){
        return (!x1 || !x2 || !x3 || !x4) &&
                (!x1 || !x2 || !x3 || x4) &&
                (!x1 || !x2 || x3 || !x4) &&
                (!x1 || x2 || !x3 || !x4) &&
                (!x1 || x2 || x3 || x4) &&
                (x1 || !x2 || !x3 || !x4) &&
                (x1 || !x2 || x3 || x4) &&
                (x1 || x2 || !x3 || x4) &&
                (x1 || x2 || x3 || !x4) &&
                (x1 || x2 || x3 || x4);
    }
    //Полином Жегалкина
    public static boolean zhegalkinPolynominal(boolean x1, boolean x2, boolean x3, boolean x4){
        return (x3 && x4) ^
                (x2 && x4) ^
                (x2 && x3) ^
                (x2 && x3 && x4) ^
                (x1 && x4) ^
                (x1 && x3) ^
                (x1 && x3 && x4) ^
                (x1 && x2) ^
                (x1 && x2 && x4) ^
                (x1 && x3 && x4);
    }
    //Решение "в лоб"
    public static boolean vLob(boolean x1, boolean x2, boolean x3, boolean x4){
        int counter = 0;
        if(x1)
            counter++;
        if(x2)
            counter++;
        if(x3)
            counter++;
        if(x4)
            counter++;
        return counter == 2;
    }
}
