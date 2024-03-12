class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int maxlen = 0;
        for(int num: nums)
            hs.add(num);

        for(int num: nums)
        {
            int x = num - 1;
            int curr = 0;

            if(!hs.contains(x))
            {
                while(hs.contains(x+1)) {
                    curr += 1;
                    x += 1;
                }

                maxlen = Math.max(maxlen, curr);
            }
        }

        return maxlen;
    }
}