import java.util.ArrayList;

public class Equal {
    // ��������
    private int[] listR = new int[6];
    // private int[] listS = new int [6];

    // ��ȡ��������
    public void shift(int[] a) {
        listR = a;
    }

    // ���ػ���Ϣ���� listR�� b��Ͷע���룩��Ƚ�
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
            str = "��ϲ����Ϊ������";
        else if (k1 == 5)
            str = "��ϲ�����һ�Ƚ���";
        else if (k1 == 4 && k2 == 1)
            str = "��ϲ����ö��Ƚ���";
        else if (k1 == 4)
            str = "��ϲ��������Ƚ���";
        else if (k1 == 3 && k2 == 1)
            str = "��ϲ������ĵȽ���";
        else if (k1 == 3)
            str = "��ϲ�������Ƚ���";
        else if (k2 == 1)
            str = "��ϲ����ð�ο����";
        else
            str = "��ϲ������δ�ܳɹ��񽱣�";
        return str;
    }
}
