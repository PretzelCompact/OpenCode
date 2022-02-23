import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1_3_1 {
    public static void main(String[] args) throws IOException {
        int n;
        do{
            System.out.println("Введите размер квадратной матрицы(нечётное число):");
            var br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
        } while(n%2!=1);

        var firstMatrix = new SqureMatrix(n);
        var secondMatrix = new SqureMatrix(n);
        var thirdMatrix = new SqureMatrix(n);
        var fourthMatrix = new SqureMatrix(n);

        int j = 0;
        for(int i = 0; i<n;i++){
            firstMatrix.setOne(i,i);
            firstMatrix.setOne(i,n-i-1);

            int midle = n/2;
            secondMatrix.setOne(midle,i);
            secondMatrix.setOne(i,midle);

            thirdMatrix.setOne(0,i);
            thirdMatrix.setOne(i,0);
            thirdMatrix.setOne(n-1,i);
            thirdMatrix.setOne(i,n-1);

            if(i<=midle){
                fourthMatrix.setOne(i,midle+i);
                fourthMatrix.setOne(i,midle-i);
                fourthMatrix.setOne(n-i-1,midle+i);
                fourthMatrix.setOne(n-i-1,midle-i);
            }
        }
        System.out.println("---------------");
        System.out.println(firstMatrix);
        System.out.println("---------------");
        System.out.println(secondMatrix);
        System.out.println("---------------");
        System.out.println(thirdMatrix);
        System.out.println("---------------");
        System.out.println(fourthMatrix);
        System.out.println("---------------");
    }
}
class SqureMatrix{
    private int[][] values;
    private int size;

    public SqureMatrix(int n){
        values = new int[n][n];
        size = n;
    }
    public void setValue(int i, int j, int value){
        values[i][j]=value;
    }
    public void setOne(int i, int j){
        setValue(i,j,1);
    }

    @Override
    public String toString(){
        var sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sb.append(values[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
