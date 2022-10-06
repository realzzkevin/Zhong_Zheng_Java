package rpg.character;

public class Constable extends Commoner{
    private String jurisdiction;

    public Constable(String name) {
        this.setName(name);
        this.setStrength(60);
        this.setHealth(100);
        this.setStamina(60);
        this.setSpeed(20);
        this.setAttackPower(5);
        this.setRunning(false);
        this.setArrested(false);
        this.jurisdiction = "Kingdom of far far away";
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void arrest(Commoner comm) {
        comm.setArrested(true);
        comm.setAttackPower(0);
        System.out.println("By the king of "+ jurisdiction + " You're under arrest, "+ comm.getName() +"! Resistance is futile.");
    }

    public int attack(Commoner commoner) {
        System.out.println(this.getName()+" Attacked " + commoner.getName());
        if(commoner.getClass() == Warrior.class) {
            int shield = (((Warrior) commoner).getShieldStrength());
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
