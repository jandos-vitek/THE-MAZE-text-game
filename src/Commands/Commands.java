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

    public Commands(MapOfRooms m, Player p, Enemy e) {
        this.map = m;
        this.player = p;
        this.enemy = e;
        initialize();
    }

    /**
     * This creates and adds all the commands to HashMap
     */
    public void initialize() {
        commands.put("jdi sever", new MoveNorth(map));
        commands.put("jdi jih", new MoveSouth(map));
        commands.put("jdi vychod", new MoveEast(map));
        commands.put("jdi zapad", new MoveWest(map));
        commands.put("konec", new Exit());
        commands.put("pomoc", new Help());
        commands.put("ne", new No(player));
        commands.put("ano", new Yes(player));
        commands.put("a", new OptionA(player));
        commands.put("b", new OptionB(player));
        commands.put("c", new OptionC(player));
        commands.put("utok", new Attack(enemy, player));
        commands.put("kouzlo", new UsingSpell(enemy, player));
        commands.put("leceni", new Healing(player, enemy));
        commands.put("vybava", new ShowStats(player));
    }

    /**
     * You write a command, then it finds out if the command exist and is possible to use right now
     * If it exists and you can use it, it starts the execute() method in the command
     * If the command starts with jdi it will set boolean  didPlayerMove to true
     * It sets the boolean exit based on what a given's commands end() method returns
     * If the given command doesn't exist or cannot be used it starts the method repeats itself
     */
    public void executing() {
        System.out.println(">>");
        String command = sc.nextLine().toLowerCase();
        if (commands.containsKey(command)) {
            if (command.startsWith("jdi") || command.equals("konec") || command.equals("pomoc")
                    || command.equals("vybava") || command.equals("leceni")) {
                if (command.startsWith("jdi")) {
                    didPlayerMove = true;
                } else {
                    didPlayerMove = false;
                }
                System.out.println(commands.get(command).execute());
                exit = commands.get(command).end();
            } else {
                System.out.println("tento prikaz ted nemuzes pouzit, zadej ho znovu");
                executing();
            }
        } else {
            System.out.println("tenhle prikaz neexistuje");
            executing();
        }
    }

    public boolean exit() {
        return exit;
    }

    public boolean didPlayerMove() {
        return didPlayerMove;
    }
    /**
     * You write a command, then it finds out if the command exist and is possible to use right now
     * If it exists and you can use it, it starts the execute() method in the command
     * It sets the boolean exit based on what a given's commands end() method returns
     * If the given command doesn't exist or cannot be used it starts the method repeats itself
     */
    public void choosingOptions() {
        System.out.println(">>");
        String command = sc.nextLine().toLowerCase();
        if (commands.containsKey(command)) {
            if (command.equals("a") || command.equals("b") || command.equals("c") || command.equalsIgnoreCase("konec") || command.equalsIgnoreCase("pomoc")) {
                System.out.println(commands.get(command).execute());
                exit = commands.get(command).end();
            } else {
                System.out.println("tento prikaz ted nemuzes pouzit, zadej ho znovu");
                choosingOptions();
            }
        } else {
            System.out.println("tenhle prikaz neexistuje, zadej ho znovu");
            choosingOptions();
        }
    }

    /**
     * You write a command, then it finds out if the command exist and is possible to use right now
     * If it exists and you can use it, it starts the execute() method in the command
     * It sets the boolean exit based on what a given's commands end() method returns
     * If the given command doesn't exist or cannot be used it starts the method repeats itself
     */
    public void agreeing() {
        System.out.println(">>");
        String command = sc.nextLine().toLowerCase();
        if (commands.containsKey(command)) {
            if (command.equals("ano") || command.equals("ne") || command.equalsIgnoreCase("konec") || command.equalsIgnoreCase("pomoc")) {
                System.out.println(commands.get(command).execute());
                exit = commands.get(command).end();
            } else {
                System.out.println("tento prikaz ted nemuzes pouzit, zadej ho znovu");
                agreeing();
            }
        } else {
            System.out.println("tenhle prikaz neexistuje, zadej ho znovu");
            agreeing();
        }
    }

    /**
     * You write a command, then it finds out if the command exist and is possible to use right now
     * If it exists and you can use it, it starts the execute() method in the command
     * It sets the boolean exit based on what a given's commands end() method returns
     * If the given command doesn't exist or cannot be used it starts the method repeats itself
     */
    public void fighting() {
        System.out.println(">>");
        String command = sc.nextLine().toLowerCase();
        if (commands.containsKey(command)) {
            if (command.equals("utok") || command.equals("kouzlo") || command.equals("leceni")
                    || command.equals("konec") || command.equals("pomoc")|| command.equals("vybava")) {
                System.out.println(commands.get(command).execute());
                exit = commands.get(command).end();
            } else {
                System.out.println("tento prikaz ted nemuzes pouzit, zadej ho znovu");
                fighting();
            }
        } else {
            System.out.println("tenhle prikaz neexistuje, zadej ho znovu");
            fighting();
        }
    }
}
