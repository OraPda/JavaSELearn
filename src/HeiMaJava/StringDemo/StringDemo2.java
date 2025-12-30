package HeiMaJava.StringDemo;

public class StringDemo2 {
    public static void main(String[] args) {
//        目标：生成验证码
        String code = getCode(4);
        System.out.println(code);
    }

//    帮我生成指定位数的随机验证码，验证码由数字和大小写字母组成,
//    帮我用Sting变量记住全部得到的字符
    public static String getCode(int n) {
//        1.创建一个String变量保存生成的验证码
        String code = "";
//        2.循环n次，生成n位验证码
        for (int i = 0; i < n; i++) {
            int number = (int)(Math.random() * 10);
            char ch = (char)(Math.random() * 26 + 'a');
            char ch1 = (char)(Math.random() * 26 + 'A');
            int number1 = (int)(Math.random() * 10);
//            3.随机生成一个数字，大小写字母，数字，拼接成验证码
            code += number;
            code += ch;
            code += ch1;
            code += number1;
        }
        return code;
    }

}
