import java.io.Serializable;

public class Hero implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String name;
    private int lvl;
    Weapon weapon;
    Armor armor;

    public Hero(String name, Weapon weapon, Armor armor) {
        this.name = name;
        this.lvl = 1;
        this.weapon = weapon;
        this.armor = armor;
    }

    public void showInformation(){
        System.out.println("Name: " + name);
        System.out.println("Level: " + lvl);
        System.out.println("Weapon " + weapon.getSwordTitle());
        System.out.println("Damage " + weapon.getSwordDamage());
        System.out.println("Armour " + armor.getArmourTitle());
        System.out.println("Defense " + armor.getArmourDefense());
    }
}
