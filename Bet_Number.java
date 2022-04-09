import java.util.*;
import java.io.*;

public class Bet_Number {
    // 投注号码
    public ArrayList<Integer> number = new ArrayList<Integer>();

    // 键盘输入并存入 number
    public boolean keyboard_input() {
        try (
                // 输入
                Scanner scanner = new Scanner(System.in)) {
            // 读取每一行信息
            String str = scanner.nextLine();
            if (str != null) {
                // 处理 str，以空格分开
                String[] str_list = str.split(" ");
                // 读入投注号码，写入 number
                for (int i = 0; i < 6; i++)
                    number.add(Integer.parseInt(str_list[i]));
                return true;
            } else
                return false;
        }
    }

    // 文件读取并存入 number
    public void file_input() {
        try (
                // 读取文件
                FileReader reader = new FileReader("src/Input.txt");
                BufferedReader br = new BufferedReader(reader);) {
            // 读取每一行信息
            String str = br.readLine();
            // 遍历每一行投注号码
            while (str != null) {
                // 创建 number对象
                ArrayList<Integer> number = new ArrayList<Integer>();
                // 处理 str，以空格分开
                String[] str_list = str.split(" ");
                // 置空 number
                number.clear();
                // 读入投注号码，写入 number
                for (int i = 0; i < 6; i++)
                    number.add(Integer.parseInt(str_list[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
