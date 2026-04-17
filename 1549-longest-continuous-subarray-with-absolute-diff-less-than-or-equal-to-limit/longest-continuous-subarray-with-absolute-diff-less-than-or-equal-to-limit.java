class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            while (!maxDeque.isEmpty() && num > maxDeque.peekLast())
                maxDeque.pollLast();
            maxDeque.offerLast(num);

            while (!minDeque.isEmpty() && num < minDeque.peekLast())
                minDeque.pollLast();
            minDeque.offerLast(num);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[left]) minDeque.pollFirst();
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
