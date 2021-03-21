package com.dandanpili.question.sqrt;

/**
 * @author shaoruilin
 * @create 2021-03-20-17:44
 */
//不使用Math函数，求一个数的开平方，结果精确到0.00001
public class Sqrt
{
    public static void main(String[] args) {
        float result = sqrt(0.09f);
        String res = String.format("%.4f", result);
        System.out.println(res);
    }

    public static float sqrt(float n) {
        if (n < 0) {
            return 0;
        }
        float left = 0;
        float right = n;
        if (n < 1) {
            right = 1;
        }
        float mid = left + (right - left) / 2;
        while ((mid * mid) - n < -0.00001 || (mid * mid) -n > 0.00001) {
            mid = left + (right - left) / 2;
            System.out.println(mid);
            if (mid * mid <= n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return mid;

    }
}
