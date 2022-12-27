class Solution {
public:
    int mySqrt(int x) {
        double head = 0, tail = (1.0 * x) + 1, mid;
        for (int i = 0; i < 100; i++) {
            mid = (head + tail) / 2.0;
            if (mid * mid <= x) head = mid;
            else tail = mid;
        }
        return head;
    }
};