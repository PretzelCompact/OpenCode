import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1_2 implements ITask{
    @Override
    public void execute(BufferedReader br) throws IOException {
        System.out.println("Введите int a:");
        int aI = Integer.parseInt(br.readLine());
        System.out.println("Введите int b:");
        int bI = Integer.parseInt(br.readLine());

        System.out.println();
        System.out.println("a + b = " + (aI+bI));
        System.out.println("a - b = " + (aI-bI));
        System.out.println("a / b = " + (aI/bI));
        System.out.println("a * b = " + (aI*bI));
        System.out.println();

        System.out.println("Введите float a:");
        float aF = Float.parseFloat(br.readLine());
        System.out.println("Введите float b:");
        float bF = Float.parseFloat(br.readLine());

        System.out.println();
        System.out.println("a + b = " + (aF+bF));
        System.out.println("a - b = " + (aF-bF));
        System.out.println("a / b = " + (aF/bF));
        System.out.println("a * b = " + (aF*bF));
    }
}
