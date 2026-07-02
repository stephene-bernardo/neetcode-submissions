class Solution {
     public boolean checkInclusion(String s1, String s2) {
        char[] charArray = s1.toCharArray();
        Arrays.sort(charArray);
        String sortedS1 = new String(charArray);
        for(int i=0; i<=s2.length()-s1.length(); i++){
            String substring = s2.substring(i, i + s1.length());
            char[] substringCharArray = substring.toCharArray();
            Arrays.sort(substringCharArray);
            substring = new String(substringCharArray);
            if(sortedS1.equals(substring)){
                return true;
            }
        }
        return false;
    }
}
