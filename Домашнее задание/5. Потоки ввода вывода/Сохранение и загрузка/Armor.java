import java.io.Serializable;

public class Armor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String armourTitle;
    private int armourDefense;

    public Armor(String armourTitle, int armourDefense) {
        this.armourTitle = armourTitle;
        this.armourDefense = armourDefense;
    }

    public void setArmourTitle(String armourTitle) {
        this.armourTitle = armourTitle;
    }

    public void setArmourDefense(int armourDefense) {
        this.armourDefense = armourDefense;
    }

    public String getArmourTitle() {
        return armourTitle;
    }

    public int getArmourDefense() {
        return armourDefense;
    }
}
