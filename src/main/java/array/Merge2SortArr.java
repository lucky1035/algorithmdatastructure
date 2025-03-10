package array;

public class Merge2SortArr {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int r[] = new int[m + n];
        if (m == 0) {
            return nums2;
        } else if (n == 0) {
            return nums2;
        }
        int a = 0;
        int b = 0;
        int i = 0;
        while (a < m || b < n) {

            if (a == m) {
                r[i] = nums2[b];
                b++;
            } else if (b == n) {
                r[i] = nums1[a];
                a++;
            } else if (nums1[a] < nums2[b]) {
                r[i] = nums1[a];
                a++;
            } else {
                r[i] = nums2[b];
                b++;
            }
            i++;

        }


        for (int k  = 0  ; k < r.length ; k++){
            System.out.print(r[k]);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new Merge2SortArr().merge(nums1, m, nums2, n);
    }
}
