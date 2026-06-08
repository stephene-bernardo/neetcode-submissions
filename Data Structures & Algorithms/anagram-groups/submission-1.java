class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupAnagramsMap = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String word = strs[i];
            StringBuilder sb = new StringBuilder();
            int stringLength = word.length();
            int[] alphabet = new int[26];
            for(int j = 0; j< stringLength; j++){
                int placing = word.charAt(j)%97;
                ++alphabet[placing];
            }
            for(int k = 0; k<alphabet.length;k++){
                int characterCount = alphabet[k];
                char actualCharacter = (char)(k + 97);
                for(int l=0; l< characterCount; l++){
                    sb.append(actualCharacter);
                }
            }


            String sortedString = sb.toString();
            if(groupAnagramsMap.containsKey(sortedString)){
                groupAnagramsMap.get(sortedString).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                groupAnagramsMap.put(sortedString, anagrams);
            }
        }
        return groupAnagramsMap.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toUnmodifiableList());
    }
}
