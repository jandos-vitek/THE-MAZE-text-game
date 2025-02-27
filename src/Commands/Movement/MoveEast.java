package Commands.Movement;

import Commands.Command;
import Others.MapOfRooms;
import Others.Room;

public class MoveEast  implements Command {
    MapOfRooms map;

    public MoveEast(MapOfRooms m) {
        this.map = m;
    }

    @Override
    public String execute() {
        String description;
        Room r = map.getMap()[map.getY()][map.getX()];
        if(r.isPossibleToGoEast()) {
            int x= map.getX();
            map.setX(x+1);
            Room r2 = map.getMap()[map.getY()][map.getX()];
            description=r2.getDescription();
            if(r2.getEntity()!=null) {
                return "sel jis na vychod\n______________________________\n"+"nachazite se na souradnicich y="+map.getY()+"x="+map.getX()+description+"\n"+ r2.getEntity().play();
            }
        }
        else{
            return "nejde jit na vychod";
        }
        return "sel jis na vychod\n______________________________\n"+"nachazite se na souradnicich y="+map.getY()+"x="+map.getX()+description;
    }

    @Override
    public Boolean end() {
        Room r = map.getMap()[map.getY()][map.getX()];
        if(r==map.getMap()[4][0]&& r.isPossibleToGoEast()){
            System.out.println("Utelk jsi z bludiste");
            return true;
        }
        return false;
    }
}
