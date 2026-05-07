class Solution {
    class Pair {
        int rem;
        int time;

        Pair(int rem, int time) {
            this.rem = rem;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

        int[] map = new int[26];

        for (char task : tasks) {
            map[task - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                que.offer(map[i]);
            }
        }

        Queue<Pair> q = new ArrayDeque<>();

        int t = 0;

        while (!que.isEmpty() || !q.isEmpty()) {
            t++;

            if (!que.isEmpty()) {
                int element = que.poll();

                if (element > 1) {
                    q.offer(new Pair(element - 1, t + n));
                }
            }

            if (!q.isEmpty() && q.peek().time == t) {
                que.offer(q.poll().rem);
            }
        }

        return t;
    }
}