package Entities;

public class Chest extends Entity{
    private ContentsOfChest contentsOfChest;

    public Chest(ContentsOfChest contentsOfChest) {
        this.contentsOfChest = contentsOfChest;
    }

    public ContentsOfChest getContentsOfChest() {
        return contentsOfChest;
    }

    public void setContentsOfChest(ContentsOfChest contentsOfChest) {
        this.contentsOfChest = contentsOfChest;
    }

    @Override
    public String play() {
        return "";
    }
}
