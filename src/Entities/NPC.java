package Entities;

import Commands.Commands;
import Others.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NPC extends Entity {
    Player player;
    Commands commands;
    ArrayList<String> speech;

    public NPC(Player p) {
        this.player = p;
        commands = new Commands(null, player, null);
        speech = new ArrayList<>();
    }

    @Override
    public String play() {
        String line;
        try (
                BufferedReader br = new BufferedReader(new FileReader("NPCDialog"))
        ) {
            while ((line = br.readLine()) != null) {
                speech.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("soubor nenalezen");
        } catch (IOException e) {
            System.out.println("chyba pri cteni");
        }
        System.out.println(speech.get(0));
        System.out.println(speech.get(1));
        System.out.println(speech.get(2));
        System.out.println(speech.get(3));
        commands.choosingOptions();
        switch (player.getChoise()) {
            case 'a': {
                return speech.get(4);
            }
            case 'b': {
                System.out.println(speech.get(5));
                commands.agreeing();
                if (player.agree()) {
                    player.setHealth(0);
                    return speech.get(7);
                }
                return speech.get(6);
            }
            case 'c': {
                System.out.println(speech.get(8));
                System.out.println(speech.get(9));
                System.out.println(speech.get(10));
                System.out.println(speech.get(11));
                commands.choosingOptions();
                switch (player.getChoise()) {
                    case 'a': {
                        System.out.println(speech.get(12));
                        System.out.println(speech.get(15));
                        System.out.println(speech.get(16));
                        System.out.println(speech.get(17));
                        commands.choosingOptions();
                        switch (player.getChoise()) {
                            case 'a':
                                System.out.println(speech.get(18));
                                commands.agreeing();
                                if (player.agree()) {
                                    if (player.getNumberOfMushrooms() > 1) {
                                        player.setNumberOfMushrooms(player.getNumberOfMushrooms()-1);
                                        return speech.get(21);
                                    }
                                    return speech.get(23);
                                }
                                return speech.get(22);
                            case 'b':
                                return speech.get(19);
                            case 'c':
                                return speech.get(20);
                        }
                    }
                    case 'b': {
                        return speech.get(13);

                    }
                    case 'c': {
                        return speech.get(14);
                    }

                }
            }
                 }
      return "";
    }
}
