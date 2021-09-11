package leetcode.hard.theskylineproblem;

public class Coordinate implements Comparable {
    int x;
    int y;
    boolean isStart;

    public Coordinate(int x, int y, boolean isStart) {
        this.x = x;
        this.y = y;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(Object o) {
        Coordinate other = (Coordinate) o;
        if (this.x != other.x) {
            return this.x - other.x;
        } else {
            // If there's both start then the building with the largest height should be examined first
            if (this.isStart && other.isStart) return -(this.y - other.y);
            // If there's both start then the building with the smallest height should be examined first
            if (!this.isStart && !other.isStart) return this.y - other.y;
            // this is the else case where either this.x is start and other.x is end or
            // this.x is end and other.x is start
            // if this is a start then is sho
            return this.isStart ? -1 : 1;
        }
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", isStart=" + isStart +
                '}';
    }
}
