import java.util.*;
import java.io.*;

public class Bet_Number {
    // Ͷע����
    public ArrayList<Integer> number = new ArrayList<Integer>();

    // �������벢���� number
    public boolean keyboard_input() {
        try (
                // ����
                Scanner scanner = new Scanner(System.in)) {
            // ��ȡÿһ����Ϣ
            String str = scanner.nextLine();
            if (str != null) {
                // ���� str���Կո�ֿ�
                String[] str_list = str.split(" ");
                // ����Ͷע���룬д�� number
                for (int i = 0; i < 6; i++)
                    number.add(Integer.parseInt(str_list[i]));
                return true;
            } else
                return false;
        }
    }

    // �ļ���ȡ������ number
    public void file_input() {
        try (
                // ��ȡ�ļ�
                FileReader reader = new FileReader("src/Input.txt");
                BufferedReader br = new BufferedReader(reader);) {
            // ��ȡÿһ����Ϣ
            String str = br.readLine();
            // ����ÿһ��Ͷע����
            while (str != null) {
                // ���� number����
                ArrayList<Integer> number = new ArrayList<Integer>();
                // ���� str���Կո�ֿ�
                String[] str_list = str.split(" ");
                // �ÿ� number
                number.clear();
                // ����Ͷע���룬д�� number
                for (int i = 0; i < 6; i++)
                    number.add(Integer.parseInt(str_list[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
