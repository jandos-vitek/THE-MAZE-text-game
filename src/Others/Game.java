package Others;

import Commands.Commands;
import Entities.Enemy;


public class Game {
    Player player = new Player(100, 10, 0, 3, false, false, false, 30);
    MapOfRooms mapOfRooms = new MapOfRooms(3, 1, player);
    Commands commands = new Commands(mapOfRooms, player, null);

    public Game() {
    }

    public String playGame() {
        System.out.println("nachazite se na souradnicich y=" + mapOfRooms.getY() + "x=" + mapOfRooms.getX());
        while (!commands.exit() && player.getHealth() >= 0) {
            Room room1 = mapOfRooms.getMap()[mapOfRooms.getY()][mapOfRooms.getX()];
            commands.executing();
            if (commands.didPlayerMove()) {
                Room room2 = mapOfRooms.getMap()[mapOfRooms.getY()][mapOfRooms.getX()];
                if (room2.getEntity()!= null) {
                    if (room2.getEntity() instanceof Enemy && room2 != room1) {
                        System.out.println(((Enemy) room2.getEntity()).getDescription());
                    }
                    System.out.println(room2.getEntity().play());
                }
                mapOfRooms.unlockRooms();

            }
        }
        return "hra skoncila";
    }
}
