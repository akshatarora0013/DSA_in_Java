package Graph.Code;

import Heap.Code.CustomMinHeap;

import java.util.*;

public class Graph {
    private class Vertex{
        HashMap<String, Integer> neighbours = new HashMap<>();
    }

    private HashMap<String, Vertex> vertices;

    public Graph(){
        vertices = new HashMap<>();
    }

    public int numberOfVerteces(){
        return this.vertices.size();
    }

    public boolean ContainsVertex(String vName){
        return this.vertices.containsKey(vName);
    }

    public void addVerteces(String vName){
        Vertex v = new Vertex();
        vertices.put(vName, v);
    }

    public void removeVertex(String vName){
        Vertex v = vertices.get(vName);
        for (String key : v.neighbours.keySet()){
            Vertex vtx = vertices.get(key);
            vtx.neighbours.remove(vName);
        }
        vertices.remove(vName);
    }

    public int numberOfEdges(){
        int total = 0;
        for(String key: vertices.keySet()){
            Vertex v = vertices.get(key);
            total += v.neighbours.size();
        }
        return total/2;
    }

    public boolean containsEdge(String vName1, String vName2){
        Vertex v1 = vertices.get(vName1);
        Vertex v2 = vertices.get(vName2);
        if(v1 == null || v2 == null){
            return false;
        }
        if(v1.neighbours.containsKey(vName2) && v2.neighbours.containsKey(vName1)){
            return true;
        }
        return false;
    }

    public void addEdge(String vName1, String vName2, int cost){
        Vertex v1 = vertices.get(vName1);
        Vertex v2 = vertices.get(vName2);
        if(v1 == null || v2 == null || v1.neighbours.containsKey(vName2)){
            return;
        }
        v1.neighbours.put(vName2, cost);
        v2.neighbours.put(vName1, cost);
    }

    public void removeEdge(String vName1, String vName2){
        Vertex v1 = vertices.get(vName1);
        Vertex v2 = vertices.get(vName2);
        if(v1 == null || v2 == null || !v1.neighbours.containsKey(vName2)){
            return;
        }
        v1.neighbours.remove(vName2);
        v2.neighbours.remove(vName1);
    }

    public void display(){
        System.out.println("----------------------");
        for(String key: vertices.keySet()){
            Vertex v = vertices.get(key);
            System.out.println(key + ":" + v.neighbours);
        }
        System.out.println("----------------------");
    }

    public boolean hasPath(String vName1, String vName2, HashMap<String, Boolean> processed){
        processed.put(vName1, true);
        if(containsEdge(vName1,vName2)){
            return true;
        }
        Vertex v = vertices.get(vName1);
        for (String key: v.neighbours.keySet()){
            if(!processed.containsKey(key) && hasPath(key, vName2, processed)){
                return true;
            }
        }
        return false;
    }

    private class Pair{
        String vName;
        String pathSoFar;
    }

    // breadth first search
    public boolean bfs(String source, String destination){
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();

        Pair s = new Pair();
        s.vName = source;
        s.pathSoFar = source;

        queue.addLast(s);
        while (!queue.isEmpty()){
            Pair rm = queue.removeFirst();
            if(processed.containsKey(rm.vName)){
                continue;
            }
            processed.put(rm.vName, true);
            if(containsEdge(rm.vName, destination)){
                System.out.println(rm.pathSoFar + " " + destination);
                return true;
            }
            Vertex v = vertices.get(rm.vName);
            for(String key: v.neighbours.keySet()){
                if(!processed.containsKey(key)){
                    Pair np = new Pair();
                    np.vName = key;
                    np.pathSoFar = rm.pathSoFar + " " + key;
                    queue.addLast(np);
                }
            }
        }
        return false;
    }


    //breadth first traversal
    public void bft(){
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();

        for (String keys: vertices.keySet()) {
            if(processed.containsKey(keys)){
                continue;
            }
            Pair s = new Pair();
            s.vName = keys;
            s.pathSoFar = keys;

            queue.addLast(s);
            while (!queue.isEmpty()) {
                Pair rm = queue.removeFirst();
                if (processed.containsKey(rm.vName)) {
                    continue;
                }
                processed.put(rm.vName, true);
                System.out.println(rm.vName + ":" + rm.pathSoFar);
                Vertex v = vertices.get(rm.vName);
                for (String key : v.neighbours.keySet()) {
                    if (!processed.containsKey(key)) {
                        Pair np = new Pair();
                        np.vName = key;
                        np.pathSoFar = rm.pathSoFar + " " + key;
                        queue.addLast(np);
                    }
                }
            }
        }
    }

    // depth first search
    public boolean dfs(String source, String destination){
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> stack = new LinkedList<>();

        Pair s = new Pair();
        s.vName = source;
        s.pathSoFar = source;
        stack.addFirst(s);

        while (!stack.isEmpty()){
            Pair rm = stack.removeFirst();
            if(processed.containsKey(rm.vName)){
                continue;
            }
            processed.put(rm.vName, true);
            if(containsEdge(rm.vName, destination)){
                System.out.println(rm.pathSoFar + " " + destination);
                return true;
            }
            Vertex v = vertices.get(rm.vName);
            for(String key: v.neighbours.keySet()){
                if(!processed.containsKey(key)){
                    Pair np = new Pair();
                    np.vName = key;
                    np.pathSoFar = rm.pathSoFar + " " + key;
                    stack.addFirst(np);
                }
            }
        }
        return false;
    }

