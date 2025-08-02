
class Solution {
public:
    long long minCost(vector<int>& b1, vector<int>& b2) {
        unordered_map<int, int> freq, freq1, freq2;

        for (int x : b1) {
            freq[x]++;
            freq1[x]++;
        }

        for (int x : b2) {
            freq[x]++;
            freq2[x]++;
        }

        // Check if making them equal is even possible
        for (auto& [key, val] : freq) {
            if (val % 2 != 0) return -1;
        }

        vector<int> extra;

        // Build a list of elements that need to be swapped
        for (auto& [key, total] : freq) {
            int needed = total / 2;
            int diff = freq1[key] - needed;

            // Add half the difference to the extra list
            for (int i = 0; i < abs(diff); ++i) {
                extra.push_back(key);
            }
        }

        sort(extra.begin(), extra.end());  // Smallest cost first

        long long min_key = min_element(freq.begin(), freq.end(),
            [](const auto& a, const auto& b) {
                return a.first < b.first;
            })->first;

        long long cost = 0;
        int n = extra.size();

        for (int i = 0; i < n / 2; i++) {
            // Take the min of direct swap or using min_key twice
            cost += std::min((long long)extra[i], 2 * min_key);
        }

        return cost;
    }
};
