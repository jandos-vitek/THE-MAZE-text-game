package Others;



import java.util.ArrayList;

public class MapOfRooms {
    private Player player=new Player(3,0,0,0,false,false,false);
    LoadMap loadMap= new LoadMap(player);
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

    public Player getPlayer() {
        return player;
    }
    public void unlockRooms(){
        if(player.hasPurpleKey()) {
            Room room = map[0][1];
            Room room2 =map[1][1];
            room.setPossibleToGoSouth(true);
            room2.setPossibleToGoNorth(true);
        }
        if(player.hasBlueKey()) {
            Room room = map[0][4];
            room.setPossibleToGoEast(true);
        }
        if(player.hasGreenKey()) {
            Room room = map[4][2];
            Room room2 =map[4][3];
            room.setPossibleToGoEast(true);
            room2.setPossibleToGoWest(true);

        }

    }
}
