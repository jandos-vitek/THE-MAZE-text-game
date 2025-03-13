package Commands;

import Commands.Agreeing.No;
import Commands.Agreeing.Yes;
import Commands.Fighting.Attack;
import Commands.Fighting.Healing;
import Commands.Fighting.UsingSpell;
import Commands.Movement.MoveEast;
import Commands.Movement.MoveNorth;
import Commands.Movement.MoveSouth;
import Commands.Movement.MoveWest;
import Commands.Options.OptionA;
import Commands.Options.OptionB;
import Commands.Options.OptionC;
import Entities.Enemy;
import Others.MapOfRooms;
import Others.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Commands {
    MapOfRooms map;
    HashMap<String, Command> commands = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Player player;
    Enemy enemy;
    private boolean exit = false;
    private boolean didPlayerMove;

    public Commands(MapOfRooms m, Player p,Enemy e) {
        this.map = m;
        this.player =p;
        this.enemy=e;
        initialize();
    }

    public void initialize() {
        commands.put("jdi sever", new MoveNorth(map));
        commands.put("jdi jih", new MoveSouth(map));
        commands.put("jdi vychod", new MoveEast(map));
        commands.put("jdi zapad", new MoveWest(map));
        commands.put("konec", new Exit());
        commands.put("pomoc", new Help());
        commands.put("ne",new No(player));
        commands.put("ano",new Yes(player));
        commands.put("A",new OptionA(player));
        commands.put("B",new OptionB(player));
        commands.put("C",new OptionC(player));
        commands.put("utok",new Attack(enemy,player));
        commands.put("kouzlo",new UsingSpell(enemy,player));
        commands.put("leceni",new Healing(enemy,player));
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

    public void choosingOptions() {
        String command = sc.nextLine();
        if (commands.containsKey(command)&&(command.equalsIgnoreCase("a")||command.equalsIgnoreCase("b")||command.equalsIgnoreCase("c"))) {
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).end();
        } else {
            System.out.println("tenhle prikaz neexistuje");
        }
    }




    public void agreeing() {
        String command = sc.nextLine().toLowerCase();
        if (commands.containsKey(command)&&(command.equals("ano")||command.equals("ne"))) {
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).end();
        } else {
            System.out.println("tady je problem");
        }
    }





    public void fighting() {
        String command = sc.nextLine();
        if (commands.containsKey(command)&&(command.equalsIgnoreCase("utok")||command.equalsIgnoreCase("kouzlo")||command.equalsIgnoreCase("leceni"))) {
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).end();
        } else {
            System.out.println("tenhle prikaz neexistuje");
        }
    }
}
