package Commands;

import Commands.Movement.MoveEast;
import Commands.Movement.MoveNorth;
import Commands.Movement.MoveSouth;
import Commands.Movement.MoveWest;
import Commands.Options.OptionA;
import Commands.Options.OptionB;
import Commands.Options.OptionC;
import Others.MapOfRooms;
import Others.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Commands {
    MapOfRooms map;
    HashMap<String, Command> commands = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Player player;
    private boolean exit = false;
    private boolean didPlayerMove;

    public Commands(MapOfRooms m, Player p) {
        this.map = m;
        this.player =p;
        initialize();
    }

    public void initialize() {
        commands.put("jdi sever", new MoveNorth(map));
        commands.put("jdi jih", new MoveSouth(map));
        commands.put("jdi vychod", new MoveEast(map));
        commands.put("jdi zapad", new MoveWest(map));
        commands.put("konec", new Exit());
        commands.put("Ne",new No(player));
        commands.put("Ano",new Yes(player));
        commands.put("A",new OptionA(player));
        commands.put("B",new OptionB(player));
        commands.put("C",new OptionC(player));
    }

    public void executing() {
        String command = sc.nextLine();
        if (commands.containsKey(command)) {
            if(command.startsWith("jdi")){
                didPlayerMove=true;
            }else {
                didPlayerMove=false;
            }
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).end();
        } else {
            System.out.println("tenhle prikaz neexistuje");
        }
    }

    public boolean exit() {
        return exit;
    }

    public boolean didPlayerMove() {
        return didPlayerMove;
    }
}
