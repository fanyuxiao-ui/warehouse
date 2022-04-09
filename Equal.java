import java.util.ArrayList;

public class Equal {
    // 开奖号码
    private int[] listR = new int[6];
    // private int[] listS = new int [6];

    // 获取开奖号码
    public void shift(int[] a) {
        listR = a;
    }

    // 返回获奖信息，将 listR与 b（投注号码）相比较
    public String award(ArrayList<Integer> input) {
        int k1 = 0, k2 = 0;
        String str = new String();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (listR[i] == input.get(j))
                    k1++;
            }
        }
        if (listR[5] == input.get(5))
            k2++;
        if (k1 == 5 && k2 == 1)
            str = "恭喜您成为富豪！";
        else if (k1 == 5)
            str = "恭喜您获得一等奖！";
        else if (k1 == 4 && k2 == 1)
            str = "恭喜您获得二等奖！";
        else if (k1 == 4)
            str = "恭喜您获得三等奖！";
        else if (k1 == 3 && k2 == 1)
            str = "恭喜您获得四等奖！";
        else if (k1 == 3)
            str = "恭喜您获得五等奖！";
        else if (k2 == 1)
            str = "恭喜您获得安慰奖！";
        else
            str = "恭喜您本次未能成功获奖！";
        return str;
    }
}
