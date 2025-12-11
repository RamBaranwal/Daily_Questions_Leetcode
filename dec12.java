/*
# [**3531. Count Covered Buildings**](https://leetcode.com/problems/count-covered-buildings/)

Solved

Medium

Topics

![premium lock icon](https://leetcode.com/_next/static/images/lock-a6627e2c7fa0ce8bc117c109fb4e567d.svg)

Companies

Hint

You are given a positive integer `n`, representing an `n x n` city. You are also given a 2D grid `buildings`, where `buildings[i] = [x, y]` denotes a **unique** building located at coordinates `[x, y]`.

A building is **covered** if there is at least one building in all **four** directions: left, right, above, and below.

Return the number of **covered** buildings.

**Example 1:**

![](https://assets.leetcode.com/uploads/2025/03/04/telegram-cloud-photo-size-5-6212982906394101085-m.jpg)

**Input:** n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]

**Output:** 1

**Explanation:**

- Only building `[2,2]` is covered as it has at least one building:
    - above (`[1,2]`)
    - below (`[3,2]`)
    - left (`[2,1]`)
    - right (`[2,3]`)
- Thus, the count of covered buildings is 1.

**Example 2:**

![](https://assets.leetcode.com/uploads/2025/03/04/telegram-cloud-photo-size-5-6212982906394101086-m.jpg)

**Input:** n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]

**Output:** 0

**Explanation:**

- No building has at least one building in all four directions.

**Example 3:**

![](https://assets.leetcode.com/uploads/2025/03/16/telegram-cloud-photo-size-5-6248862251436067566-x.jpg)

**Input:** n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]

**Output:** 1

**Explanation:**

- Only building `[3,3]` is covered as it has at least one building:
    - above (`[1,3]`)
    - below (`[5,3]`)
    - left (`[3,2]`)
    - right (`[3,5]`)
- Thus, the count of covered buildings is 1.

**Constraints:**

- `2 <= n <= 105`
- `1 <= buildings.length <= 105`
- `buildings[i] = [x, y]`
- `1 <= x, y <= n`
- All coordinates of `buildings` are **unique**.
*/
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, int[]> row = new HashMap<>();
        // For each column -> store min x and max x
        Map<Integer, int[]> col = new HashMap<>();

        // Step 1: Fill row and col maps
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            row.putIfAbsent(x, new int[]{y, y});
            row.get(x)[0] = Math.min(row.get(x)[0], y);
            row.get(x)[1] = Math.max(row.get(x)[1], y);

            col.putIfAbsent(y, new int[]{x, x});
            col.get(y)[0] = Math.min(col.get(y)[0], x);
            col.get(y)[1] = Math.max(col.get(y)[1], x);
        }

        int covered = 0;

        // Step 2: check each building
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            int minY = row.get(x)[0], maxY = row.get(x)[1];
            int minX = col.get(y)[0], maxX = col.get(y)[1];

            boolean left  = minY < y;
            boolean right = maxY > y;
            boolean above = minX < x;
            boolean below = maxX > x;

            if (left && right && above && below) {
                covered++;
            }
        }

        return covered;
    }
}