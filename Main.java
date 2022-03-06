package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Base Converter");
        primaryStage.setScene(new Scene(root, 400, 450));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
//        System.out.println("Choose one of these shortcuts when entering bases: (bin, oct, dec, hex)");
//        Scanner input = new Scanner(System.in);
//        System.out.print("Number: ");
//        String num = input.nextLine();
//        System.out.print("From base: ");
//        String fromBase = input.nextLine();
//        System.out.print("To base: ");
//        String toBase = input.nextLine();
//        System.out.println("Result number: ");
//        if (num.length() == 0 || num.length() == 1 && num.equalsIgnoreCase("0"))
//            System.out.println("0");
//        else if (num.contains("-"))
//            System.out.println("Negative numbers are NOT allowed here!");
//        else if (fromBase.equalsIgnoreCase("bin") && toBase.equalsIgnoreCase("oct"))
//            System.out.println(binToOct(num+""));
//        else if (fromBase.equalsIgnoreCase("bin") && toBase.equalsIgnoreCase("dec"))
//            System.out.println(binToDec(num+""));
//        else if (fromBase.equalsIgnoreCase("bin") && toBase.equalsIgnoreCase("hex"))
//            System.out.println(binToHex(num+""));
//        else if (fromBase.equalsIgnoreCase("oct") && toBase.equalsIgnoreCase("bin"))
//            System.out.println(octToBin(num+""));
//        else if (fromBase.equalsIgnoreCase("oct") && toBase.equalsIgnoreCase("dec"))
//            System.out.println(octToDec(num+""));
//        else if (fromBase.equalsIgnoreCase("oct") && toBase.equalsIgnoreCase("hex"))
//            System.out.println(octToHex(num+""));
//        else if (fromBase.equalsIgnoreCase("dec") && toBase.equalsIgnoreCase("bin"))
//            System.out.println(decToBin(num+""));
//        else if (fromBase.equalsIgnoreCase("dec") && toBase.equalsIgnoreCase("oct"))
//            System.out.println(decToOct(num+""));
//        else if (fromBase.equalsIgnoreCase("dec") && toBase.equalsIgnoreCase("hex"))
//            System.out.println(decToHex(num+""));
//        else if (fromBase.equalsIgnoreCase("hex") && toBase.equalsIgnoreCase("bin"))
//            System.out.println(hexToBin(num+""));
//        else if (fromBase.equalsIgnoreCase("hex") && toBase.equalsIgnoreCase("oct"))
//            System.out.println(hexToOct(num+""));
//        else if (fromBase.equalsIgnoreCase("hex") && toBase.equalsIgnoreCase("dec"))
//            System.out.println(hexToDec(num+""));
//        else
//            System.out.println("There is something WRONG in your entries!");
    }

    public static String binToOct(String num) {
        return decToOct(binToDec(num));
    }
    public static String binToDec(String num) {
        int val = Integer.parseInt(num);
        int counter = 0, result = 0;
        while (val != 0) {
            int temp = val % 10;
            result += temp * Math.pow(2, counter);
            val /= 10;
            counter++;
        }
        return result + "";
    }
    public static String binToHex(String num) {
        return decToHex(binToDec(num));
    }
    public static String octToBin(String num) {
        return decToBin(octToDec(num));
    }
    public static String octToDec(String num) {
        int val = Integer.parseInt(num);
        int counter = 0, result = 0;
        while (val != 0) {
            int temp = val % 10;
            result += temp * Math.pow(8, counter);
            val /= 10;
            counter++;
        }
        return result + "";
    }
    public static String octToHex(String num) {
        return decToHex(octToDec(num));
    }
    public static String decToBin(String num) {
        int val = Integer.parseInt(num);
        String binaryNum = "";
        while (val > 0) {
            binaryNum = (val % 2) + binaryNum;
            val /= 2;
        }
        return binaryNum;
    }
    public static String decToOct(String num) {
        int val = Integer.parseInt(num);
        String octalNum = "";
        while (val > 0) {
            octalNum = (val % 8) + octalNum;
            val /= 8;
        }
        return octalNum;
    }
    public static String decToHex(String num) {
        int val = Integer.parseInt(num);
        int rem;
        String hexNum = "";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (val > 0) {
            rem = val % 16;
            hexNum = hex[rem] + hexNum;
            val /= 16;
        }
        return hexNum;
    }
    public static String hexToBin(String num) {
        String digits = "0123456789ABCDEF";
        String[] binary = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        num = num.toUpperCase();
        String result = "";
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            result = result + binary[digits.indexOf(c)];
        }
        return result;
    }
    public static String hexToOct(String num) {
        return binToOct(hexToBin(num));
    }
    public static String hexToDec(String num) {
        int value = 0;
        num = num.toUpperCase();
        String hex = "0123456789ABCDEF";
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int d = hex.indexOf(c);
            value = value * 16 + d;
        }
        return value + "";
    }
}
