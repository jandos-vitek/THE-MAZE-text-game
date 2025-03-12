package Others;

import Commands.Commands;


public class Game {
    Player player = new Player(100, 10, 0, 3, false, false, false,30);
    MapOfRooms mapOfRooms = new MapOfRooms(3, 1, player);
    Commands commands = new Commands(mapOfRooms, player,null);

    public Game() {
    }

    public String playGame() {
        System.out.println("nachazite se na souradnicich y=" + mapOfRooms.getY() + "x=" + mapOfRooms.getX());
        while (!commands.exit() || player.getHealth() <= 0) {
            commands.executing();

            if (commands.didPlayerMove()) {
                Room room = mapOfRooms.getMap()[mapOfRooms.getY()][mapOfRooms.getX()];
                if (room.getEntity() != null) {
                    room.getEntity().play();
                }
                System.out.println(mapOfRooms.getPlayer().showStats());
                mapOfRooms.unlockRooms();

            }
        }
        return "hra skoncila";
    }
}
