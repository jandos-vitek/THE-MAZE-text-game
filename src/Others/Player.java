package Others;

public class Player {
    private int health;
    private int damage;

    private int numberOfCoins;
    private int numberOfMushrooms;

    private boolean hasBlueKey;
    private boolean hasPurpleKey;
    private boolean hasGreenKey;

    public Player(int health, int damage, int numberOfCoins, int numberOfMushrooms, boolean hasBlueKey, boolean hasPurpleKey, boolean hasGreenKey) {
        this.health = health;
        this.damage = damage;
        this.numberOfCoins = numberOfCoins;
        this.numberOfMushrooms = numberOfMushrooms;
        this.hasBlueKey = hasBlueKey;
        this.hasPurpleKey = hasPurpleKey;
        this.hasGreenKey = hasGreenKey;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public int getNumberOfMushrooms() {
        return numberOfMushrooms;
    }

    public void setNumberOfMushrooms(int numberOfMushrooms) {
        this.numberOfMushrooms = numberOfMushrooms;
    }

    public boolean hasBlueKey() {
        return hasBlueKey;
    }

    public void setHasBlueKey(boolean hasBlueKey) {
        this.hasBlueKey = hasBlueKey;
    }

    public boolean hasPurpleKey() {
        return hasPurpleKey;
    }

    public void setHasPurpleKey(boolean hasPurpleKey) {
        this.hasPurpleKey = hasPurpleKey;
    }

    public boolean hasGreenKey() {
        return hasGreenKey;
    }

    public void setHasGreenKey(boolean hasGreenKey) {
        this.hasGreenKey = hasGreenKey;
    }

    public String showStats() {
        String keys="";
        if(hasPurpleKey) {
            keys+="fialovy klic\n";
        }
        if(hasBlueKey) {
            keys+="modry klic\n";
        }
        if(hasGreenKey) {
            keys+="zeleny klic";
        }
        return "\nPlayer\n_____________________________________" +
                "\npocet zivotu: " + health +
                "\ndamage: " + damage +
                "\npocet penez: " + numberOfCoins +
                "\npocet magickych houbicek: " + numberOfMushrooms +
                "\nklice: "+keys;


    }
}
