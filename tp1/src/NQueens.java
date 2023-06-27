import java.util.ArrayList;
import java.util.List;

public class NQueens {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>(); // Lista para almacenar las soluciones encontradas

        char[][] board = new char[n][n]; // Tablero de ajedrez representado como una matriz de caracteres

        initializeBoard(board, n); // Inicializar el tablero con '.'

        backtrack(board, 0, solutions); // Llamada inicial al método de backtracking

        return solutions; // Devolver la lista de soluciones
    }
    
    private void initializeBoard(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {

                board[i][j] = '.'; // Inicializar todas las celdas del tablero con '.'

            }
        }
    }
    
    private void backtrack(char[][] board, int row, List<List<String>> solutions) {
        if (row == board.length) { // Condición de terminación: se ha colocado una reina en cada fila

            solutions.add(constructSolution(board)); // Se agrega la solución encontrada a la lista de soluciones

        }
        
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) { // Verificar si es seguro colocar una reina en la posición actual
                board[row][col] = 'Q'; // Marcar la posición con una reina ('Q')
                backtrack(board, row + 1, solutions); // Llamada recursiva para colocar la reina en la siguiente fila
                board[row][col] = '.'; // Deshacer la elección (backtrack) y desmarcar la posición
            }
        }
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        
        // Verificar la columna
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') { // Si ya hay una reina en la misma columna, no es seguro colocar otra aquí
                return false;
            }
        }
        
        // Verificar la diagonal principal hacia arriba
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') { // Si ya hay una reina en la misma diagonal principal, no es seguro colocar otra aquí
                return false;
            }
        }
        
        // Verificar la diagonal secundaria hacia arriba
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') { // Si ya hay una reina en la misma diagonal secundaria, no es seguro colocar otra aquí
                return false;
            }
        }
        
        return true; // Si no se viola ninguna restricción, la posición es válida para colocar una reina
    }
    
    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(new String(board[i])); // Convertir cada fila del tablero en una cadena y agregarla a la solución
        }
        return solution;
    }

    //pseudocodigo

    función solveNQueens(n):
    solutions = lista de listas de cadenas
    
    // Crear un tablero de ajedrez vacío
    tablero = matriz de caracteres de tamaño n x n
    inicializarTablero(tablero, n)
    
    // Llamar a la función de backtracking
    backtrack(tablero, 0, solutions)
    
    retornar solutions

función inicializarTablero(tablero, n):
    para cada fila i de 0 a n-1:
        para cada columna j de 0 a n-1:
            tablero[i][j] = '.'
            
función backtrack(tablero, fila, solutions):
    si fila es igual a longitud de tablero:
        agregar solución construirSolucion(tablero) a solutions
        retornar
    
    para cada columna de 0 a longitud de tablero - 1:
        si esSeguro(tablero, fila, columna):
            tablero[fila][columna] = 'Q'
            backtrack(tablero, fila + 1, solutions)
            tablero[fila][columna] = '.'

función esSeguro(tablero, fila, columna):
    n = longitud de tablero
    
    // Verificar la columna
    para cada fila i de 0 a fila - 1:
        si tablero[i][columna] es igual a 'Q':
            retornar falso
    
    // Verificar la diagonal principal hacia arriba
    para cada i, j desde fila-1 hasta 0, columna-1 hasta 0:
        si tablero[i][j] es igual a 'Q':
            retornar falso
    
    // Verificar la diagonal secundaria hacia arriba
    para cada i, j desde fila-1 hasta 0, columna+1 hasta n-1:
        si tablero[i][j] es igual a 'Q':
            retornar falso
    
    retornar verdadero

función construirSolucion(tablero):
    solucion = lista de cadenas
    para cada fila en tablero:
        agregar fila convertida a cadena a solucion
    retornar solucion

}
