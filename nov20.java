/*
# [**757. Set Intersection Size At Least Two**](https://leetcode.com/problems/set-intersection-size-at-least-two/)

Solved

Hard

Topics

![premium lock icon](https://leetcode.com/_next/static/images/lock-a6627e2c7fa0ce8bc117c109fb4e567d.svg)

Companies

You are given a 2D integer array `intervals` where `intervals[i] = [starti, endi]` represents all the integers from `starti` to `endi` inclusively.

A **containing set** is an array `nums` where each interval from `intervals` has **at least two** integers in `nums`.

- For example, if `intervals = [[1,3], [3,7], [8,9]]`, then `[1,2,4,7,8,9]` and `[2,3,4,8,9]` are **containing sets**.

Return *the minimum possible size of a containing set*.

**Example 1:**

```
Input: intervals = [[1,3],[3,7],[8,9]]
Output: 5
Explanation: let nums = [2, 3, 4, 8, 9].
It can be shown that there cannot be any containing array of size 4.

```

**Example 2:**

```
Input: intervals = [[1,3],[1,4],[2,5],[3,5]]
Output: 3
Explanation: let nums = [2, 3, 4].
It can be shown that there cannot be any containing array of size 2.

```

**Example 3:**

```
Input: intervals = [[1,2],[2,3],[2,4],[4,5]]
Output: 5
Explanation: let nums = [1, 2, 3, 4, 5].
It can be shown that there cannot be any containing array of size 4.

```

**Constraints:**

- `1 <= intervals.length <= 3000`
- `intervals[i].length == 2`
- `0 <= starti < endi <= 108`
*/
import java.util.Arrays;
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int res = 0;

        // last two picked numbers
        int a = -1, b = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Case 1: No intersection with selected numbers
            if (start > a) {
                // Need two new numbers
                res += 2;
                b = end - 1;
                a = end;
            }
            // Case 2: Only one number intersects
            else if (start > b) {
                // Need one more number
                res += 1;
                b = a;
                a = end;
            }
            // Case 3: Already covered by two numbers → do nothing
        }

        return res;
    }
}