package online.labuladong.algo.exam.hand;

import java.util.Scanner;

/**
 * @author: DongShaowei
 * @create: 2024-10-09 21:07
 * @description:
 */
public class T2SensitiveWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String param = in.nextLine();
        String[] params = param.split(" ");
        int len = Integer.parseInt(params[0]); // 字符串长度
        int n = Integer.parseInt(params[1]); // 敏感词个数
        int count = 0;
        String[] words = new String[n]; // 敏感词
        String text = in.nextLine(); // 受检字符串
        while (count < n) {
            words[count++] = in.nextLine();
        }

        int res = 0;
        for (String word : words) {
            int nextIndex = -1;
            while ((nextIndex = text.indexOf(word, nextIndex + 1)) != -1) {
                res++;
            }
        }
        System.out.println(res);
    }
}
