package org.imz;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaUnit {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.findElement(By.id("selectOne")).click();


         }

    public static void getprint(int row, int column) {
        int num =1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                num++;
            }
            System.out.println();

        }
    }

    //#1
    public static int getSumOfArray(int[] value) {
        int sum = 0;
        int index = 0;
        while (value.length > 0) {
            sum += value[index];
            index++;
            if (index == value.length) break;
        }

        return sum;
    }

    //#2

    public static int getMinimumNumberArray(int[] val) {

        int min = val[0], index = 0;
        while (val.length > 0)
            if (min <= val[index]) {
                index++;
                if (index == val.length) break;
            } else min = val[index];
        return min;
    }


    // # 3


    public static void countNumbersInArray(int[] val) {
        if (val.length == 0) {
            System.out.println("Array is empty!");
            return;
        }

        boolean[] visited = new boolean[val.length]; // Track visited elements

        for (int i = 0; i < val.length; i++) {
            if (visited[i]) continue; // Skip already counted numbers

            int count = 1; // Count the current number
            for (int j = i + 1; j < val.length; j++) {
                if (val[i] == val[j]) {
                    count++;
                    visited[j] = true; // Mark duplicates as visited
                }
            }
            System.out.println("The number " + val[i] + " appears " + count + " times.");
        }
    }

    public static int getMaxNumInArray(int[] value) {


        int firstMax = value[0];
        int secondMax = value[0];

        for (int i = 0; i < value.length; i++) {
            if (value[i] > firstMax) {
                secondMax = firstMax;
                firstMax = value[i];
                if (value[i] > secondMax && value[i] != firstMax) {
                    secondMax = value[i];
                }

            }


        }

        return (secondMax == Integer.MIN_VALUE) ? -1 : secondMax;
    }
}
