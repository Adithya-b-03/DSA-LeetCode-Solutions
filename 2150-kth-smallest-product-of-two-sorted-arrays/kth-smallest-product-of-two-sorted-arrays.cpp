class Solution {
    typedef long long ll;

    int cntposprod(int x, vector<int>& nums2, ll m) {
        int n = nums2.size();
        ll l = -1, r = n;
        while (l + 1 < r) {
            ll j = (l + r) / 2;
            if ((ll)x * nums2[j] <= m) {
                l = j;
            } else {
                r = j;
            }
        }
        return l + 1;
    }

    int cntnegprod(int x, vector<int>& nums2, ll m) {
        int n = nums2.size();
        ll l = -1, r = n;
        while (l + 1 < r) {
            ll j = (l + r) / 2;
            if ((ll)x * nums2[j] > m) {
                l = j;
            } else {
                r = j;
            }
        }
        return n - r;
    }

    bool isGood(ll m, vector<int>& nums1, vector<int>& nums2, ll k) {
        ll cnt = 0;
        for (auto x : nums1) {
            if (x > 0) {
                cnt += cntposprod(x, nums2, m);
            } else if (x == 0) {
                if (m >= 0) cnt += nums2.size();
            } else {
                cnt += cntnegprod(x, nums2, m);
            }
        }
        return (cnt >= k);
    }

public:
    long long kthSmallestProduct(vector<int>& nums1, vector<int>& nums2, long long k) {
        ll l = -1e10 - 1, r = 1e10 + 1;
        while (l + 1 < r) {
            ll m = (l + r) / 2;
            if (isGood(m, nums1, nums2, k)) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }
};
