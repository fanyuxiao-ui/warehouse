import java.util.*;

public class Random_Number {
    // 随机数组，长度6
    private int[] list = new int[6];

    // 获取六个随机数，以int[]形式返回，最后一位是特别号码
    public int[] num_list() {
        int cnt = 0, temp;
        Calendar cal = Calendar.getInstance();
        int second = cal.get(Calendar.SECOND);
        temp = second;
        while (cnt != 6) {
            do {
                temp = rand_1_50(temp);
            } while (!inequality(temp));
            list[cnt++] = temp;
        }
        return list;
    }

    // 查找生成的随机数是否与已有的重合
    public boolean inequality(int n) {
        for (int i = 0; i < list.length; i++)
            if (list[i] == n)
                return false;
        return true;
    }

    // 获取一个随机数
    public int rand_1_50(double r) {
        double base = 256.0, a = 17.0, b = 139.0;
        double temp1 = a * r + b;
        double temp2 = (int) (temp1 / base);
        // 得到余数
        double temp3 = temp1 - temp2 * base;
        r = temp3;
        double p = r / base;
        return (int) (1 + 49 * p);
    }
}
