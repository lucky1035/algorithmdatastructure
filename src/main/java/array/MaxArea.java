package array;

public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0 ;
        int maxLeft = 0 ;
        int maxRight = 0 ;
        int j = height.length-1;
        for(int i = 0 ; i<height.length;i++){
            if(height[i]>maxLeft){
                maxLeft = height[i];
                int area = maxLeft>maxRight?(j-i)*maxRight:(j-i)*maxLeft;
                maxArea = area >maxArea?area:maxArea;
            }else {
                continue;
            }
            while(j>0){
                if(height[j]>maxRight){
                    maxRight = height[j];
                    int area = maxLeft>maxRight?(j-i)*maxRight:(j-i)*maxLeft;
                    maxArea = area >maxArea?area:maxArea;
                }
                if(i+1==j){
                    return maxArea;
                }
                if(maxRight>maxLeft){//如果右高度大于最大左高度时，左指针右移，其余情况右指针左移
                    break;
                }else{
                    j--;
                    continue;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int a[] = {1,8,6,2,5,4,8,3,7};
//        int a[] = {1,1};
        int area =  new MaxArea().maxArea(a);
        System.out.println(area);
    }
}
