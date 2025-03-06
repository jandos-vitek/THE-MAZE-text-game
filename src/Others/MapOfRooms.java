package Others;



import Commands.Commands;

import java.util.ArrayList;

public class MapOfRooms {
    public MapOfRooms(int y,int x,Player p) {
        this.x = x;
        this.y = y;
        this.player=p;
        loadMap= new LoadMap(player);
        map= loadMap.makeMap();
    }

    private Player player;
    LoadMap loadMap;
    Commands c;
    private Room [][] map;
    private int x;
    private int y;




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
