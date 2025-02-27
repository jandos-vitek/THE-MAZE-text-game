package Commands.Movement;

import Commands.Command;
import Others.MapOfRooms;
import Others.Room;

public class MoveWest implements Command {
    MapOfRooms map;

    public MoveWest(MapOfRooms m) {
        this.map = m;
    }

    @Override
    public String execute() {
        String description;
        Room r = map.getMap()[map.getY()][map.getX()];
        if(r.isPossibleToGoWest()) {
            int x= map.getX();
            map.setX(x-1);
            Room r2 = map.getMap()[map.getY()][map.getX()];
            description=r2.getDescription();
            if(r2.getEntity()!=null) {
                return "sel jis na zapad\n______________________________\n"+"nachazite se na souradnicich y="+map.getY()+"x="+map.getX()+description+"\n"+ r2.getEntity().play();
            }
        }
        else{
            return "Nejde jit na zapad";
        }
        return "Sel jsi na zapad\n______________________________\nnachazite se na souradnicich y="+map.getY()+"x="+map.getX()+description;
    }

    @Override
    public Boolean end() {
        return false;
    }
}
