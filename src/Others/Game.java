package Others;

import Commands.Commands;


public class Game {
    MapOfRooms mapOfRooms= new MapOfRooms(3,1);
    Commands commands = new Commands(mapOfRooms);

    public Game() {
    }

    public String playGame() {
        System.out.println("nachazite se na souradnicich y="+mapOfRooms.getY()+"x="+mapOfRooms.getX());
        commands.initialize();
        while(!commands.exit()) {
            commands.executing();
            System.out.println( mapOfRooms.getPlayer().showStats());
            mapOfRooms.unlockRooms();

        }
        return "hra skoncila";
    }

}
