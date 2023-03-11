//2.Дана строка (получение через обычный текстовый файл!!!)
//"фамилия":"Иванов","оценка":"5","предмет":"Математика"
//"фамилия":"Петрова","оценка":"4","предмет":"Информатика"
//Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
//Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task2 {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String line1 = line.replaceAll("\"", "");
                //System.out.println(line + "\n");
                StringBuilder sb = parse(line1);
                System.out.println(sb);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static StringBuilder parse(String str) {
        StringBuilder out = new StringBuilder();
        String[] partsOfStr = str.split("[,:]");
        out.append("Студент ");
        out.append(partsOfStr[1]);
        out.append(" получил ");
        out.append(partsOfStr[3]);
        out.append(" по предмету ");
        out.append(partsOfStr[5]);

        return out;

    }
}

