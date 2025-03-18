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
        return "sel jsi na vychod\n──────────────────────────────\n" + "nachazite se na souradnicich y=" + map.getY() + "x=" + map.getX() +" "+ description;
    }

    @Override
    public Boolean end() {
        return end;
    }


}
