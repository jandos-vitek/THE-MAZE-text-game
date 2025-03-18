package Commands.Movement;

import Commands.Command;
import Others.MapOfRooms;
import Others.Room;


public class MoveNorth implements Command {
   MapOfRooms map;

    public MoveNorth(MapOfRooms m) {
        this.map = m;
    }

    @Override
    public String execute() {
        String description;
        Room r = map.getMap()[map.getY()][map.getX()];
        if(r.isPossibleToGoNorth()) {
            int y = map.getY();
            map.setY(y - 1);
            Room r2 = map.getMap()[map.getY()][map.getX()];
            description = r2.getDescription();
        }
        else{
            return "Nejde jit na sever\n──────────────────────────────";
        }
        return "Sel jsi na sever\n──────────────────────────────\n"+"nachazite se na souradnicich y="+map.getY()+"x="+" "+map.getX()+description;
    }

    @Override
    public Boolean end() {
        return false;
    }

}
