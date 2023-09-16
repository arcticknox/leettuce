package mergesortedarrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Clone = new int[m];
        int r1 = 0;
        int r2 = 0;
        // Clone
        for (int i = 0; i < m; i++) {
            nums1Clone[i] = nums1[i];
        }

        for (int i = 0; i < m + n; i++) {
            if (r2 >= n || (r1 < m && nums1Clone[r1] < nums2[r2])) {
                nums1[i] = nums1Clone[r1++];
            } else {
                nums1[i] = nums2[r2++];
            }
        }

    }
}
