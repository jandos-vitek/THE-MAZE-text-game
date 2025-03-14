package Commands.Movement;

import Commands.Command;
import Others.MapOfRooms;
import Others.Room;

public class MoveSouth implements Command {
    MapOfRooms map;

    public MoveSouth(MapOfRooms m) {
        this.map = m;
    }

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
        return "sel jis na jih\n──────────────────────────────\n"+"nachazite se na souradnicich y="+map.getY()+"x="+map.getX()+description;
    }

    @Override
    public Boolean end() {
        return false;
    }
}
