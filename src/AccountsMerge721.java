import java.util.*;

public class AccountsMerge721 {
    class Solution {
        //int[] rank;
        //int[] parent;
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int size = accounts.size();
            int[] rank = new int[size+1];
            int[] parent = new int[size+1];

            for(int i=0;i<=size;i++){
                parent[i] = i;
                rank[i] =1;
            }
            Map<String, Integer> map = new HashMap<>();

            for(int i=0;i<size;i++){
                List<String> curr = accounts.get(i);

                for(int j=1;j<curr.size();j++){
                    String email = accounts.get(i).get(j);

                    if(!map.containsKey(email)){
                        map.put(email,i);
                    }
                    else{
                        union(i,map.get(email), parent, rank);
                    }
                }
            }

            Map<Integer, List<String>> merge = new HashMap<>();

            for(String email:map.keySet()){
                int name = map.get(email);

                int p_name = find(name, parent);


                if(!merge.containsKey(p_name))
                    merge.put(p_name, new ArrayList<String>());

                merge.get(p_name).add(email);
            }

            List<List<String>> mergedAccounts = new ArrayList<>();
            for(int name: merge.keySet()){
                String str_name = accounts.get(name).get(0);
                List<String> emails = merge.get(name);

                Collections.sort(emails);
                emails.add(0,str_name);
                mergedAccounts.add(emails);
            }
            return mergedAccounts;
        }

        public int find(int i, int[] parent){
            if(parent[i]==i)
                return parent[i];
            return find(parent[i], parent);
        }

        public void union(int i, int j, int[] parent, int[] rank){
            int ri = rank[i];
            int rj = rank[j];

            int pi = find(i, parent);
            int pj = find(j, parent);

            if(pi==pj)
                return;

            if(ri>rj){
                parent[pj] = pi;
            }
            else if(ri<rj){
                parent[pi] = pj;
            }else if(ri==rj){
                parent[pj] = pi;
                rank[i]++;
                rank[j]=rank[i];
            }
        }
    }
}
