import java.io.BufferedReader;
import java.io.IOException;

public class Task1_3 implements ITask{
    @Override
    public void execute(BufferedReader br) throws IOException {
        System.out.println("Введите bool A:");
        boolean a = Boolean.getBoolean(br.readLine());
        System.out.println("Введите bool B:");
        boolean b = Boolean.getBoolean(br.readLine());

        System.out.println();
        System.out.println("A and B = " + (a && b));
        System.out.println("A or B = " + (a || b));
        System.out.println("A xor B = " + (a ^ b));
        System.out.println("not A = " + (!a));
        System.out.println("not B = " + (!b));
    }
}
