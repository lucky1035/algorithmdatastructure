package heap;

public class Trap {
    public int trap(int[] height) {
        int rHeight[] = new int[height.length];
        int lHeight[] = new int[height.length];
        int hightValue = 0;
        int res =0;
        for(int i = 0 ;i<height.length ;i++){
            if(i-1<0){
                lHeight[i]= 0;
                hightValue = 0 ;
                continue;
            }
            if (hightValue<height[i-1]){
                hightValue= height[i-1];
            }
            lHeight[i]= hightValue;
        }
        hightValue=0;
        for(int i = height.length-1 ;i>=0 ;i--){
            if(i+1==height.length){
                rHeight[i]= 0;
                hightValue = 0;
                continue;
            }
            if (hightValue<height[i+1]){
                hightValue= height[i+1];
            }
            rHeight[i]= hightValue;
        }
        for(int i = 0 ; i<height.length;i++){
            res += caculate(lHeight[i],height[i],rHeight[i]);
        }
        System.out.println(res);
       for(int l : lHeight){
            System.out.print(l);
        }
        System.out.println("");
        for(int h : height){
            System.out.print(h);
        }
        System.out.println("");
        for(int r : rHeight){
            System.out.print(r);
        }

        return  res;
    }

    private int caculate(int l, int h, int r) {
        int v = Math.min(l,r) - h ;
        return v>0? v:0;
    }

    public static void main(String[] args) {

        int a [] = {4,2,0,3,2,5};
        new Trap().trap(a) ;
    }
}
