class Solution {
    public boolean isPalindrome(String s) {
        // Write some regex?
        s = s.replaceAll(  "[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int length = s.length();
        for(int i = 0; i < length; i++)
        {
            if(s.charAt(i) != s.charAt(length - i - 1))
                return false;
        }
        return true;
    }
}