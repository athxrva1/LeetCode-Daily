class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int num: nums)
        {
            if(!hmap.containsKey(num))
                hmap.put(num, 1);
            else
                return true;
        }
        return false;
    }
}