/*
import java.io.*;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;

public class Main {
    Scanner scanner;
    String userInput;
    double userInputToDouble;
    double x;

    public static void main(String[] args) {


    }


    public void userFunction() {


        scanner = new Scanner(System.in);

        System.out.println("Input your function");
        userInput = scanner.next();
        char[] userInputCharArr = userInput.toCharArray();
        String temp = "";
        int i = 0;

        for (; i < userInputCharArr.length; i++) {

            while (userInputCharArr[i] >= 0x48 && userInputCharArr[i] <= 0x57 || userInputCharArr[i] == '.') {
                temp += userInputCharArr[i];
                i++;
            }
            userInputToDouble += Double.parseDouble(temp);
            temp = "";

            if (userInputCharArr[i] == 'x') {userInputToDouble = }
            if (userInputCharArr[i] == '-') {}
            if (userInputCharArr[i] == '+') {}
            if (userInputCharArr[i] == '*') {}
            if (userInputCharArr[i] == '/') {}
            if (userInputCharArr[i] == '^') {userInputToDouble += x}




        }


    }

    public void getFunction() {

        scanner = new Scanner(System.in);

        System.out.println("Input your function");
        userInput = scanner.next();

        char[] userInputChars = userInput.toCharArray();

        for (int i = 0; i < userInputChars.length; i++) {

            if(userInputChars[i] >= 0x48 && userInputChars[i] <= 0x57) {
                userInputToDouble += userInputChars[i];
            }


            if(!(userInputChars[i] >= 0x42 && userInputChars[i] <= 0x57)) {

                try {
                    userInputToDouble = Double.parseDouble(userInput);
                } catch (NumberFormatException ne) {
                    ne.printStackTrace();
                }

            }


        }






    }
}


*/
