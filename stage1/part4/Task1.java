package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int[][] arr;

        while (true){
            System.out.println("Введите чётное или нечётное число; или exit для выхода");
            String str = br.readLine();
            if(str.equals("exit"))
                return;
            try {
                n = Integer.parseInt(str);
            } catch (Exception e){
                System.out.println("Ошибка ввода");
                continue;
            }
            if(n<=0){
                System.out.println("Число не может быть меньше единицы");
                continue;
            }

            arr = new int[n][n];
            buildPartOfFractal(arr,0,0,n,1);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++)
                    System.out.print((arr[j][i] == 0 ? "" : arr[j][i]) + "\t");
                System.out.print('\n');
            }
        }
    }

    private static void buildPartOfFractal(int[][] arr, int startX, int startY, int size, int startNumber){
        //Случаи нечётного размера
        if(size == 1){
            arr[startX][startY] = startNumber;
            return;
        }

        //Случаи чётного размера
        if(size == 2){
            arr[startX][startY] = startNumber;
            arr[startX+1][startY] = ++startNumber;
            arr[startX+1][startY+1] = ++startNumber;
            return;
        }

        //Строим спираль
        buildSpiral(arr,startX,startY,size,startNumber);
        int curNumber = startNumber+size*4-6;

        if(size == 4 || size == 3)
            return;

        //Строим "мост" между спиралями
        arr[startX+1][startY+2]=++curNumber;

        //Строим часть фигуры меньшего размера
        buildPartOfFractal(arr, startX+2, startY+2,size-4,++curNumber);
    }

    private static void buildSpiral(int[][] arr, int startX, int startY, int size, int startNumber){
        int curNum = startNumber;

        int maxX = startX+size-1;
        int maxY = startY+size-1;

        //Верхняя часть спирали
        buildLine(arr,startX,startY,1,0,size,curNum);
        curNum+=size-1;

        //Правая часть спирали
        buildLine(arr,maxX,startY,0,1,size,curNum);
        curNum+=size-1;

        //Нижняя часть спирали
        buildLine(arr,maxX,maxY,-1,0,size,curNum);
        curNum+=size-1;

        //Левая часть спирали
        buildLine(arr,startX,maxY,0,-1,size-2,curNum);
    }
    private static void buildLine(int[][] arr, int x, int y, int dx, int dy, int length, int startNum){
        while (length>0){
            arr[x][y] = startNum++;
            x+=dx;
            y+=dy;
            length--;
        }
    }
}
