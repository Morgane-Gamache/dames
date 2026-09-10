package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Tests pour les pions.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class TestPion extends TestCase {
    /**  Teste la créaton de pions.*/
    public void testCreer() {
        Pion pionA = new Pion("blanc");
        Pion pionB = new Pion("noir");
        Pion pionC = new Pion();
        assertEquals("blanc", pionA.getCouleur());
        assertEquals("noir", pionB.getCouleur());
        assertEquals("blanc", pionC.getCouleur());
    }
}
