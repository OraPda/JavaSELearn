package HeiMaJava.code;

import java.util.Arrays;

public class codeDemo1 {
    public static String schoolName;
    public static String[] cards = new String[54];
    static {
        System.out.println("静态代码块");
        schoolName = "黑马";
        cards[0] = "大王";
        cards[1] = "小王";
        int index = 2;
        // 正确分配每个花色的牌
        for (int i = 2; i <= 14; i++) {
            if (index < 54) cards[index++] = (i-1) + "♥";
            if (index < 54) cards[index++] = (i-1) + "♦";
            if (index < 54) cards[index++] = (i-1) + "♣";
            if (index < 54) cards[index++] = (i-1) + "♠";
        }
    }
    public static void main(String[] args) {
//        目标 认识代码块
        System.out.println("main方法");
        System.out.println(schoolName);
        System.out.println(Arrays.toString(cards));
    }
}
