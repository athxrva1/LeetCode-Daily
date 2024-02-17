class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(Character ch: s.toCharArray())
        {
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }
        for(Character ch: t.toCharArray())
        {
            hmap.put(ch, hmap.getOrDefault(ch, 0) - 1);
        }

        for(int val: hmap.values()) {
            if(val != 0)
                return false;
        }

        return true;

    }
}