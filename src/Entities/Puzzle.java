package Entities;

import Commands.Commands;
import Others.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Puzzle extends Entity {
    private String text;
    private String optionA;
    private String optionB;
    private String optionC;
    private char rightAnswer;
    ArrayList<String> properties;
    Player player;
    Commands commands;

    Random rd = new Random();

    public Puzzle(Player p) {
        player = p;
        commands = new Commands(null, player, null);
        properties = new ArrayList<>();
        loading();
    }

    @Override
    public String play() {
        int index = rd.nextInt(7);
        String line = properties.get(index);
        String[] puzzle = line.split(";");

        text = puzzle[0];
        optionA = puzzle[1];
        optionB = puzzle[2];
        optionC = puzzle[3];
        rightAnswer = puzzle[4].charAt(0);

        System.out.println(text);
        System.out.println(optionA);
        System.out.println(optionB);
        System.out.println(optionC);
        commands.choosingOptions();
        if (player.getChoice()==rightAnswer){
            return "odpovedel jsi spravne🎉🎉\n──────────────────────────────";
        }
        player.setHealth(player.getHealth()-15);
            return "spatna odpoved, sebralo ti to 15 zivotu\n──────────────────────────────";
    }


    public void loading() {
        String line;
        try (
                BufferedReader br = new BufferedReader(new FileReader("Puzzles"));
        ) {
            while ((line = br.readLine()) != null) {
                properties.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("soubor nenalezen");
        } catch (IOException e) {
            System.out.println("chyba pri cteni");
        }
    }
}
