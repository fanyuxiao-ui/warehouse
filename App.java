import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        // ��������洢�� Output_Strings��
        ArrayList<String> Output_Strings = new ArrayList<String>();
        
        Random_Number rand = new Random_Number();
        // ��������
        int[] standard = rand.num_list();
        // �����������
        System.out.print("���ο�������Ϊ��");
        for (int i = 0; i < 6; i++)
            System.out.print(standard[i] + " ");
        System.out.println();

        // ������ʾ
        System.out.println("ѡ��������루1�����ļ���ȡ��2���������� 1 �� 2 ��");
        // ����
        Scanner scanner = new Scanner(System.in);
        // ������ת��Ϊ����
        int temp = scanner.nextInt();
        // �жϣ�ѡ�����������ļ���ȡ
        if(temp==1){
            ArrayList<Bet_Number> bet_NumberList=new ArrayList<Bet_Number>();
        }else if(temp==2){

        }
            // ���� str���Կո�ֿ�
            String[] str_list = str.split(" ");
            // �ÿ� input
            input.clear();
            // ����Ͷע���룬д��int[]
            for (int i = 0; i < 6; i++)
                input.add(Integer.parseInt(str_list[i]));
            Equal equal = new Equal();
            // ��ȡ��������
            equal.shift(standard);
            // ��ȡ����Ϣ���� Output_Strings
            Output_Strings.add(equal.award(input));
            // ��ȡͶע������� Input_Numbers
            Input__Numbers.add(input);
            // ���ÿһ��Ͷע����Ļ����
            for (int i = 0; i < Input__Numbers.size(); i++) {
                System.out.print("����Ͷע����Ϊ��");
                for (int j = 0; j < 6; j++)
                    System.out.print(Input__Numbers.get(i).get(j) + " ");
                System.out.println(" " + Output_Strings.get(i));
            }
        }while(str!=null);
    // �ر� scanner
    scanner.close();
}}