import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        
        // Map email to the index of the first account it appears in
        Map<String, Integer> emailToIndex = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    // If email already exists, union current account with the existing one
                    dsu.union(i, emailToIndex.get(email));
                }
            }
        }
        
        // Group emails by their root parent account index
        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int root = dsu.find(emailToIndex.get(email));
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }
        
        // Format the output: Name + Sorted Emails
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int rootIndex : components.keySet()) {
            List<String> emails = components.get(rootIndex);
            Collections.sort(emails);
            
            List<String> account = new ArrayList<>();
            account.add(accounts.get(rootIndex).get(0)); // Get the name
            account.addAll(emails);
            mergedAccounts.add(account);
        }
        
        return mergedAccounts;
    }
}

// Standard Disjoint Set Union (DSU) with Path Compression and Union by Rank
class DSU {
    int[] parent;
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }
}