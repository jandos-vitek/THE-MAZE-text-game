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

    public Room(boolean possibleToGoNorth, boolean possibleToGoSouth, boolean possibleToGoEast, boolean possibleToGoWest, int x, int y, String description, Entity entity) {
        this.possibleToGoNorth = possibleToGoNorth;
        this.possibleToGoSouth = possibleToGoSouth;
        this.possibleToGoEast = possibleToGoEast;
        this.possibleToGoWest = possibleToGoWest;
        this.x = x;
        this.y = y;
        this.description = description;
        this.entity = entity;
    }
}
