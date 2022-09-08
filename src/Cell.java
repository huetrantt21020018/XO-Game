public class Cell {
    private CellStatus status;
    private int x, y;

    public Cell() {
        this.x = this.y = 0;
        this.status = new CellStatus();
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = new CellStatus();
    }

    public void setStatus(String turn) {
        status.setStatus(turn);
    }

    public boolean isValid() {
        return (status.isEmpty());
    }

    CellStatus getStatus() {
        return status;
    }

    public void print() {
        if (status.isEmpty()) System.out.print("[ ]");
        if (status.isX()) System.out.print("[X]");
        if (status.isO()) System.out.print("[O]");
    }

    public boolean isEqual(Cell other) {
        return this.status.isEqual(other.getStatus());
    }
}