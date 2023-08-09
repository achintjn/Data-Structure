import java.util.*;

public class EvaluateDivision399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String,Double>> adj = new HashMap<>();

        for(int i=0;i<equations.size();i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double val = values[i];
            double val2 = 1 / val;

            if(!adj.containsKey(from))
                adj.put(from, new HashMap<>());
            if(!adj.containsKey(to))
                adj.put(to,new HashMap<>());

            adj.get(from).put(to,val);
            adj.get(to).put(from, val2);


        }

        double [] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if(!adj.containsKey(from) || !adj.containsKey(to))
                res[i] = -1.0;
            else
                res[i] = backtrack(adj,from, to,new HashSet<>(),1.0);

        }
        return res;
    }

    public double backtrack(Map<String, Map<String,Double>> adj, String from, String to,
                            Set<String> seen, double res){
        seen.add(from);
        Map<String, Double> neighbor = adj.get(from);
        double ret = -1.0;
        for(Map.Entry<String, Double> entry:neighbor.entrySet()){
            String n = entry.getKey();
            double val = entry.getValue();
            if(n.equals(to)){
                ret = res*val;
                break;
            }

            if(!seen.contains(n))
                ret = backtrack(adj,n,to,seen,res*val);
            if(ret!=-1)
                break;
        }
        return ret;
    }
}
