/*
# [**2092. Find All People With Secret**](https://leetcode.com/problems/find-all-people-with-secret/)

Solved

Hard

Topics

![premium lock icon](https://leetcode.com/_next/static/images/lock-a6627e2c7fa0ce8bc117c109fb4e567d.svg)

Companies

Hint

You are given an integer `n` indicating there are `n` people numbered from `0` to `n - 1`. You are also given a **0-indexed** 2D integer array `meetings` where `meetings[i] = [xi, yi, timei]` indicates that person `xi` and person `yi` have a meeting at `timei`. A person may attend **multiple meetings** at the same time. Finally, you are given an integer `firstPerson`.

Person `0` has a **secret** and initially shares the secret with a person `firstPerson` at time `0`. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person `xi` has the secret at `timei`, then they will share the secret with person `yi`, and vice versa.

The secrets are shared **instantaneously**. That is, a person may receive the secret and share it with people in other meetings within the same time frame.

Return *a list of all the people that have the secret after all the meetings have taken place.* You may return the answer in **any order**.

**Example 1:**

```
Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
Output: [0,1,2,3,5]
Explanation:
At time 0, person 0 shares the secret with person 1.
At time 5, person 1 shares the secret with person 2.
At time 8, person 2 shares the secret with person 3.
At time 10, person 1 shares the secret with person 5.
Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.

```

**Example 2:**

```
Input: n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
Output: [0,1,3]
Explanation:
At time 0, person 0 shares the secret with person 3.
At time 2, neither person 1 nor person 2 know the secret.
At time 3, person 3 shares the secret with person 0 and person 1.
Thus, people 0, 1, and 3 know the secret after all the meetings.

```

**Example 3:**

```
Input: n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
Output: [0,1,2,3,4]
Explanation:
At time 0, person 0 shares the secret with person 1.
At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
Note that person 2 can share the secret at the same time as receiving it.
At time 2, person 3 shares the secret with person 4.
Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.

```

**Constraints:**

- `2 <= n <= 105`
- `1 <= meetings.length <= 105`
- `meetings[i].length == 3`
- `0 <= xi, yi <= n - 1`
- `xi != yi`
- `1 <= timei <= 105`
- `1 <= firstPerson <= n - 1`

---

Seen this question in a real interview before?

**1/5**

Yes

No

**Accepted121,366/262.3K**

**Acceptance Rate46.3%**

---

Topics

---

![icon](https://leetcode.com/_next/static/images/lock-a6627e2c7fa0ce8bc117c109fb4e567d.svg)

Companies

---

Hint 1

Could you model all the meetings happening at the same time as a graph?

---

Hint 2

What data structure can you use to efficiently share the secret?

---

Hint 3

You can use the union-find data structure to quickly determine who knows the secret and share the secret.
*/
import java.util.*;
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        // Step 2: Union-Find setup
        UnionFind uf = new UnionFind(n);

        // Step 3: Track who knows the secret
        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        int i = 0;

        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> currentMeetings = new ArrayList<>();

            // Collect all meetings at same time
            while (i < meetings.length && meetings[i][2] == time) {
                currentMeetings.add(meetings[i]);
                i++;
            }

            // Union all meetings at this time
            for (int[] m : currentMeetings) {
                uf.union(m[0], m[1]);
            }

            // Find all components that already know the secret
            Set<Integer> secretRoots = new HashSet<>();
            for (int[] m : currentMeetings) {
                if (knows[m[0]]) secretRoots.add(uf.find(m[0]));
                if (knows[m[1]]) secretRoots.add(uf.find(m[1]));
            }

            // Spread secret inside those components
            for (int[] m : currentMeetings) {
                if (secretRoots.contains(uf.find(m[0]))) {
                    knows[m[0]] = true;
                    knows[m[1]] = true;
                }
            }

            // Reset union-find connections for next time
            for (int[] m : currentMeetings) {
                uf.reset(m[0]);
                uf.reset(m[1]);
            }
        }

        // Collect result
        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (knows[p]) result.add(p);
        }
        return result;
    }

    // Union-Find Class
    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            parent[find(a)] = find(b);
        }

        void reset(int x) {
            parent[x] = x;
        }
    }
}