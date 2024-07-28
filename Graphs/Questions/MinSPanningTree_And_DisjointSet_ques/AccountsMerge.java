package Graphs.Questions.MinSPanningTree_And_DisjointSet_ques;
import java.util.*;

class DisjointSet3 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet3(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        int n = accounts.size();
        Map<String, Integer> mapMailNode =
                new HashMap<>();
        DisjointSet3 ds = new DisjointSet3(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail,i);
                }
                else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        List<List<String>> mergeMail = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            mergeMail.add(new ArrayList<>());
        }
        for (String it: mapMailNode.keySet()){
            String mail = it;
            int node = ds.findUPar(mapMailNode.get(mail));
            mergeMail.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(mergeMail.get(i).size() == 0)continue;
            Collections.sort(mergeMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergeMail.get(i));
            ans.add(temp);
        }
        return ans;

    }
}
