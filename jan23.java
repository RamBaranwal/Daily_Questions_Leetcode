// 3510. Minimum Pair Removal to Sort Array II
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Given an array nums, you can perform the following operation any number of times:

// Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
// Replace the pair with their sum.
// Return the minimum number of operations needed to make the array non-decreasing.

// An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).

 

// Example 1:

// Input: nums = [5,2,3,1]

// Output: 2

// Explanation:

// The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
// The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
// The array nums became non-decreasing in two operations.

// Example 2:

// Input: nums = [1,2,2]

// Output: 0

// Explanation:

// The array nums is already sorted.

 

// Constraints:

// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109

import java.util.*;
class Solution {

    static class Pair {
        long sum;
        int index;

        Pair(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int minimumPairRemoval(int[] nums) {

        int n = nums.length;
        if (n <= 1) return 0;

        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nums[i];

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] removed = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> x.sum == y.sum ? x.index - y.index : Long.compare(x.sum, y.sum)
        );

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair(a[i] + a[i + 1], i));
        }

        int bad = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) bad++;
        }

        int operations = 0;

        while (bad > 0) {

            Pair p;
            while (true) {
                p = pq.poll();
                int i = p.index;
                int j = next[i];

                if (j != -1 && !removed[i] && !removed[j]
                        && a[i] + a[j] == p.sum) {
                    break;
                }
            }

            int i = p.index;
            int j = next[i];

            if (prev[i] != -1 && a[prev[i]] > a[i]) bad--;
            if (a[i] > a[j]) bad--;
            if (next[j] != -1 && a[j] > a[next[j]]) bad--;

            a[i] += a[j];
            removed[j] = true;

            next[i] = next[j];
            if (next[j] != -1) {
                prev[next[j]] = i;
            }

            if (prev[i] != -1 && a[prev[i]] > a[i]) bad++;
            if (next[i] != -1 && a[i] > a[next[i]]) bad++;

            if (prev[i] != -1) {
                pq.offer(new Pair(a[prev[i]] + a[i], prev[i]));
            }
            if (next[i] != -1) {
                pq.offer(new Pair(a[i] + a[next[i]], i));
            }

            operations++;
        }

        return operations;
    }
}