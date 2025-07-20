class Solution {
public:
    struct TrieNode {
        string name;
        unordered_map<string, TrieNode*> children;
        bool deleted = false;
        TrieNode(string n = "") : name(n) {}
    };

    TrieNode* root;
    unordered_map<string, int> serialCount;
    unordered_map<TrieNode*, string> nodeToSerial;

    void insert(vector<string>& path) {
        TrieNode* node = root;
        for (const string& folder : path) {
            if (!node->children.count(folder))
                node->children[folder] = new TrieNode(folder);
            node = node->children[folder];
        }
    }

    // Post-order traversal to serialize
    string serialize(TrieNode* node) {
        if (node->children.empty()) return "";

        vector<pair<string, string>> serials;
        for (auto& [name, child] : node->children) {
            serials.push_back({name, serialize(child)});
        }

        sort(serials.begin(), serials.end());

        string serial = "";
        for (auto& [name, ser] : serials) {
            serial += "(" + name + ser + ")";
        }

        nodeToSerial[node] = serial;
        serialCount[serial]++;
        return serial;
    }

    // Mark duplicates
    void markDuplicates(TrieNode* node) {
        if (nodeToSerial.find(node) != nodeToSerial.end()) {
            string& serial = nodeToSerial[node];
            if (serialCount[serial] > 1) {
                node->deleted = true;
                return; // no need to recurse
            }
        }

        for (auto& [_, child] : node->children) {
            markDuplicates(child);
        }
    }

    void collectPaths(TrieNode* node, vector<string>& path, vector<vector<string>>& result) {
        for (auto& [name, child] : node->children) {
            if (child->deleted) continue;
            path.push_back(name);
            result.push_back(path);
            collectPaths(child, path, result);
            path.pop_back();
        }
    }

    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        root = new TrieNode();

        for (auto& path : paths)
            insert(path);

        serialize(root);
        markDuplicates(root);

        vector<vector<string>> result;
        vector<string> path;
        collectPaths(root, path, result);
        return result;
    }
};
