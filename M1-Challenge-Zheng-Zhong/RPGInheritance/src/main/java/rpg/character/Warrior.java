package rpg.character;

public class Warrior extends Commoner{
    private int shieldStrength;
    public Warrior (String name) {
        this.setName(name);
        this.setStrength(75);
        this.setHealth(100);
        this.setStamina(100);
        this.setSpeed(50);
        this.setAttackPower(10);
        this.setShieldStrength(100);
        this.setRunning(false);
        this.setArrested(false);
    }
    public int getShieldStrength () {
        return this.shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    @Override
    public int attack(Commoner commoner) {
        System.out.println(this.getName()+" Attacked " + commoner.getName());
        if(commoner.getClass() == Warrior.class) {
            int shield = (((Warrior) commoner).getShieldStrength());
            //if shield strength greater than 0, attack will be blocked.
            if(shield > 0) {
                System.out.println(commoner.getName()+ " blocked "+ this.getName()+ "'s attack");
                ((Warrior) commoner).setShieldStrength(shield - this.getAttackPower());
            }
            System.out.println(this.getName()+ " cause 0 damage.");
            return commoner.getHealth();
        }

        commoner.setHealth(commoner.getHealth() - this.getAttackPower());
        System.out.println(this.getName()+ " cause " + this.getAttackPower() + " damage");
        return commoner.getHealth();
    }
}
