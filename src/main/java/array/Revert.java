package array;

public class Revert {
    public static void main(String[] args) {
//        int a[][] =   {{1,2,3},{4,5,6},{7,8,9}};
        int a[][] =   {{5 ,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        new Revert().rotate(a);

        for(int i = 0 ;i<a.length;++i){
            for (int j = 0;j<a.length;++j){
                System.out.print(a[i][j]+",");
            }
            System.out.println("");

        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2;++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
