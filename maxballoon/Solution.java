package maxballoon;

class Solution {
    public int maxNumberOfBalloons(String text) {
        String pattern = "balloon";
        int[] textFrequencies = new int[26], patternFrequencies = new int[26];
        int output = Integer.MAX_VALUE;

        for (int i = 0; i < text.length(); i++) {
            textFrequencies[text.charAt(i) - 'a']++;
        }

        for (int i = 0; i < pattern.length(); i++) {
            patternFrequencies[pattern.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (patternFrequencies[i] > 0) {
                System.out.println(textFrequencies[i] + " " + patternFrequencies[i]);
                output = Math.min(output, textFrequencies[i] / patternFrequencies[i]);
            }
        }
        return output;
    }
}