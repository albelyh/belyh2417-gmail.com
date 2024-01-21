





import java.util.Scanner;

public class lesson20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Penguin penguin = new Penguin();
        penguin.currentDirection = "";
        int input = 0;
        while(input != 5){
            System.out.println("""
                1. Введите начальную позицию пингвина
                
                2. Повернуть по часовой
                                
                3. Повернуть против часовой
                                
                4. Сделать ход
                                
                5. Выход
                """);
            input = scan.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("Введите penRow");
                    penguin.penRow = scan.nextInt();
                    System.out.println("Введите penColumn");
                    penguin.penColumn = scan.nextInt();

                    penguin.init();
                }
                case 2 -> penguin.turnRight();
                case 3 -> penguin.turnLeft();
                case 4 -> {

                    System.out.println("Введите, куда бы вы хотели пойти (UP, DOWN, LEFT, RIGHT)");
                    penguin.currentDirection = scan.next();
                    penguin.goForward();
                    penguin.printInfo ();
                }
                case 5 -> System.out.println("Выход");
            }

        }
    }
}

class Penguin {

    /**
     * Игровая карта (массив 10 на 10)
     */
    String[][] matrix = new String[10][10];
    /**
     * Константы - возможные направления движения пингвина
     */
    final String UP = "UP";
    final String RIGHT = "RIGHT";
    final String LEFT = "LEFT";
    final String DOWN = "DOWN";
    /**
     * Начальное (дефолтное) направление движения пингвина
     */
    String currentDirection = DOWN;
    /**
     * Иконка пингвина
     */
    final String PENGUIN = "|P|";
    /**
     * Инока пустой клетки
     */
    final String EMPTY = "|_|";
    /**
     * Текущие координаты пингвина: индекс строки
     */
    int penRow;
    /**
     * Текущие координаты пингвина: индекс столбца
     */
    int penColumn;
    /**
     * Заполняет игровой массив пустыми клетками и распологает пингвина в начальных координатах penRow и penColumn
     */
    void init() {
        if (isCellAvailableForStep(penRow, penColumn)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = EMPTY;// присваиваем элементам массива значение EMPTY
                    placePenguin();// размещаем пингвина на стартовой позиции


                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("Вы вышли за границы массива");
            System.out.println();
        }
    }

    /**
     * Опредлеляет направление пингвина, проверяет, что клетка в выбранном направлении доступна (что она не выходит за пределы массива).
     * Если клетка доступна, перемещает пингвина в направлении currentDirection.
     */
    public void goForward() {
        //TODO тут нужно использовать makeStep для уменьшения дублированного кода
        if (currentDirection.equals(UP)) {
            penRow--;
        } else if (currentDirection.equals(LEFT)) {
            penColumn--;
        } else if (currentDirection.equals(RIGHT)) {
            penColumn++;
        } else if (currentDirection.equals(DOWN)) {
            penRow++;
        }
        if (isCellAvailableForStep(penRow, penColumn)) {
            makeStep(penRow, penColumn);
        } else {
            System.out.println("Вы вышли за пределы массива");
        }
    }

    /**
     * Выполняет непосредственное перемещение пингвина.
     * Проверяет доступность новой клетки, стирает иконку пингвина из старой клетки, меняет координаты пингвина
     * на координаты новой клетки и перемещает пингвина в новую клетку.
     *
     * @param nextRow индекс строки новой клетки
     * @param nextCol индекс столбца новой клетки
     */
    public void makeStep(int nextRow, int nextCol) {
            clearCurrentCell(); // очищаем текущую позицию пингвина
            matrix[nextRow][nextCol] = PENGUIN; // размещаем пингвина на новой позиции

    }

    /**
     * Проверяет клетку с координатами row, col на признак существования в массиве.
     *
     * @param row индекс строки
     * @param col индекс столбца
     * @return true, если клетка есть в массиве
     */
    public boolean isCellAvailableForStep(int row, int col) {

        if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length){
            return true;
        }
        return false;
    }

    /**
     * Очищает текущую позицию пингвина, присваивая на место координат penRow, penColumn ячейку EMPTY
     */
    public void clearCurrentCell() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = EMPTY;// присваиваем элементам массива значение EMPTY
            }
        }
    }

    /**
     * Размещает иконку пингвина под координатами penRow, penColumn
     */
    public void placePenguin() {

        matrix[penRow][penColumn] = PENGUIN;

    }
    /**
     * Поворот пингвина по часовой стрелке.
     * Если текущее направление "up", тогда после turnRight будет "right"
     * Примеры других направлений:
     * right -> down
     * down -> left
     * left -> up
     */
    public void turnRight() {
        switch (currentDirection) {
            case "UP" -> currentDirection = "RIGHT";
            case "RIGHT" -> currentDirection = "DOWN";
            case "DOWN" -> currentDirection = "LEFT";
            case "LEFT" -> currentDirection = "UP";
        }
    }

    /**
     * Поворот пингвина против часовой стрелке.
     * Если текущее направление "up", тогда после turnLeft будет "left"
     * Примеры других направлений:
     * left -> down
     * down -> right
     * right -> up
     */
    public void turnLeft() {
        switch (currentDirection) {
            case "UP" -> currentDirection = "LEFT";
            case "LEFT" -> currentDirection = "DOWN";
            case "DOWN" -> currentDirection = "RIGHT";
            case "RIGHT" -> currentDirection = "UP";
        }
    }
    public void printInfo () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
