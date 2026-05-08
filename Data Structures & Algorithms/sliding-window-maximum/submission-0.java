class Pair {

    int val;

    int ind;

    Pair(int val, int ind) {

        this.val = val;

        this.ind = ind;

    }

}

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

        List<Integer> ans = new ArrayList<>();

        int l = 0;

        for (int r = 0; r < nums.length; r++) {

            pq.offer(new Pair(nums[r], r));

            if (r - l + 1 > k) {

                l++;

            }

            while (!pq.isEmpty() && pq.peek().ind < l) {

                pq.poll();

            }

            if (r - l + 1 == k) {

                ans.add(pq.peek().val);

            }

        }

        int[] arrAns = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {

            arrAns[i] = ans.get(i);

        }

        return arrAns;

    }

}