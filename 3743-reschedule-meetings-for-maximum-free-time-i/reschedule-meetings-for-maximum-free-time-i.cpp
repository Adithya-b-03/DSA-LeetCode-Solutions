class Solution {
public:
    int maxFreeTime(int eventTime, int k, vector<int>& startTime, vector<int>& endTime) {
        int n = startTime.size(), p = 0;
        vector<int> gaps;
        for(int i=0;i<n;i++){
            gaps.push_back(startTime[i]-p);
            p = endTime[i];
        }
        gaps.push_back(eventTime - p); // push the last gap
        int len = k+1;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum += gaps[i]; // finding the first window sum
        }
        int ans = sum; // x => [st to st + x - 1] 
        for(int i=1;i+len-1<gaps.size();i++){
            sum -= gaps[i-1]; // substracting the portion moving out of window
            sum += gaps[i+len-1]; // adding the portion coming in the window
            ans = max(ans, sum);
        }
        return ans;
    }
};