package MyCase;
//找素数
public class CaseDemo2 {
    public static void main(String[] args) {
        for (int i =101;i <= 200;i++){
//            1、判断
            //        信号位
            boolean flag = true;
            for (int j = 2; j < i/2; j++) {
                if(i % j == 0){
                    flag = false;
                }
            }
//            2、输出
            if (flag){
                System.out.print(i + "\t");
            }
        }

    }
}
