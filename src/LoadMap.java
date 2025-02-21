import Entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class LoadMap {
    private ArrayList<Room>loadingMap= new ArrayList<>();;
    Room r;

    public LoadMap() {

    }

    public ArrayList<Room> makeMap(){
        try{
            BufferedReader bf= new BufferedReader(new FileReader("Map.txt"));
            BufferedReader bf2= new BufferedReader(new FileReader("Entities.txt"));
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
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6], new Key(typeOfKey));
                        }

                        case CHEST -> {
                            contentsOfChest = ContentsOfChest.valueOf(stats[1]);
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],new Chest(contentsOfChest));
                        }
                        case HEALINGWELL ->
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],new HealingWell());

                        case ENEMY ->
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],
                                    new Enemy(Integer.parseInt(entityStats[0]),Boolean.parseBoolean(entityStats[1]),Boolean.parseBoolean(entityStats[2]),entityStats[3]));

                        case NPC ->
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],new NPC());

                        case TRADER ->
                            r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                    Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],new Trader());
                        case PUZZLE ->
                                r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                        Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],
                                        new Puzzle(entityStats[0],entityStats[1],entityStats[2],entityStats[3],entityStats[4]));
                        case NONE ->
                                r = new Room(Boolean.parseBoolean(stats[0]), Boolean.parseBoolean(stats[1]), Boolean.parseBoolean(stats[2]), Boolean.parseBoolean(stats[3]),
                                        Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), stats[6],null);
                        default -> System.out.println("neco spatne s textovym souborem");

                    }
                    loadingMap.add(r);
            }
        }
        catch (IOException e){
            System.out.println("posralo se to");
        }
        return loadingMap;
    }
}
