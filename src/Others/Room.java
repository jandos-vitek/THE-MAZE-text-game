package Others;

import Entities.Entity;

public class Room {
    private boolean possibleToGoNorth;
    private boolean possibleToGoSouth;
    private boolean possibleToGoEast;
    private boolean possibleToGoWest;

    private int x;
    private int y;

    private String description;

    Entity entity;

    public Room(boolean possibleToGoNorth, boolean possibleToGoSouth, boolean possibleToGoEast, boolean possibleToGoWest,int y,int x, String description, Entity entity) {
        this.possibleToGoNorth = possibleToGoNorth;
        this.possibleToGoSouth = possibleToGoSouth;
        this.possibleToGoEast = possibleToGoEast;
        this.possibleToGoWest = possibleToGoWest;
        this.x = x;
        this.y = y;
        this.description = description;
        this.entity = entity;
    }

    public boolean isPossibleToGoNorth() {
        return possibleToGoNorth;
    }

    public void setPossibleToGoNorth(boolean possibleToGoNorth) {
        this.possibleToGoNorth = possibleToGoNorth;
    }

    public boolean isPossibleToGoSouth() {
        return possibleToGoSouth;
    }

    public void setPossibleToGoSouth(boolean possibleToGoSouth) {
        this.possibleToGoSouth = possibleToGoSouth;
    }

    public boolean isPossibleToGoEast() {
        return possibleToGoEast;
    }

    public void setPossibleToGoEast(boolean possibleToGoEast) {
        this.possibleToGoEast = possibleToGoEast;
    }

    public boolean isPossibleToGoWest() {
        return possibleToGoWest;
    }

    public void setPossibleToGoWest(boolean possibleToGoWest) {
        this.possibleToGoWest = possibleToGoWest;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public String getDescription() {
        return description;
    }
    public Entity getEntity() {
        return entity;
    }


}
