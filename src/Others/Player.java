package Others;

public class Player {
    private int health;
    private int damage;
    private int luck;

    private int numberOfCoins;
    private int numberOfMushrooms;

    private boolean hasBlueKey;
    private boolean hasPurpleKey;
    private boolean hasGreenKey;

    private char choise;
    private boolean agree;

    public Player(int health, int damage, int numberOfCoins, int numberOfMushrooms, boolean hasBlueKey, boolean hasPurpleKey, boolean hasGreenKey,int luck) {
        this.health = health;
        this.damage = damage;
        this.numberOfCoins = numberOfCoins;
        this.numberOfMushrooms = numberOfMushrooms;
        this.hasBlueKey = hasBlueKey;
        this.hasPurpleKey = hasPurpleKey;
        this.hasGreenKey = hasGreenKey;
        this.luck=luck;
    }
   //region set&Get
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getluck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
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

    public void setChoise(char choise) {
        this.choise = choise;
    }

    public char getChoise() {
        return choise;
    }

    public boolean agree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }
//endregion
    public String showStats() {
        String keys = "";
        if (hasPurpleKey) {
            keys += "fialovy klic\n";
        }
        if (hasBlueKey) {
            keys += "modry klic\n";
        }
        if (hasGreenKey) {
            keys += "zeleny klic";
        }
        return "\nPlayer\n_____________________________________" +
                "\npocet zivotu: " + health +
                "\ndamage: " + damage +
                "\npocet penez: " + numberOfCoins +
                "\npocet magickych houbicek: " + numberOfMushrooms +
                "\nklice: " + keys;


    }
}
