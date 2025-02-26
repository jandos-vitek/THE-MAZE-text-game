package Commands;

import Commands.Movement.MoveEast;
import Commands.Movement.MoveNorth;
import Commands.Movement.MoveSouth;
import Commands.Movement.MoveWest;
import Others.MapOfRooms;

import java.util.HashMap;
import java.util.Scanner;

public class Commands {
    MapOfRooms map;
    HashMap<String, Command> commands = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    private boolean exit = false;

    public Commands(MapOfRooms m) {
        this.map = m;
    }

    public void initialize() {
        commands.put("jdi sever", new MoveNorth(map));
        commands.put("jdi jih", new MoveSouth(map));
        commands.put("jdi vychod", new MoveEast(map));
        commands.put("jdi zapad", new MoveWest(map));
        commands.put("konec", new Exit());
    }

    public void executing() {
        String command = sc.nextLine();
        if (commands.containsKey(command)) {
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).end();
        } else {
            System.out.println("tenhle prikaz neexistuje");
        }
    }

    public boolean exit() {
        return exit;
    }
}
