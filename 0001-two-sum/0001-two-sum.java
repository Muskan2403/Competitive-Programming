// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         for(int i =0;i<n;i++){
//             for(int j =i+1;j<n;j++){
//                 if(nums[i]+nums[j] == target){
//                     return new int[] {i,j};
//                 }
//             }
//         }
//         return new int[] {};
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            int complementary = target-nums[i];
            if(map.containsKey(complementary)){
return new int[]{map.get(complementary),i};
            } 
            map.put(nums[i],i);
        }
        return nums;
    }
}