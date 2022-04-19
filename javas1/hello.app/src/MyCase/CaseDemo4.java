package MyCase;
//数组元素的复制
public class CaseDemo4 {
    public static void main(String[] args) {
        int[] arr1 = {11,22,33,44,55,66};
        int[] arr2 = new int[arr1.length];
        copy(arr1,arr2);
        printfArray(arr1);
        printfArray(arr2);
    }

    public static void printfArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length-1? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
    }

    public static void copy(int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }
}
