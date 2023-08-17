
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int currMaxTime = neededTime[0];
        int totalTime = 0;

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) != colors.charAt(i - 1)) {
                currMaxTime = 0;
            }
            totalTime += Math.min(currMaxTime, neededTime[i]);
            currMaxTime = Math.max(currMaxTime, neededTime[i]);
        }
        return totalTime;
    }
}