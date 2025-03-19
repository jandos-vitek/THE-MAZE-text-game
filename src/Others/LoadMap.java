package Others;

import Commands.Commands;
import Entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LoadMap {
    private Room [][] loadingMap=new Room [5][5];
    Room r;
    Player p;

    public LoadMap(Player player) {
        this.p=player;
    }


    public  Room [][] makeMap(){
        int height=4;
        int width=0;

        try(

            BufferedReader bf= new BufferedReader(new FileReader("Map.txt"));
            BufferedReader bf2= new BufferedReader(new FileReader("Entities.txt"));
        ){

            String line;
            String entity;


            while((line= bf.readLine())!=null&&(entity= bf2.readLine())!=null){


                String[] entityStats=entity.split(";");
                String[] stats=line.split(";");


                TypeOfEntity typeOfEntity;
                typeOfEntity = TypeOfEntity.valueOf(entityStats[0]);
                TypeOfKey typeOfKey;
                ContentsOfChest contentsOfChest;



                    switch (typeOfEntity) {
                        case KEY -> {
                            typeOfKey = TypeOfKey.valueOf(entityStats[1]);
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6], new Key(typeOfKey,p));
                        }
                        case CHEST -> {
                            contentsOfChest = ContentsOfChest.valueOf(entityStats[1]);
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],new Chest(contentsOfChest,p));
                        }
                        case HEALINGWELL ->
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],new HealingWell(p));

                        case ENEMY ->
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],
                                    new Enemy(Integer.parseInt(entityStats[1]),Integer.parseInt(entityStats[2]),Integer.parseInt(entityStats[3]),Boolean.parseBoolean(entityStats[4]),Boolean.parseBoolean(entityStats[5]),entityStats[6],p));

                        case NPC ->
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],new NPC(p));

                        case TRADER ->
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],new Trader(p));
                        case PUZZLE ->
                                r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                        Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],
                                        new Puzzle(p));
                        case NONE ->
                                r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                        Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],null);
                        default -> System.out.println("neco spatne s textovym souborem");

                    }
               loadingMap[height][width]=r;
               width++;
                if (width == 5) {
                    width = 0;
                    height--;
                }
            }


        }
        catch (IOException e){
            System.out.println("posralo se to");
        }

        return loadingMap;
    }

    public Player getP() {
        return p;
    }
}
