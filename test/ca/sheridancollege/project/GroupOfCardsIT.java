/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacob
 */
public class GroupOfCardsIT {
    
    public GroupOfCardsIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        GroupOfCards.createDeck();
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
     * Test of getCard method, of class GroupOfCards.
     */
    @Test
    public void testGetCard() {
        System.out.println("getCard");
        Card result = GroupOfCards.getCard();
        assertNotNull(result);
    }

    /**
     * Test of shuffle method, of class GroupOfCards.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        
        assertTrue(GroupOfCards.shuffle());
    }
    
}
