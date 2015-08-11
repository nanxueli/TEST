/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstralab;

/**
 *
 * @author yangnan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static final int minDis = 0;  
    private static final int maxDis = Integer.MAX_VALUE; 
    
    public static void main(String[] args) {  
        int[][] inputMatrix = new int[][] { { minDis, 2, maxDis, 1, maxDis, maxDis, maxDis }, 
            { maxDis, minDis, maxDis, 3, 10, maxDis, maxDis },  
                { 4, maxDis, minDis, maxDis, maxDis, 5, maxDis }, { maxDis, maxDis, 2, minDis, 2, 8, 4 },  
                { maxDis, maxDis, maxDis, maxDis, minDis, maxDis, 6 }, { maxDis, maxDis, maxDis, maxDis, maxDis, minDis, maxDis },  
                { maxDis, maxDis, maxDis, maxDis, maxDis, 1, minDis } };  
        Dijkstra path = new Dijkstra(inputMatrix, 0);  
        path.find();  
        path.printDistance();  
  
    }  
    
}
