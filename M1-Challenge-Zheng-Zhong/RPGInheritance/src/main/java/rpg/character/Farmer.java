package rpg.character;

public class Farmer extends Commoner {
    private boolean plowing;
    private boolean harvesting;

    public Farmer( String name ) {
        this.setName(name);
        this.setStrength(75);
        this.setHealth(100);
        this.setStamina(75);
        this.setSpeed(10);
        this.setAttackPower(1);
        this.setRunning(false);
        this.setArrested(false);
        this.setPlowing(false);
        this.setHarvesting(false);
    }

    public boolean isPlowing() {
        return plowing;
    }

    public void setPlowing(boolean plowing) {
        this.plowing = plowing;
    }

    public boolean isHarvesting() {
        return harvesting;
    }

    public void setHarvesting(boolean harvesting) {
        this.harvesting = harvesting;
    }

    @Override
    // Attack other character, return their health after received damage.
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
