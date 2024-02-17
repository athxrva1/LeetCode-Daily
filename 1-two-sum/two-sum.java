class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int n = nums.length;
        int k = 0;
        for(int i = 0; i < n; i++)
        {
            k = target - nums[i];
            if(hmap.containsKey(k))
                return new int[] {hmap.get(k), i};
            else
                hmap.put(nums[i], i);
        }

        return new int[]{};
    }
}