import java.io.BufferedReader;
import java.io.IOException;

public class Task1_4 implements ITask {
    @Override
    public void execute(BufferedReader br) throws IOException {
        int[] array = new int[]{
          1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
          21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
          31, 32, 33, 34, 35, 36, 37, 38, 39, 40
        };
        int i = 0;
        while(i < 30){
            String str = array[i] + " ";
            if((i+1)%10==0)
                str += '\n';
            System.out.print(str);
            i++;
        }
    }
}
