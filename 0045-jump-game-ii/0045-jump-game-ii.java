class Solution {
    public int jump(int[] nums) {
        int jump=0,farther=0,end=0;
        for(int i=0;i<nums.length-1;i++){
            farther=Math.max(farther,i+nums[i]);
            if(i==end){
                jump++;
                end=farther;
            }
        }
        return jump;
    }
}