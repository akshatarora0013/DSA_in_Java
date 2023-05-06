package Graph.Questions.LeetCodemedium;

import java.util.*;

//   https://leetcode.com/problems/accounts-merge/description/

public class _721_Accounts_merge {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int n = accounts.size();
            DisjointSet ds = new DisjointSet(n);
            HashMap<String, Integer> map = new HashMap<>();

            for(int i = 0; i < n; i++){
                for(int j = 1; j < accounts.get(i).size(); j++){
                    if(map.containsKey(accounts.get(i).get(j))){
                        ds.unionBySize(i, map.get(accounts.get(i).get(j)));
                    }
                    else{
                        map.put(accounts.get(i).get(j), i);
                    }
                }
            }

            List<List<String>> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new ArrayList<>());
            }
            for(Map.Entry<String, Integer> it: map.entrySet()){
                String account = it.getKey();
                int node = ds.findParent(it.getValue());
                temp.get(node).add(account);
            }

            List<List<String>> mergedAccounts = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(temp.get(i).size() == 0){
                    continue;
                }
                Collections.sort(temp.get(i));
                List<String> list = new ArrayList<>();
                list.add(accounts.get(i).get(0));
                for(int j = 0; j < temp.get(i).size(); j++){
                    list.add(temp.get(i).get(j));
                }
                mergedAccounts.add(list);
            }
            return mergedAccounts;
        }
    }
    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DisjointSet(int n){
            for(int i = 0; i <= n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        int findParent(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return ultimateParent;
        }

        void unionByRank(int u, int v){
            int ultimateParentU = findParent(u);
            int ultimateParentV = findParent(v);
            if(ultimateParentU == ultimateParentV){
                return;
            }
            if(rank.get(ultimateParentU) < rank.get(ultimateParentV)){
                parent.set(ultimateParentU, ultimateParentV);
            }
            else if(rank.get(ultimateParentV) < rank.get(ultimateParentU)){
                parent.set(ultimateParentV, ultimateParentU);
            }
            else{
                parent.set(ultimateParentV, ultimateParentU);
                rank.set(ultimateParentU, rank.get(ultimateParentU)+1);
            }
        }

        void unionBySize(int u, int v){
            int ultimateParentU = findParent(u);
            int ultimateParentV = findParent(v);
            if(ultimateParentU == ultimateParentV){
                return;
            }
            if(size.get(ultimateParentU) < size.get(ultimateParentV)){
                parent.set(ultimateParentU, ultimateParentV);
                size.set(ultimateParentV, size.get(ultimateParentU) + size.get(ultimateParentV));
            }
            else{
                parent.set(ultimateParentV, ultimateParentU);
                size.set(ultimateParentU, size.get(ultimateParentU) + size.get(ultimateParentV));
            }
        }
    }
}
