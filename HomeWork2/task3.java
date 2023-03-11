//3. К калькулятору из предыдущего дз добавить логирование.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.*;

public class task3 {
    public static void main(String[] args) throws IOException {
        Scanner num1 = new Scanner(System.in);
        Scanner act = new Scanner(System.in);
        Scanner num2 = new Scanner(System.in);
        Date d = new Date();
        StringBuilder calc = new StringBuilder();

        Logger logger = Logger.getLogger(task1.class.getName());
        FileHandler fh = new FileHandler("logtask3.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        System.out.printf("enter the number (ex: 5 or 5,2):  ");
        while (num1.hasNextDouble() != true) {
            System.out.println("Incorrect number");
            num1 = new Scanner(System.in);
        }
        double x = num1.nextDouble();

        System.out.printf("enter the action +, -, * or /: ");
        String action = act.nextLine();

        System.out.printf("enter the number (ex: 5 or 5,2): ");
        while (num2.hasNextDouble() != true) {
            System.out.println("Incorrect number");
            num2 = new Scanner(System.in);
        }
        double y = num2.nextDouble();

        if (action.contains("+")) {
            calc.append(x);
            calc.append(" + ");
            calc.append(y);
            calc.append(" = ");
            calc.append(x + y);
        } else if (action.contains("-")) {
            calc.append(x);
            calc.append(" - ");
            calc.append(y);
            calc.append(" = ");
            calc.append(x - y);
        } else if (action.contains("*")) {
            calc.append(x);
            calc.append(" * ");
            calc.append(y);
            calc.append(" = ");
            calc.append(x * y);
        } else if (action.contains("/")) {
            calc.append(x);
            calc.append(" / ");
            calc.append(y);
            calc.append(" = ");
            calc.append(x / y);
        } else System.out.println("Incorrect symbol");

        logger.info(calc.toString());

//        * ЛОГИРОВАНИЕ БЕЗ ИСПОЛЬЗОВАНИЯ LOGGER*
//        try  {
//            FileWriter writer = new FileWriter("logtask3.txt", true);
//            BufferedWriter bufferWriter = new BufferedWriter(writer);
//            bufferWriter.write(d + " " + calc.toString() + "\n");
//            bufferWriter.close();
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
}

