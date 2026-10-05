package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Tests pour les dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class TestDame extends TestCase {
    /**
     * Teste la création de dames.
     */
    public void testCreer() {
        Dame dameA = new Dame(Dame.Couleur.BLANC);
        Dame dameB = new Dame(Dame.Couleur.NOIR);
        Dame dameC = new Dame();

        assertEquals(Dame.Couleur.BLANC, dameA.getCouleur());
        assertEquals(Dame.Couleur.NOIR, dameB.getCouleur());
        assertEquals(Dame.Couleur.BLANC, dameC.getCouleur());
        assertEquals('d', dameA.getRepresentation().charValue());
        assertEquals('D', dameB.getRepresentation().charValue());
        assertEquals('d', dameC.getRepresentation().charValue());
    }
}
