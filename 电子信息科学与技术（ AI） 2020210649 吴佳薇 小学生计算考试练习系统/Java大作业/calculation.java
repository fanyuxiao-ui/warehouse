// package Java大作业;

import java.awt.BorderLayout;
import java.awt.CardLayout;
// import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculation extends JFrame implements ActionListener {

  JFrame app = new JFrame("考试中");
  Container c = app.getContentPane();
  JLabel[] l = new JLabel[50];
  JTextField[] a = new JTextField[50];
  JPanel p1 = new JPanel();
  JPanel p2 = new JPanel();
  JPanel p3 = new JPanel();
  JLabel time = new JLabel("时间:");
  JLabel page;
  JButton up = new JButton("提交");
  JButton first = new JButton("第一页");
  JButton previous = new JButton("上一页");
  JButton next = new JButton("下一页");
  JButton last = new JButton("最后一页");
  CardLayout card = new CardLayout();
  int count; // 页数
  int sum[] = new int[50];
  Thread t;
  int n;
  int second = 60 * n;
  int min, sec;
  int rest[] = new int[2]; // 差
  String infro[] = new String[3];
  int mod;
  int click = 1;

  public calculation() {}

  public void calculation1() {
    // 三个组件位置及大小
    p2.setLayout(null);
    p2.setPreferredSize(new Dimension(800, 200));
    p1.setLayout(card);
    p1.setPreferredSize(new Dimension(800, 600));
    p3.setLayout(new GridLayout(1, 4));
    p3.setPreferredSize(new Dimension(800, 100));
    app.add(BorderLayout.NORTH, p2);
    app.add(BorderLayout.CENTER, p1);
    app.add(BorderLayout.SOUTH, p3);
    app.setSize(800, 800);

    for (int i = 0; i < 5; i++) {
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(2, 10));
      p.setPreferredSize(new Dimension(800, 600));

      for (int j = 0; j < 10; j++) {
        l[j + i * 10] = new JLabel(this.num(j + i * 10));
        l[j + i * 10].setFont(new Font("仿宋", Font.BOLD, 25));
        a[j + i * 10] = new JTextField("0");
        a[j + i * 10].setFont(new Font("仿宋", Font.BOLD, 50));
        p.add(l[j + i * 10]);
        p.add(a[j + i * 10]);
      }

      p1.add(BorderLayout.CENTER, p);
    }

    t =
      new Thread(
        new Runnable() {
          @Override
          public void run() {
            // TODO 自动生成的方法存根
            while (click == 1) {
              try {
                second--;
                Thread.sleep(1000);
                min = second / 60 % 60;
                sec = second % 60;
                time.setText("倒计时：" + min + "分" + sec + "秒");

                if (60 * n % 60 - sec > 0) {
                  rest[1] = 60 * n % 60 - sec;
                  rest[0] = 60 * n / 60 % 60 - min;
                } else {
                  rest[1] = 60 * n % 60 - sec + 60;
                  rest[0] = 60 * n / 60 % 60 - min - 1;
                }
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              if (second == 0) {
                up.doClick();
              }
            }
          }
        }
      );
    t.start();
    time.setFont(new Font("仿宋", Font.BOLD, 50));

    count = 1;
    page = new JLabel("第" + count + "页");
    time.setBounds(100, 30, 800, 100);
    page.setBounds(1000, 30, 150, 100);
    page.setFont(new Font("仿宋", Font.BOLD, 50));
    up.setBounds(1200, 30, 200, 100);
    up.setFont(new Font("仿宋", Font.BOLD, 50));
    p2.add(time);
    p2.add(page);
    p2.add(up);

    p3.add(first);
    p3.add(previous);
    p3.add(next);
    p3.add(last);
    first.setFont(new Font("仿宋", Font.BOLD, 50));
    previous.setFont(new Font("仿宋", Font.BOLD, 50));
    next.setFont(new Font("仿宋", Font.BOLD, 50));
    last.setFont(new Font("仿宋", Font.BOLD, 50));
    first.addActionListener(this);
    previous.addActionListener(this);
    next.addActionListener(this);
    last.addActionListener(this);
    up.addActionListener(this);

    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setVisible(true);
  }

  public String num(int i) {
    Random r = new Random();
    int a = r.nextInt(100) + 1;
    int b = r.nextInt(100) + 1;
    int c = r.nextInt(100) + 1;
    int x = r.nextInt(6);
    int y = r.nextInt(6);
    int z = 0;
    char x1 = 0, y1 = 0;
    String s = new String();
    // 加减
    if (mod == 1) {
      if (x < 3) {
        z = a - b;
        x1 = '-';
      } else {
        z = a + b;
        x1 = '+';
      }
      if (y < 3) {
        z = z - c;
        y1 = '-';
      } else {
        z = z + c;
        y1 = '+';
      }
      if (z < 0) {
        z = a + b;
        if ((z - c) < 0) {
          x1 = '+';
          y1 = '+';
          z = z + c;
        } else {
          x1 = '+';
          y1 = '-';
          z = z - c;
        }
      }
    }
    // 混合
    if (mod == 2) {
      if (x == 0) {
        if ((a - b) > 0) {
          z = a - b;
          x1 = '-';
        } else {
          z = a + b;
          x1 = '+';
        }
        if (y < 2) {
          if (y == 0) {
            if ((z - c) > 0) {
              z = z - c;
              y1 = '-';
            } else {
              z = z + c;
              y1 = '+';
            }
          } else {
            z = z + c;
            y1 = '+';
          }
        } else {
          c = c / 2;
          z = z * c;
          y1 = '*';
        }
      } else if (x == 1) {
        z = a + b;
        x1 = '+';
        if (y < 2) {
          if (y == 0) {
            if ((z - c) > 0) {
              z = z - c;
              y1 = '-';
            } else {
              z = z + c;
              y1 = '+';
            }
          } else {
            z = z + c;
            y1 = '+';
          }
        } else {
          c = c / 5;
          z = z * c;
          y1 = '*';
        }
      } else {
        a = a / 5;
        b = b / 5;
        z = a * b;
        x1 = '*';
        if (y < 2) {
          if (y == 0) {
            if ((z - c) > 0) {
              z = z - c;
              y1 = '-';
            } else {
              z = z + c;
              y1 = '+';
            }
          } else {
            z = z + c;
            y1 = '+';
          }
        } else {
          c = c / 5;
          z = z * c;
          y1 = '*';
        }
      }
    }

    sum[i++] = z;
    if (y1 == '*' && !(x1 == '*')) s =
      "(" +
      String.valueOf(a) +
      String.valueOf(x1) +
      String.valueOf(b) +
      ")" +
      String.valueOf(y1) +
      String.valueOf(c) +
      "="; else s =
      String.valueOf(a) +
      String.valueOf(x1) +
      String.valueOf(b) +
      String.valueOf(y1) +
      String.valueOf(c) +
      "=";
    return s;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO 自动生成的方法存根
    if (e.getSource() == first) {
      card.first(p1);
      count = 1;
      page.setText("第" + count + "页");
    }
    if (e.getSource() == previous) {
      card.previous(p1);
      if (count == 1) count = count + 4; else count--;
      page.setText("第" + count + "页");
    }
    if (e.getSource() == next) {
      card.next(p1);
      if (count == 5) count = count - 4; else count++;
      page.setText("第" + count + "页");
    }
    if (e.getSource() == last) {
      card.last(p1);
      count = 5;
      page.setText("第" + count + "页");
    }
    if (e.getSource() == up) {
      click = 0;
      int score = 0;
      int wrong = 0;
      file f = new file();
      // f.file1();
      // f.file2();
      try {
        f.w2.write(infro[0] + "  ");
        f.w2.write(infro[1] + "  ");
        f.w2.write(infro[2] + "  考试用时：" + rest[0] + "分" + rest[1] + "秒");
        f.w2.newLine();
        f.w1.write(infro[0] + "  ");
        f.w1.write(infro[1] + "  ");
        f.w1.write(infro[2] + "  考试用时：" + rest[0] + "分" + rest[1] + "秒");
        f.w1.newLine();
      } catch (IOException e2) {
        // TODO 自动生成的 catch 块
        e2.printStackTrace();
      }
      for (int i = 0; i < 50; i++) {
        String answer = a[i].getText();
        int ans = Integer.parseInt(answer);

        if (sum[i] == ans) {
          score = score + 2;
          try {
            f.w2.write(l[i].getText() + sum[i] + "  本题正确");
            f.w2.newLine();
          } catch (IOException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
          }
        } else {
          wrong++;
          try {
            f.w2.write(
              l[i].getText() +
              "正确答案为：" +
              sum[i] +
              "  考生答案为：" +
              ans +
              "  本题错误"
            );
            f.w2.newLine();
            f.w1.write(
              l[i].getText() + "正确答案为：" + sum[i] + "  错误答案为：" + ans
            );
            f.w1.newLine();
            // f.w1.close();
          } catch (IOException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
          }
        }

        System.out.print(sum[i] + "  ");
      }

      JOptionPane.showMessageDialog(
        null,
        "考试结束！\n本次成绩为：" +
        score +
        "\n错题数：" +
        wrong +
        "\n考试用时：" +
        rest[0] +
        "分:" +
        rest[1] +
        "秒"
      );
      try {
        f.w2.write("本次成绩为：" + score + "分");
        f.w2.newLine();
        f.w2.newLine();
        f.w1.newLine();
        f.w1.close();
        f.w2.close();
      } catch (IOException e1) {
        // TODO 自动生成的 catch 块
        e1.printStackTrace();
      }
      try {
        f.coverage(infro, score);
      } catch (IOException e1) {
        // TODO 自动生成的 catch 块
        e1.printStackTrace();
      }
    } // up结束
  }
}
