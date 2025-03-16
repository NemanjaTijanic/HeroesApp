/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Ability;
import entity.Hero;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Korisnik
 */
public class UtilTest {
    
    public UtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of scanAbilityDesc method, of class Util.
     */
    @Test
    public void testScanAbilityDesc() {
        System.out.println("scanAbilityDesc");
        String heroName = "genji";
        int br = 0;
        String expResult = "Throw 3 Shuriken in a spread pattern, each dealing 65 damage to the first enemy hit. Stores up to 3 charges. Shuriken's cooldown replenishes all charges at the same time.";
        String result = Util.scanAbilityDesc(heroName, br);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of scanAbilityName method, of class Util.
     */
    @Test
    public void testScanAbilityName() {
        System.out.println("scanAbilityName");
        String heroName = "genji";
        int br = 0;
        String expResult = "Shuriken";
        String result = Util.scanAbilityName(heroName, br);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findHero method, of class Util.
     */
    @Test
    public void testFindHero() {
        System.out.println("findHero");
        List<Hero> heroji = crud.HeroCRUD.readAllHeroes();
        int br = 9;
        Hero expResult = crud.HeroCRUD.readHeroById(br);
        Hero result = Util.findHero(heroji, br);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAbility method, of class Util.
     */
    @Test
    public void testFindAbility() {
        System.out.println("findAbility");
        List<Ability> abilitiji = crud.AbilityCRUD.readAllAbilities();
        Hero br = crud.HeroCRUD.readHeroById(5);
        List<Ability> expResult = new ArrayList<>();
        Ability a = crud.AbilityCRUD.readAbilityById(4);
        expResult.add(a);
        List<Ability> result = Util.findAbility(abilitiji, br);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createHero method, of class Util.
     */
    @Test
    public void testCreateHero() throws Exception {
        System.out.println("createHero");
        Hero hero = crud.HeroCRUD.readHeroById(10);
        Util.createHero(hero);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
