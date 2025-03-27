package Commands.Movement;

import Commands.Command;
import Others.MapOfRooms;
import Others.Player;
import Others.Room;

public class MoveEast implements Command {
    MapOfRooms map;
    private boolean end = false;

    public MoveEast(MapOfRooms m) {
        this.map = m;
    }

    /**
     * It checks if it is possible to go east from the room where you are right now
     * And if you are on the coordinates y=0 x=4 it ends the program, because that means that you escaped
     * If yes it adds 1 to your x coordinates, that makes you move
     * @return If you moved it returns your coordinates and description of the room you just moved to
     * If you tried to move and it wasn't possible it says that you can't go east
     */
    @Override
    public String execute() {
        String description;
        Room r = map.getMap()[map.getY()][map.getX()];
        if (r.isPossibleToGoEast()) {
            if (r == map.getMap()[0][4]) {
                end = true;
                return "Utekl jsi z bludiste";
            }
            int x = map.getX();
            map.setX(x + 1);
            Room r2 = map.getMap()[map.getY()][map.getX()];
            description = r2.getDescription();
        } else {
            return "nejde jit na vychod\n──────────────────────────────";
        }
        return "sel jsi na vychod\n──────────────────────────────\n" + "nachazite se na souradnicich y="+map.getY()+" x="+map.getX()+" "+description;
    }

    @Override
    public Boolean end() {
        return end;
    }


}
