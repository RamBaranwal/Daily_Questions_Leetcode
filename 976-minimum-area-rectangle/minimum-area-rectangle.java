class Solution {
    public int minAreaRect(int[][] points) {
        int smallestArea = Integer.MAX_VALUE;
        HashSet<Integer> s = new HashSet<>();
        
        for (int[] p : points)
            s.add(p[0] * 40001 + p[1]);

        for (int a = 0; a < points.length - 1; a++) {
            for (int b = a+1; b < points.length; b++) {
                int x1 = points[a][0], y1 = points[a][1];
                int x2 = points[b][0], y2 = points[b][1];
                if (x1 != x2 && y1 != y2) {
                    if (s.contains(x1 * 40001 + y2) && 
                        s.contains(x2 * 40001 + y1)) {
                        smallestArea = Math.min(smallestArea, Math.abs(x2-x1) * Math.abs(y2-y1));
                    }
                }
            }
        }
        return smallestArea == Integer.MAX_VALUE ? 0 : smallestArea;
    }
}