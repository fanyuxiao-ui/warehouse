// package Java����ҵ;

import java.awt.BorderLayout;
// import java.awt.CardLayout;
// import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;
// import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
// import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class examination extends JFrame implements ActionListener {

  JPanel A = new JPanel();
  JLabel a = new JLabel("����");
  JLabel b = new JLabel("ѧ��");
  JLabel c = new JLabel("�༶");
  JTextField name = new JTextField();
  JTextField number = new JTextField();
  JTextField clas = new JTextField();
  JTextField time = new JTextField("�����ÿ���ʱ��(������)");
  String option[] = { "��ѡ���������", "�Ӽ�������", "��ϳ˷�����" };
  JComboBox model = new JComboBox(option);
  int mod = 0;
  // JPasswordField p=new JPasswordField();
  JButton start = new JButton("��ʼ����");
  JLabel[] l = new JLabel[10];

  public examination() {
    setTitle("Сѧ�����㿼����ϰϵͳ");
    setSize(800, 600);
    setLocation(0, 0);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    A.add(a);
    A.add(b);
    A.add(c);
    A.add(name);
    A.add(number);
    A.add(clas);
    // A.add(p);
    A.add(start);
    A.add(time);
    A.add(model);
    add(A);

    A.setPreferredSize(new Dimension(800, 600));
    a.setBounds(100, 50, 150, 80);
    b.setBounds(100, 200, 150, 80);
    c.setBounds(100, 350, 150, 80);
    name.setBounds(300, 50, 200, 80);
    number.setBounds(300, 200, 200, 80);
    clas.setBounds(300, 350, 200, 80);
    start.setBounds(350, 500, 100, 50);
    time.setBounds(600, 50, 150, 80);
    model.setBounds(600, 200, 150, 80);
    model.addActionListener(this);
    start.addActionListener(this);
    A.setLayout(new BorderLayout());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (model.getSelectedItem() == "�Ӽ�������") {
      mod = 1;
    }
    if (model.getSelectedItem() == "��ϳ˷�����") {
      mod = 2;
    }

    // TODO �Զ����ɵķ������
    if (e.getSource() == start) {
      int right = 1;
      // Ϊѡ��combobox
      if (model.getSelectedItem() == "��ѡ���������") {
        right = 0;
        JOptionPane.showMessageDialog(null, "��ѡ���������");
      }
      // δ���뿼��ʱ��
      for (int i = 0; i < time.getText().length(); i++) {
        if (time.getText().charAt(i) < '0' || time.getText().charAt(i) > '9') {
          JOptionPane.showMessageDialog(null, "����ȷ���뿼��ʱ��");
          right = 0;
          break;
        }
      }
      if (right == 1) {
        calculation c = new calculation();
        c.n = Integer.parseInt(time.getText());
        c.second = 60 * c.n;
        c.mod = mod;
        c.infro[0] = name.getText();
        c.infro[1] = number.getText();
        c.infro[2] = clas.getText();
        c.calculation1();
      }
    }
  }

  public static void main(String[] args) {
    // TODO �Զ����ɵķ������
    examination e = new examination();
  }
}
