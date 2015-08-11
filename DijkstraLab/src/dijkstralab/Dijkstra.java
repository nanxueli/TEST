/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstralab;

import java.util.HashMap;  
import java.util.HashSet;  
import java.util.Iterator;  
import java.util.Map.Entry;  
import java.util.Set;  
/**
 *
 * @author yangnan
 */
public class Dijkstra {
   
    private static final int minDis = 0;  
    private static final int maxDis = Integer.MAX_VALUE; 
    // Graph's matrix  
    int[][] matrix;  
    // start nodes 
    int startIndex;  
    // To store the distance from start node to other nodes 
    HashMap<Integer, Integer> distanceMap = new HashMap<Integer, Integer>();  
    // To store visited node  
    Set<Integer> findedSet = new HashSet<Integer>();  
  
    public Dijkstra(int[][] matrix, int start) {  
        this.matrix = matrix;  
        this.startIndex = start;  
        //findedSet.add(startIndex);  
    }  
  
    public void find() {  
        // Initial weight using neighbour of start node
        for (int i = 0; i < matrix.length; i++) {  
            //if (matrix[startIndex][i] != maxDis)  
                distanceMap.put(i, matrix[startIndex][i]);  
        }  
  
        while (findedSet.size() != matrix.length) {  
            int currentMinIndex = currentMinIndex();  
            // Update with shortest path
            for (int i = 0; i < matrix.length; i++) {  
                //1. if visited; 2. weight is not infinite; 3. weight is less than from start node
                if (!findedSet.contains(i) && matrix[currentMinIndex][i] != maxDis  
                        && matrix[currentMinIndex][i] + distanceMap.get(currentMinIndex) < distanceMap.get(i))  
                    distanceMap.put(i, matrix[currentMinIndex][i] + distanceMap.get(currentMinIndex));  
            }  
              
            // add into findedset  
            findedSet.add(currentMinIndex);  
        }  
    }  
  
    //print the shortest path  
    public void printDistance(){  
        Iterator<Entry<Integer, Integer>> it = distanceMap.entrySet().iterator();  
        int min = Integer.MIN_VALUE;  
        int minIndex = -1;  
        while (it.hasNext()) {  
            Entry<Integer, Integer> entry = it.next();  
            System.out.println(startIndex+"---->"+entry.getKey()+":"+entry.getValue());  
        }  
    }  
      
    // Return node who has shorted path in the unvisited set
    private int currentMinIndex() {  
        Iterator<Entry<Integer, Integer>> it = distanceMap.entrySet().iterator();  
        int min = Integer.MAX_VALUE;  
        int minIndex = -1;  
        while (it.hasNext()) {  
            Entry<Integer, Integer> entry = it.next();  
            if (!findedSet.contains(entry.getKey()) && entry.getValue() < min) {  
                min = entry.getValue();  
                minIndex = entry.getKey();  
            }  
        }  
        return minIndex;  
    }  
}