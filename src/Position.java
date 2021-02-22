public class Position {

    public int x, y, alpha;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAlpha() {
        return alpha;
    }

    public Position(int x, int y, int alpha) {
        this.x = x;
        this.y = y;
        this.alpha = alpha;
    }

}
