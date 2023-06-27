public class Parcialejercicio2 {
    
}
a) La estrategia Greedy que se puede seguir para abordar este problema es seleccionar siempre el movimiento que nos lleve a una celda vecina con el mayor valor posible. En cada paso, elegiremos el movimiento que maximice el valor de la celda siguiente, asegurándonos de que el valor de la celda siguiente sea estrictamente mayor al valor de la celda actual. De esta manera, avanzaremos hacia las celdas con valores más altos y maximizaremos el costo total del camino.

b) A continuación se muestra un pseudo-código en Java que resuelve el problema utilizando la estrategia Greedy:
public class MaxCostPathGreedy {

   
public class MaxCostPathGreedy {

    public static void main(String[] args) {
        int[][] grid = {
            {3, 4, 2},
            {8, 1, 5},
            {7, 6, 9}
        };
        int sourceRow = 0;
        int sourceCol = 0;
        int destinationRow = 2;
        int destinationCol = 2;
        
        int maxCost = findMaxCostPath(grid, sourceRow, sourceCol, destinationRow, destinationCol);
        System.out.println("Máximo costo del camino: " + maxCost);
    }
    
    private static int findMaxCostPath(int[][] grid, int sourceRow, int sourceCol, int destinationRow, int destinationCol) {
        int maxCost = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        maxCost = findMaxCostPathHelper(grid, sourceRow, sourceCol, destinationRow, destinationCol, 0, visited);
        return maxCost;
    }
    
    private static int findMaxCostPathHelper(int[][] grid, int currentRow, int currentCol, int destinationRow, int destinationCol, int currentCost, boolean[][] visited) {
        int maxCost = 0;
        
        // Verificar si alcanzamos la celda de destino
        if (currentRow == destinationRow && currentCol == destinationCol) {
            return currentCost + grid[currentRow][currentCol];
        }
        
        // Marcar la celda actual como visitada
        visited[currentRow][currentCol] = true;
        
        // Movimiento hacia arriba
        if (currentRow > 0 && grid[currentRow][currentCol] < grid[currentRow - 1][currentCol] && !visited[currentRow - 1][currentCol]) {
            int cost = findMaxCostPathHelper(grid, currentRow - 1, currentCol, destinationRow, destinationCol, currentCost + grid[currentRow][currentCol], visited);
            maxCost = Math.max(maxCost, cost);
        }
        
        // Movimiento hacia abajo
        if (currentRow < grid.length - 1 && grid[currentRow][currentCol] < grid[currentRow + 1][currentCol] && !visited[currentRow + 1][currentCol]) {
            int cost = findMaxCostPathHelper(grid, currentRow + 1, currentCol, destinationRow, destinationCol, currentCost + grid[currentRow][currentCol], visited);
            maxCost = Math.max(maxCost, cost);
        }
        
        // Movimiento hacia la izquierda
        if (currentCol > 0 && grid[currentRow][currentCol] < grid[currentRow][currentCol - 1] && !visited[currentRow][currentCol - 1]) {
            int cost = findMaxCostPathHelper(grid, currentRow, currentCol - 1, destinationRow, destinationCol, currentCost + grid[currentRow][currentCol], visited);
            maxCost = Math.max(maxCost, cost);
        }
        
        // Movimiento hacia la derecha
        if (currentCol < grid[0].length - 1 && grid[currentRow][currentCol] < grid[currentRow][currentCol + 1] && !visited[currentRow][currentCol + 1]) {
            int cost = findMaxCostPathHelper(grid, currentRow, currentCol + 1, destinationRow, destinationCol, currentCost + grid[currentRow][currentCol], visited);
            maxCost = Math.max(maxCost, cost);
        }
        
        // Desmarcar la celda actual como visitada
        visited[currentRow][currentCol] = false;
        
        return maxCost;
    }
}

