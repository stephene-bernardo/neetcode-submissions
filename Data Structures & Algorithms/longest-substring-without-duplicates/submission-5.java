class Solution {
   public int lengthOfLongestSubstring(String s) {
        int current = 0;
        int max = 0;
        List<Character> character = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(character.contains(currentChar)){
                while(character.contains(currentChar)){
                    character.removeFirst();
                }
                max = Math.max(current, max);
                current = character.size() + 1;
            } else{
                current++;
            }
            character.add(currentChar);
        }
        return Math.max(current, max);
    }
}
