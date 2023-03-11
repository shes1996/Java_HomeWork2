//1.Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
//результат после каждой итерации запишите в лог-файл.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task1 {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(task1.class.getName());
        FileHandler fh = new FileHandler("logtask1.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Date d = new Date();
        int[] nums = {3, 5, 3, 5, 7, 6, 3, 1, 5, 3, 4};

        int temp = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
                String out =Arrays.toString(nums);
                logger.info(out);
                System.out.println(out);

//                * ЛОГИРОВАНИЕ БЕЗ ИСПОЛЬЗОВАНИЯ LOGGER*
//                try {
//                    FileWriter writer = new FileWriter("logtask1.txt", true);
//                    BufferedWriter bufferWriter = new BufferedWriter(writer);
//                    bufferWriter.write(out + "\n");
//
//                    bufferWriter.close();
//
//                } catch (IOException ex) {
//                    System.out.println(ex.getMessage());
//                }
//                System.out.println(d + " " + Arrays.toString(nums));
//
            }
        }
    }
}
