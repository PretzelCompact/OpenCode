import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String...args) throws IOException {
        var myArr = new MyIntArray();
        var br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("-------------------------\n" +
                "Команды\n" +
                "-------------------------\n" +
                "add [int1] [int2] [int3]... -- вставить набор чисел в конец\n"+
                "insert [index] [int1] [int2] [int3]... -- вставить набор чисел в позицию index\n"+
                "remove [index] -- удалить элемент по выбранному индексу\n"+
                "clear -- очистить массив\n" +
                "length -- длина массива\n" +
                "sort -- отсортировать список\n"+
                "exit -- выход\n"+
                "-------------------------");

        while (true){
            var input = br.readLine();
            var arr = input.split(" ");
            int[] nums;

            switch (arr[0]){
                case "add":
                    nums = getNumbers(arr);
                    for(int n : nums)
                        myArr.addLast(n);
                    break;
                case "insert":
                    nums = getNumbers(arr);
                    int start = nums[0];
                    for(int i = 1; i < nums.length; i++)
                        myArr.insert(nums[i],start+i-1);
                    break;
                case "clear":
                    myArr.clear();
                    break;
                case "sort":
                    myArr.sort();
                    break;
                case "remove":
                    nums = getNumbers(arr);
                    myArr.remove(nums[0]);
                    break;
                case "length":
                    System.out.println("Длина массива:" + myArr.length());
                    break;
                default:
                    return;
            }
            System.out.println(myArr.toString());
        }
    }
    private static int[] getNumbers(String[] arr){
        var result = new int[arr.length-1];
        for(int i = 1; i < arr.length; i++){
            int value = Integer.parseInt(arr[i]);
            result[i-1]=value;
        }
        return result;
    }
}
