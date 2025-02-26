package Others;



import java.util.ArrayList;

public class MapOfRooms {
    LoadMap loadMap= new LoadMap();
    private Room [][] map= loadMap.makeMap();
    private int x;
    private int y;

    public MapOfRooms(int y,int x) {
        this.x = x;
        this.y = y;
    }


    public Room[][] getMap() {
        return map;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
