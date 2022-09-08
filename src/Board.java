public class Board {
    Cell[][] cell;
    int count = 0;

    public Board() {
        this.cell = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new Cell(i + 1, j + 1);
            }
        }
    }

    boolean chooseCell(int x, int y, String turn) {
        if (x < 1 || x > 3 || y < 1 || y > 3) return false;

        int i = x - 1, j = y - 1;
        if (cell[i][j].isValid()) {
            cell[i][j].setStatus(turn);
            count++;
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j].print();
            }
            System.out.print("\n");
        }
    }

    public CellStatus hasRow() {
        for (int i = 0; i < 3; i++) {
            if (cell[i][0].isEqual(cell[i][1]) && cell[i][1].isEqual(cell[i][2])) {
                return cell[i][0].getStatus();
            }
            if (cell[0][i].isEqual(cell[1][i]) && cell[1][i].isEqual(cell[2][i])) {
                return cell[0][i].getStatus();
            }
        }
        if (cell[0][0].isEqual(cell[1][1]) && cell[1][1].isEqual(cell[2][2])) {
            return cell[0][0].getStatus();
        }
        if (cell[2][0].isEqual(cell[1][1]) && cell[1][1].isEqual(cell[0][2])) {
            return cell[1][1].getStatus();
        }
        return new CellStatus();
    }

    public boolean isFull() {
        return (count == 9);
    }

}