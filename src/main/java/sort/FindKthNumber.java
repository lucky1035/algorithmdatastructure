package sort;


/**
 *  https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/solution/ben-ti-shi-shang-zui-wan-zheng-ju-ti-de-shou-mo-sh/
 */
public class FindKthNumber {
//    public int findKthNumber(int n, int k) {
//        int cur=1;//第一字典序小的(就是1)
//        int prefix=1;// 前缀从1开始
//        while(cur<k) {
//            int tmp=getCount(prefix,n); //当前prefix峰的值
//            if(tmp+cur>k) {// 找到了
//                prefix*=10; //往下层遍历
//                cur++;//一直遍历到第K个推出循环
//            }else {
//                prefix++;//去下个峰头(前缀)遍历
//                cur+=tmp;//跨过了一个峰(前缀)
//            }
//        }//退出循环时 cur==k 正好找到
//        return prefix;
//    }
//
//    private int getCount(int prefix ,int n ) {
//        //不断向下层遍历可能一个乘10就溢出了, 所以用long
//        long cur=prefix;
//        long next=cur+1;//下一个前缀峰头
//        int count=0;
//        while(cur<=n) {
//            count+=Math.min(n+1,next)-cur;//下一峰头减去此峰头
//            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
//            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层
//
//            // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
//            // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
//            cur*=10;
//            next*=10; //往下层走
//        }
//        return count;
//    }

    public int findKthNumber(int n, int k) {
        int p = 1; //1 最小数 排序 计数 1
        int prefix = 1; //前缀从1开始寻找
        while (p < k) {
            int count = getCount(prefix, n);
            if (p + count > k) {
                prefix *= 10;//当前缀需要 下移 一层 ，指针 * 10  如 1 下移一层 为10
                p++;    //当前缀需要 下移 一层 ，最小数 排序 计数 需要 +1   如 1 下移一层 到 10后，最小数排序+1 。（排序根据前序遍历顺为从小到大顺序为依据）
            }else{
                prefix++;
                p += count;
            }
        }
        return prefix;
    }

    public int getCount(int prefix, int n) {
        int count = 0;
        //不断向下层遍历可能一个乘10就溢出了, 所以用long
//        long cur = prefix  ;
//        long next = cur + 1;
//        while(cur<=n){
//            count +=Math.min(n+1,next)- cur;
//            cur *=10;
//            next *=10;
//        }
        //不断向下层遍历可能一个乘10就溢出了, 所以用long
        for (long cur = prefix, next = prefix + 1; cur <= n; cur *= 10, next *= 10) {
            count += Math.min(n + 1, next) - cur;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = new FindKthNumber().findKthNumber(681692778, 351251360);
        System.out.println(a);
    }
}
