package Commands.Movement;

import Commands.Command;
import Others.MapOfRooms;
import Others.Room;

public class MoveSouth implements Command {
    MapOfRooms map;

    public MoveSouth(MapOfRooms m) {
        this.map = m;
    }
    /**
     * It checks if it is possible to go east from the room where you are right now
     * If yes adds 1 to your y coordinates, that makes you move
     * @return If you moved it returns your coordinates and description of the room you just moved to
     * If you tried to move and it wasn't possible it says that you can't go south
     */
    @Override
    public String execute() {
        String description;
        Room r = map.getMap()[map.getY()][map.getX()];
        if(r.isPossibleToGoSouth()) {
            int y= map.getY();
            map.setY(y+1);
            Room r2 = map.getMap()[map.getY()][map.getX()];
            description=r2.getDescription();
            }
        else{
            return "Nejde jit na jih\n──────────────────────────────";
        }
        return "sel jsi na jih\n──────────────────────────────\n"+"nachazite se na souradnicich y="+map.getY()+"x="+" "+map.getX()+description;
    }

    @Override
    public Boolean end() {
        return false;
    }
}
