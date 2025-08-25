package Interview;

public class MaxSumSubArray {

    public static void main (String[] args) {

        int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getMaxSum(num));

        int[] num2 = {-1, -2, -3, -4};
        System.out.println(getMaxSum(num2));
    }

    //Program to find the Maximum sum subarray
    public static int getMaxSum(int[] num){

        if (num == null || num.length==0) return 0;
        int maxSumEnding = num[0];
        int maxSum = num[0];

        for (int i=1;i<num.length;i++){
            maxSumEnding = Math.max(num[i],num[i]+maxSumEnding);
            maxSum = Math.max(maxSum,maxSumEnding);
        }
        return  maxSum;
    }
}
