
class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        // Task 1 - Getting the Powers List
        vector<int> pows;
        int v = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                pows.push_back(v);
            }
            n /= 2;
            v *= 2;
        }

        int mod = 1e9 + 7;
        int L = pows.size();

        // Task 2 - Precomputing Range Query Table
        vector<vector<int>> table(L, vector<int>(L, 0));
        for (int i = 0; i < L; i++) {
            long long prod = 1;
            for (int j = i; j < L; j++) {
                prod = (prod * pows[j]) % mod;
                table[i][j] = (int) prod;
            }
        }

        // Forming the results list
        vector<int> res;
        for (auto &q : queries) {
            int l = q[0], r = q[1];
            res.push_back(table[l][r]);
        }

        return res;
    }
};

