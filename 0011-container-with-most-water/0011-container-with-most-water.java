class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int area = 0;
        while(l<r){
            int w = r-l;
            int minH = Math.min(height[r],height[l]);
            int maxA = w*minH;

            area = Math.max(area,maxA);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return area;
    }
}