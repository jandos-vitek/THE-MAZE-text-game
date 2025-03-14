package Commands.Movement;

import Commands.Command;
import Others.MapOfRooms;
import Others.Room;

public class MoveWest implements Command {
    MapOfRooms map;
    private boolean didPlayerMove;

    public MoveWest(MapOfRooms m) {
        this.map = m;
    }

    @Override
    public String execute() {
        String description;
        Room r = map.getMap()[map.getY()][map.getX()];
        if(r.isPossibleToGoWest()) {
            didPlayerMove = true;
            int x= map.getX();
            map.setX(x-1);
            Room r2 = map.getMap()[map.getY()][map.getX()];
            description=r2.getDescription();
            }
        else{
            didPlayerMove = false;
            return "Nejde jit na zapad\n──────────────────────────────";
        }
        return "Sel jsi na zapad\n──────────────────────────────\nnachazite se na souradnicich y="+map.getY()+"x="+map.getX()+description;
    }

    @Override
    public Boolean end() {
        return false;
    }
    public boolean didPlayerMove() {
        return didPlayerMove;
    }
}
