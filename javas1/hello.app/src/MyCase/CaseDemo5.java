package MyCase;

import java.util.Scanner;

//评委打分
public class CaseDemo5 {
    public static void main(String[] args) {
//        定义一个动态初始化的数组，用于后期录入6各评委分数
        int[] scores = new int[6];
//        录入分数
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请您输入第" + (i+1) + "个评委的打分");
            int score = sc.nextInt();
//            把分数存入到数组的对应位置处
            scores[i] = score;
        }

//        找出最高分和最低分
        int max = scores[0],min = scores[0],sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i]>max){
                max = scores[i];
            }
            if(scores[i]<min){
                min = scores[i];
            }
            sum += scores[i];
        }

        double avg = (sum - max - min)*1.0 / (scores.length-2);
        System.out.println("选手最终得分" + avg);
    }
}
