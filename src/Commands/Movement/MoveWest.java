package Commands.Movement;

import Commands.Command;
import Others.MapOfRooms;
import Others.Room;

public class MoveWest implements Command {
    MapOfRooms map;

    public MoveWest(MapOfRooms m) {
        this.map = m;
    }
    /**
     * It checks if it is possible to go east from the room where you are right now
     * If yes it subtracts one from your x coordinates, that makes you move
     * @return If you moved it returns your coordinates and description of the room you just moved to
     * If you tried to move and it wasn't possible it says that you can't go west
     */
    @Override
    public String execute() {
        String description;
        Room r = map.getMap()[map.getY()][map.getX()];
        if(r.isPossibleToGoWest()) {
            int x= map.getX();
            map.setX(x-1);
            Room r2 = map.getMap()[map.getY()][map.getX()];
            description=r2.getDescription();
            }
        else{
            return "Nejde jit na zapad\n──────────────────────────────";
        }
        return "Sel jsi na zapad\n──────────────────────────────\nnachazite se na souradnicich y="+map.getY()+"x="+" "+map.getX()+description;
    }

    @Override
    public Boolean end() {
        return false;
    }
}
