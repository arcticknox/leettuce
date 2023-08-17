package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        // Sort 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] current_interval = intervals[0];
        List<int[]> output = new ArrayList<>();
        output.add(current_interval);

        for (int[] interval: intervals) {
            int current_start = current_interval[0];
            int current_end = current_interval[1];
            int interval_start = interval[0];
            int interval_end = interval[1];

            if (current_end >= interval_start) {
                current_interval[1] = Math.max(current_end, interval_end);
            } else {
                current_interval = interval;
                output.add(current_interval);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}