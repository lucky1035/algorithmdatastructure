package dynamicProgramming.packge;

import java.util.Scanner;

public class ZeroOnePack {

    public static final int N = 1010;  // 多开几个数据，防止数组下标越界

    static int n, m;  // 物品种类数，背包容积
    static int[] v = new int[N], w = new int[N];  // 体积，价值。注意：v[1]存储第一件物品，索引0未使用
    static int[][] ff = new int[N][N];   // dp数组
    static int[]  f = new int [N];   // dp数组
//    public int zeroOnePack(int [] f,int c,int w){
//        for(int v =  ,){
//
//        }
//    }
    static  int[][] params=  {{4,5},{1,2},{2,4},{3,4},{4,5}};

    public static void main(String[] args) {

        n = params[0][0]; m = params[0][1];
        for (int i = 1; i <= n; i++) {
            v[i] =  params[i][0] ; w[i] = params[i][1];
        }

//        for (int i = 1; i <= n; i++) {  // 先循环物品
//            for (int j = 0; j <= m; j++) {  // 再循环容量
//                // 最后循环决策
//                f[i][j] = f[i - 1][j];  // 不选第i件物品
//                if (j >= v[i]) {
//                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);  // 考虑选第i件物品
//                }
//            }
//        }
        for (int i = 1; i <= n; i++) {  // 先循环物品
            for (int j = m; j >= v[i]; j--) {  // 再循环容量
                // 最后循环决策
//                f[i][j] = f[i - 1][j];  // 不选第i件物品

                    f[j] = Math.max(f[j], f[j - v[i]] + w[i]);  // 考虑选第i件物品

            }
        }
        System.out.println(f[m]);


    }


}
