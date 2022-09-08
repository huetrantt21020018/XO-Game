public class CellStatus {
    public enum Status {
        X,
        O,
        EMPTY
    }

    private Status status;

    public CellStatus() {
        this.status = Status.EMPTY;
    }

    public void setStatus(String turn) {
        if (turn == "X") this.status = Status.X;
        if (turn == "O") this.status = Status.O;
    }

    public boolean isEmpty() {
        return (this.status == Status.EMPTY);
    }

    public boolean isX() {
        return (this.status == Status.X);
    }

    public boolean isO() {
        return (this.status == Status.O);
    }

    public boolean isEqual(CellStatus other) {
        if (this.isX() && other.isX()) return true;
        if (this.isO() && other.isO()) return true;
        return false;
    }

}