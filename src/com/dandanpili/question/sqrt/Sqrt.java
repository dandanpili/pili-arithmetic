package com.dandanpili.question.sqrt;

/**
 * @author shaoruilin
 * @create 2021-03-20-17:44
 */
//不使用Math函数，求一个数的开平方，结果精确到0.00001
public class Sqrt {
    //需要精确到的精度
    private static double precision = 0.0000000001;
    public static void main(String[] args) {
        double result = sqrt(1.3f);
        String res = String.format("%.10f", result);
        System.out.println(res);
    }

    public static double sqrt(double n) {
        if (n < 0) {
            return 0;
        }
        double left = 0;
        double right = n;
        if (n < 1) {
            right = 1;
        }
        double mid = left + (right - left) / 2;
        while ((mid * mid) - n < -precision || (mid * mid) -n > precision) {
            if (mid * mid < n) {
                left = mid;
            } else {
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        return mid;
    }
}