    //depth first traversal
    public void dft(){
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> stack = new LinkedList<>();

        for (String keys: vertices.keySet()) {
            if(processed.containsKey(keys)){
                continue;
            }
            Pair s = new Pair();
            s.vName = keys;
            s.pathSoFar = keys;

            stack.addFirst(s);
            while (!stack.isEmpty()) {
                Pair rm = stack.removeFirst();
                if (processed.containsKey(rm.vName)) {
                    continue;
                }
                processed.put(rm.vName, true);
                System.out.println(rm.vName + ":" + rm.pathSoFar);
                Vertex v = vertices.get(rm.vName);
                for (String key : v.neighbours.keySet()) {
                    if (!processed.containsKey(key)) {
                        Pair np = new Pair();
                        np.vName = key;
                        np.pathSoFar = rm.pathSoFar + " " + key;
                        stack.addFirst(np);
                    }
                }
            }
        }
    }

    public boolean isCyclic(){
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();

        for (String keys: vertices.keySet()) {
            if(processed.containsKey(keys)){
                return true;
            }
            Pair s = new Pair();
            s.vName = keys;
            s.pathSoFar = keys;

            queue.addLast(s);
            while (!queue.isEmpty()) {
                Pair rm = queue.removeFirst();
                if (processed.containsKey(rm.vName)) {
                    continue;
                }
                processed.put(rm.vName, true);
                Vertex v = vertices.get(rm.vName);
                for (String key : v.neighbours.keySet()) {
                    if (!processed.containsKey(key)) {
                        Pair np = new Pair();
                        np.vName = key;
                        np.pathSoFar = rm.pathSoFar + " " + key;
                        queue.addLast(np);
                    }
                }
            }
        }
        return false;
    }

    public boolean isConnected(){
        int flag = 0;
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();

        for (String keys: vertices.keySet()) {
            if(processed.containsKey(keys)){
                continue;
            }
            flag++;
            Pair s = new Pair();
            s.vName = keys;
            s.pathSoFar = keys;

            queue.addLast(s);
            while (!queue.isEmpty()) {
                Pair rm = queue.removeFirst();
                if (processed.containsKey(rm.vName)) {
                    continue;
                }
                processed.put(rm.vName, true);
                Vertex v = vertices.get(rm.vName);
                for (String key : v.neighbours.keySet()) {
                    if (!processed.containsKey(key)) {
                        Pair np = new Pair();
                        np.vName = key;
                        np.pathSoFar = rm.pathSoFar + " " + key;
                        queue.addLast(np);
                    }
                }
            }
        }
        return !(flag > 1);
    }

    public boolean isTree(){
        return !(this.isCyclic()) && this.isConnected();
    }

    public ArrayList<ArrayList<String>> connectedComponents(){
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        for (String keys: vertices.keySet()) {
            if(processed.containsKey(keys)){
                continue;
            }

            ArrayList<String> subans = new ArrayList<>();
            Pair s = new Pair();
            s.vName = keys;
            s.pathSoFar = keys;

            queue.addLast(s);
            while (!queue.isEmpty()) {
                Pair rm = queue.removeFirst();
                if (processed.containsKey(rm.vName)) {
                    continue;
                }
                processed.put(rm.vName, true);
                subans.add(rm.vName);
                Vertex v = vertices.get(rm.vName);
                for (String key : v.neighbours.keySet()) {
                    if (!processed.containsKey(key)) {
                        Pair np = new Pair();
                        np.vName = key;
                        np.pathSoFar = rm.pathSoFar + " " + key;
                        queue.addLast(np);
                    }
                }
            }
            ans.add(subans);
        }
        return ans;
    }

    private class PrismsPair implements Comparable<PrismsPair>{
        String vName;
        String parentVertex;
        int cost;

        @Override
        public int compareTo(PrismsPair o){
            return o.cost - this.cost;
        }
    }

    public Graph prismsAlgo(){
        Graph mst = new Graph();
        HashMap<String, PrismsPair> map = new HashMap<>();
        CustomMinHeap<PrismsPair> heap = new CustomMinHeap<>();

        for(String key: vertices.keySet()){
            PrismsPair pair = new PrismsPair();
            pair.vName = key;
            pair.parentVertex = null;
            pair.cost = Integer.MAX_VALUE;

            map.put(key, pair);
            heap.add(pair);
        }

        while (!heap.isEmpty()){
            PrismsPair rp = heap.remove();
            map.remove(rp.vName);

            if(rp.parentVertex == null){
                mst.addVerteces(rp.vName);
            }
            else{
                mst.addVerteces(rp.vName);
                mst.addEdge(rp.vName, rp.parentVertex, rp.cost);
            }

            for(String nbr: vertices.get(rp.vName).neighbours.keySet()){
                if(map.containsKey(nbr)){
                    int oc = map.get(nbr).cost;
                    int nc = vertices.get(rp.vName).neighbours.get(nbr);
                    if(nc < oc){
                        PrismsPair p = map.get(nbr);
                        p.parentVertex = rp.vName;
                        p.cost = nc;
                        heap.updatePriority(p);
                    }
                }
            }
        }

        return mst;
    }
}
