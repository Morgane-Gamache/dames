package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Tests pour les déplacements.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class TestDeplacement extends TestCase {
    /** Teste un déplacement simple.*/
    public void testDeplacement() {
        Deplacement deplacement = new Deplacement(31, 27);

        assertEquals(31, deplacement.getDepart());
        assertEquals(27, deplacement.getArrivee());
        assertEquals(0, deplacement.getPrise());
        assertFalse(deplacement.estPrise());
        assertEquals("31-27", deplacement.toString());
    }

    /**
     * Teste un déplacement avec prise.
     */
    public void testDeplacementPrise() {
        Deplacement deplacement = new Deplacement(27, 18, 22);

        assertEquals(22, deplacement.getPrise());
        assertTrue(deplacement.estPrise());
        assertEquals("27x18", deplacement.toString());
    }
}
