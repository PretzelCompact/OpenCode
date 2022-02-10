import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("Введите номер задания или 'exit':");
            ITask task;

            var input = br.readLine();
            switch (input){
                case "1":
                    task = new Task1_1();
                    break;
                case "2":
                    task = new Task1_2();
                    break;
                case "3":
                    task = new Task1_3();
                    break;
                case "4":
                    task = new Task1_4();
                    break;
                case "5":
                    task = new Task1_5();
                    break;
                case "6":
                    task = new Task1_6();
                    break;
                case "7":
                    task = new Task1_7();
                    break;
                case "8":
                    task = new Task1_8();
                    break;
                case "9":
                    task = new Task1_9();
                    break;
                case "exit":
                    return;
                default:
                    continue;
            }

            System.out.println("------------------------------");
            task.execute(br);
            System.out.println("------------------------------");
        }
    }
}