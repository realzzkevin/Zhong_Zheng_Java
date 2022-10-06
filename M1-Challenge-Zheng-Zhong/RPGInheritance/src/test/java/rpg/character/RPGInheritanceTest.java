package rpg.character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RPGInheritanceTest {

    private Farmer farmer;
    private Warrior warrior;
    private Constable constable;
    @Before
    public void setUp() {
        farmer = new Farmer("Frodo");
        warrior = new Warrior("Aragorn");
        constable = new Constable("Legolas");
    }

    @Test
    public void shouldCreateAFarmer() {
        assertEquals("Frodo", farmer.getName());
        assertEquals(75, farmer.getStrength());
        assertEquals(100, farmer.getHealth());
        assertEquals(75, farmer.getStamina());
        assertEquals(10, farmer.getSpeed());
        assertEquals(1, farmer.getAttackPower());
        assertFalse( farmer.isRunning());
        assertFalse( farmer.isArrested());
        assertFalse( farmer.isHarvesting());
    }

    @Test
    public void shouldCreateAWarrior() {
        assertEquals("Aragorn", warrior.getName());
        assertEquals(75, warrior.getStrength());
        assertEquals(100, warrior.getHealth());
        assertEquals(100, warrior.getStamina());
        assertEquals(50, warrior.getSpeed());
        assertEquals(10, warrior.getAttackPower());
        assertEquals(100, warrior.getShieldStrength());
        assertFalse( warrior.isRunning());
        assertFalse(warrior.isArrested());

    }

    @Test
    public void shouldCreateAConstable() {
        assertEquals("Legolas", constable.getName());
        assertEquals(60, constable.getStrength());
        assertEquals(100, constable.getHealth());
        assertEquals(60, constable.getStamina());
        assertEquals(20, constable.getSpeed());
        assertEquals(5, constable.getAttackPower());
        assertFalse(constable.isRunning());
        assertFalse(constable.isArrested());
        assertTrue(constable.getJurisdiction().length() > 0);
    }

    @Test
    public void shouldAttackEachClass() {
        assertEquals(100,farmer.attack(warrior));
        assertEquals(99,farmer.attack(constable));
        assertEquals(90, warrior.attack(farmer));
        assertEquals(89, warrior.attack(constable));
        assertEquals(85, constable.attack(farmer));
        assertEquals(100, constable.attack(warrior));
    }

    @Test
    public void constableArrestedAll() {
        constable.arrest(farmer);
        constable.arrest(warrior);
        constable.arrest(constable);
        assertTrue(farmer.isArrested());
        assertTrue(warrior.isArrested());
        assertTrue(constable.isArrested());
    }
}