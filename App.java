import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        // 将获奖情况存储在 Output_Strings里
        ArrayList<String> Output_Strings = new ArrayList<String>();
        
        Random_Number rand = new Random_Number();
        // 开奖号码
        int[] standard = rand.num_list();
        // 输出开奖号码
        System.out.print("本次开奖号码为：");
        for (int i = 0; i < 6; i++)
            System.out.print(standard[i] + " ");
        System.out.println();

        // 输入提示
        System.out.println("选择键盘输入（1）或文件读取（2），请输入 1 或 2 ：");
        // 输入
        Scanner scanner = new Scanner(System.in);
        // 将输入转化为数字
        int temp = scanner.nextInt();
        // 判断，选择键盘输入或文件读取
        if(temp==1){
            ArrayList<Bet_Number> bet_NumberList=new ArrayList<Bet_Number>();
        }else if(temp==2){

        }
            // 处理 str，以空格分开
            String[] str_list = str.split(" ");
            // 置空 input
            input.clear();
            // 读入投注号码，写入int[]
            for (int i = 0; i < 6; i++)
                input.add(Integer.parseInt(str_list[i]));
            Equal equal = new Equal();
            // 获取开奖号码
            equal.shift(standard);
            // 获取获奖信息插入 Output_Strings
            Output_Strings.add(equal.award(input));
            // 获取投注号码插入 Input_Numbers
            Input__Numbers.add(input);
            // 输出每一个投注号码的获奖情况
            for (int i = 0; i < Input__Numbers.size(); i++) {
                System.out.print("您的投注号码为：");
                for (int j = 0; j < 6; j++)
                    System.out.print(Input__Numbers.get(i).get(j) + " ");
                System.out.println(" " + Output_Strings.get(i));
            }
        }while(str!=null);
    // 关闭 scanner
    scanner.close();
}}