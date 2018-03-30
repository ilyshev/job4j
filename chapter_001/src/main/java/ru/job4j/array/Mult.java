package ru.job4j.array;

public class Mult {
    public static void main(String[] args) {
        // создаем двумерный массив 10 на 10
        int[][] multiplyTab  = new int[10][10];

        // цикл по первой размерности
        for (int i = 0; i < 10; i++) {
            // цикл по второй размерности
            for (int j = 0; j < 10; j++) {
                //инициализация элементов массива
                multiplyTab[i][j] = (i+1)*(j+1);

                //вывод элементов массива
                System.out.print(multiplyTab[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
