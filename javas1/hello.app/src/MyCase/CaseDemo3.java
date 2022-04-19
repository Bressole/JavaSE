package MyCase;

import java.util.Random;

//随机产生一个5位的验证码
public class CaseDemo3 {
    public static void main(String[] args) {
        String code = creatcode(5);
        System.out.println("随机验证码为：" + code);
    }

//    1、定义方法
    public static String creatcode(int n){
        String code = "";
        Random r = new Random();
//        2、定义循环，依次生成随机字母
        for (int i = 0; i < n; i++) {
//            3、生成一个随机字符
            int type = r.nextInt(3);
            switch (type){
                case 0://生成大写字符 65~65+25
                    char ch = (char)(r.nextInt(26)+65);
                    code += ch;
                    break;
                case 1://生成小写字符 97~97+25
                    char ch1 = (char)(r.nextInt(26)+97);
                    code += ch1;
                    break;
                case 2://数字
                    code += r.nextInt(10);
                    break;
            }

        }
        return code;
    }
}
