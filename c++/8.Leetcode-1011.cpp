class Solution {
public:
    int get_days(vector<int> &nums, int d) {
        int sum = 0, cnt = 0;
        for (auto x : nums) {
            if (sum + x > d) {
                cnt += 1;
                sum = 0;
            }
            sum += x;
        }
        if (sum) cnt += 1;
        return cnt;
    }
    int shipWithinDays(vector<int>& weights, int days) {
        int head = 0, tail = 0, mid;
        for (auto x : weights) head = max(head, x), tail += x;
        while (head < tail) {
            mid = (head + tail) / 2;
            if (get_days(weights, mid) <= days) tail = mid;
            else head = mid + 1;
        }
        return head;
    }
};