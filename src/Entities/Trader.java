package Entities;

import Commands.Commands;
import Others.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Trader extends Entity{
    Player player;
    Commands commands;
    ArrayList<String>speech;

    public Trader(Player p) {
        this.player = p;
        commands= new Commands(null,player,null);
        speech=new ArrayList<>();
    }

    @Override
    public String play() {
        String line;
        try(
                BufferedReader br=new BufferedReader(new FileReader("TraderSpeech"))
                ){
            while ((line= br.readLine())!=null){
                speech.add(line);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("soubor nenalezen");
        }
        catch (IOException e){
            System.out.println("chyba pri cteni");
        }
        System.out.println(speech.get(0));
        commands.agreeing();
        if(player.agree()) {
            System.out.println(speech.get(2));
            System.out.println(speech.get(3));
            System.out.println(speech.get(4));
            System.out.println(speech.get(5));
            commands.choosingOptions();
            switch (player.getChoise()) {
                case 'a':
                    System.out.println(speech.get(6));
                    System.out.println(speech.get(7));
                    System.out.println(speech.get(8));
                    System.out.println(speech.get(9));
                    commands.choosingOptions();
                    switch (player.getChoise()){
                        case 'a': {
                            return choosingWeapon(25, 2);
                        }
                        case 'b': {
                            return choosingWeapon(30, 3);
                        }
                        case 'c':
                           return choosingWeapon(35, 4);

                    }
                    break;
                case 'b':
                    System.out.println(speech.get(10));
                    System.out.println(speech.get(12));
                    commands.agreeing();
                    if(player.agree()){
                        if(player.getNumberOfCoins()>=1) {
                            player.setNumberOfMushrooms(player.getNumberOfMushrooms() + 1);
                            player.setNumberOfCoins(player.getNumberOfCoins() - 1);
                        }else {
                           return speech.get(15);
                        }
                        return speech.get(13);
                    }
                    else {
                        return speech.get(14);
                    }

                case 'c':
                    System.out.println(speech.get(11));
                    System.out.println(speech.get(12));
                    commands.agreeing();
                    if(player.agree()){
                        if(player.getNumberOfCoins()>=4) {
                            player.setLuck(player.getluck()*2);
                            player.setNumberOfCoins(player.getNumberOfCoins() - 4);
                        }else {
                            return speech.get(15);
                        }
                        return speech.get(13);
                    }
                    else {
                        return speech.get(14);
                    }
            }
        }
           return speech.get(1);
    }

    public String choosingWeapon(int damage, int price){
        System.out.println(speech.get(12));
        commands.agreeing();
        if(player.agree()){
            if (player.getDamage() < damage) {
                if(player.getNumberOfCoins()>=price){
                    player.setDamage(damage);
                    player.setNumberOfCoins(player.getNumberOfCoins()-price);
                }
                else {
                    return speech.get(15);
                }
            }
            else {
                return "Tuhle zbran uz mas";
            }
        }
        else {
            return speech.get(14);
        }
        return speech.get(13);
    }
}
