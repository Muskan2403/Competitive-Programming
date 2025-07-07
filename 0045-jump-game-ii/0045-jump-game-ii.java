class Solution {
    public int jump(int[] nums) {
        int jump=0,fatherest=0,end=0;
        for(int i=0;i<nums.length-1;i++){
            fatherest=Math.max(fatherest,i+nums[i]);
            if(i==end){
                jump++;
                end=fatherest;
            }
        }
        return jump;
    }
}