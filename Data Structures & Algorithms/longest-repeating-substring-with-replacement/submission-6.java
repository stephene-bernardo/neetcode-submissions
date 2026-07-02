class Solution {
  public int characterReplacement(String s, int k) {
        Map<Character, Integer> charByCount = new HashMap<>();
        int maxCount = 0;
        int first = 0, second = 1;
        int length = 1;
        charByCount.put(s.charAt(first), 1);
        while(second < s.length()) {
            Integer maxValue = charByCount.values().stream().max(Comparator.naturalOrder()).orElse(0);
            if(length - maxValue <= k ){
                Integer value = charByCount.getOrDefault(s.charAt(second), 0) + 1;
                charByCount.put(s.charAt(second), value);
                maxCount = Math.max(length, maxCount);
                length++;
                second++;
            }else {
                Integer firstValue = charByCount.get(s.charAt(first)) - 1;
                charByCount.put(s.charAt(first), firstValue);
                first++;
                length--;
            }
        }
        Integer maxValue = charByCount.values().stream().max(Comparator.naturalOrder()).orElse(0);
        if(length - maxValue <= k ){
            maxCount = Math.max(length, maxCount);
        }
        return maxCount;
    }
}
