package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Tests pour le damier.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class TestDamier extends TestCase {
    /**  Teste l'ajout de pions à un damier..*/
    public void testAjouterPion() {
        Damier damier = new Damier();
        Pion pionA = new Pion();
        Pion pionB = new Pion("noir");
        damier.ajouterPion(3, pionB);
        assertEquals("noir", damier.getPion(3).getCouleur());
        damier.ajouterPion(2, pionA);
        assertEquals("blanc", damier.getPion(2).getCouleur());
    }
}
