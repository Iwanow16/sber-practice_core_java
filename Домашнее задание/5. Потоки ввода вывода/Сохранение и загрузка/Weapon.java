import java.io.Serializable;

public class Weapon implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String swordTitle;
    private int swordDamage;

    public Weapon(String swordTitle, int swordDamage) {
        this.swordTitle = swordTitle;
        this.swordDamage = swordDamage;
    }

    // Переименование меча
    public void setSwordTitle(String swordTitle) {
        this.swordTitle = swordTitle;
    }
    // Заточка или затупление меча
    public void setSwordDamage(int swordDamage) {
        this.swordDamage = swordDamage;
    }
    // Получение имени меча
    public String getSwordTitle() {
        return swordTitle;
    }
    // Получение урона меча
    public int getSwordDamage() {
        return swordDamage;
    }
}
