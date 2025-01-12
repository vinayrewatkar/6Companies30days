class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        int count = 0;
        for(Integer e : map.keySet()){
            if(k==0 && map.get(e)>1){
                count++;
            }
            else if(k>0 && map.containsKey(e-k)){
                count++;
            }
        }
        return count;
    }
}