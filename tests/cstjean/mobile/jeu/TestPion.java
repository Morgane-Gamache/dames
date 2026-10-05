package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Tests pour les pions.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class TestPion extends TestCase {
    /**
     * Teste la création de pions.
     */
    public void testCreer() {
        Pion pionA = new Pion(Pion.Couleur.BLANC);
        Pion pionB = new Pion(Pion.Couleur.NOIR);
        Pion pionC = new Pion();
        assertEquals(Pion.Couleur.BLANC, pionA.getCouleur());
        assertEquals(Pion.Couleur.NOIR, pionB.getCouleur());
        assertEquals(Pion.Couleur.BLANC, pionC.getCouleur());
        assertEquals('p', pionA.getRepresentation().charValue());
        assertEquals('P', pionB.getRepresentation().charValue());
        assertEquals('p', pionC.getRepresentation().charValue());
    }
}
