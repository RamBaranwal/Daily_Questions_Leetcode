/*
# [**3625. Count Number of Trapezoids II**](https://leetcode.com/problems/count-number-of-trapezoids-ii/)

Solved

Hard

Topics

![premium lock icon](https://leetcode.com/_next/static/images/lock-a6627e2c7fa0ce8bc117c109fb4e567d.svg)

Companies

Hint

You are given a 2D integer array `points` where `points[i] = [xi, yi]` represents the coordinates of the `ith` point on the Cartesian plane.

Return *the number of unique trapezoids* that can be formed by choosing any four distinct points from `points`.

A **trapezoid** is a convex quadrilateral with **at least one pair** of parallel sides. Two lines are parallel if and only if they have the same slope.

**Example 1:**

**Input:** points = [[-3,2],[3,0],[2,3],[3,2],[2,-3]]

**Output:** 2

**Explanation:**

![](https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-4.png)

![](https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-3.png)

There are two distinct ways to pick four points that form a trapezoid:

- The points `[-3,2], [2,3], [3,2], [2,-3]` form one trapezoid.
- The points `[2,3], [3,2], [3,0], [2,-3]` form another trapezoid.

**Example 2:**

**Input:** points = [[0,0],[1,0],[0,1],[2,1]]

**Output:** 1

**Explanation:**

![](https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-5.png)

There is only one trapezoid which can be formed.

**Constraints:**

- `4 <= points.length <= 500`
- `–1000 <= xi, yi <= 1000`
- All points are pairwise distinct.
*/
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        double INF = (double)Integer.MAX_VALUE;
        // map<slope, map<constant,noOfPoints>>
        Map<Double, Map<Double,Integer>> map = new HashMap<>(); // grouping by slopes and then by intercept for line-segment
        // parallelogram property : diagonals have the same mid-point (but will have different slope obviously)
        // count the number of segments that share a midpoint but have different slopes to compute the number of parallelograms
        Map<Double,Map<Double,Map<Double,Integer>>> midPointSlopes = new HashMap<>();
        for(int i=0;i<n;i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for(int j=i+1;j<n;j++) {
                int x2 = points[j][0], y2 = points[j][1];
                Double slope,intercept;
                // lines parallel to y-axis of form x = c
                if(x1 == x2) {
                    slope = INF;
                    intercept = (double)x1;
                }
                // lines parallel to x-axis of from y = c
                else if(y1 == y2) {
                    slope = 0.0;
                    intercept = (double)y1;
                }
                // generic lines of form y = mx + c, where m = slope, c = constant
                else {
                    slope = (double)(y2-y1) / (x2-x1);
                    intercept = (double)(y1*(x2-x1) - x1*(y2-y1)) / (x2-x1);
                }

                map.computeIfAbsent(slope, key -> new HashMap<>())
                    .merge(intercept,1,Integer::sum);

                Double mid_x = (double)(x1+x2)/2.0, mid_y = (double)(y1+y2)/2.0;
                midPointSlopes.computeIfAbsent(mid_x, key -> new HashMap<>())
                    .computeIfAbsent(mid_y, key -> new HashMap<>())
                    .merge(slope,1,Integer::sum);
            }
        }
        int trapezoids = 0;
        for(Double slope : map.keySet()) {
            int edgesCount = 0;
            for(Integer edges : map.get(slope).values()) {
                trapezoids = (trapezoids + edges * edgesCount);
                edgesCount += edges;
            }
        }
        int parallelograms = 0;
        for(Double x : midPointSlopes.keySet()) {
            for(Double y : midPointSlopes.get(x).keySet()) {
                // for each mid-point, calculate total number of parallelograms which have it
                int uniqueSlopes = 0;
                for(Integer count : midPointSlopes.get(x).get(y).values()) {
                    parallelograms = (parallelograms + uniqueSlopes * count);
                    uniqueSlopes += count;
                }
            }
        }
        return trapezoids - parallelograms;
    }
}