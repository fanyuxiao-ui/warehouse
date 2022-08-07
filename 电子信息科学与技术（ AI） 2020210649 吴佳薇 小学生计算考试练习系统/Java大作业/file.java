// package Java大作业;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class file {

  BufferedWriter w1, w2, w3;
  File file1, file2, file3, file4;

  public file() {
    String s1 = "src/wrong topic file.txt";
    String s2 = "src/report cards.txt";
    String s3 = "src/coverage.txt";
    String s4 = "src/tmpcoverage.txt";
    file1 = new File(s1);
    file2 = new File(s2);
    file3 = new File(s3);
    file4 = new File(s4);
    if (!file1.exists()) {
      try {
        file1.createNewFile();
      } catch (IOException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
      }
    }
    if (!file2.exists()) {
      try {
        file2.createNewFile();
      } catch (IOException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
      }
    }
    if (!file3.exists()) {
      try {
        file3.createNewFile();
      } catch (IOException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
      }
    }
    if (!file4.exists()) {
      try {
        file4.createNewFile();
      } catch (IOException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
      }
    }
    try {
      w1 = new BufferedWriter(new FileWriter(file1, true));
      w2 = new BufferedWriter(new FileWriter(file2, true));
      w3 = new BufferedWriter(new FileWriter(file3, true));
    } catch (IOException e) {
      // TODO 自动生成的 catch 块
      e.printStackTrace();
    }
  }

  public void coverage(String s[], int score) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file3));
    PrintWriter out = new PrintWriter(new FileWriter(file4, true));
    String line;
    int first = 1;
    while ((line = br.readLine()) != null) {
      String cut = "\\s+";
      String[] l = line.split(cut);
      if (s[0].equals(l[0]) && s[1].equals(l[1]) && s[2].equals(l[2])) {
        first = 0;
        StringBuilder newline = new StringBuilder();
        for (int j = 0; j < l.length - 1; j++) {
          newline.append(l[j]);
          newline.append("  ");
        }
        newline.append("第" + (l.length - 3) + "次考试成绩为：" + score);
        String sub = l[l.length - 1].substring(6);
        double coverage = Double.parseDouble(sub);
        coverage = (coverage * (l.length - 4) + score) / (l.length - 3);
        newline.append("  平均成绩为：" + coverage);
        out.println(newline.toString());
      } else {
        out.println(line);
      }
    }
    if (first == 0) {
      w1.close();
      w2.close();
      w3.close();
      br.close();
      out.close();
      file3.delete();
      file4.renameTo(new File("src/coverage.txt"));
    }
    if (first == 1) {
      String newline;
      newline =
        new String(
          s[0] +
          "  " +
          s[1] +
          "  " +
          s[2] +
          "  第1次考试成绩为：" +
          score +
          "  平均成绩为：" +
          score
        );
      w3 = new BufferedWriter(new FileWriter(file3, true));
      w3.write(newline);
      br.close();
      out.close();
      w1.close();
      w2.close();
      w3.close();
      file4.delete();
    }
  }
}
