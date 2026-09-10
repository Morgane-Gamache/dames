package cstjean.mobile.jeu;

import junit.framework.TestCase;

public class TestDamier extends TestCase {
    public void testAjouterPion() {
        Damier damier = new Damier();
        Pion pionA = new Pion();
        damier.ajouterPion(2, pionA);
        assertEquals("blanc", damier.getPositionPion(2).getCouleur());
        Pion pionB = new Pion("noir");
        damier.ajouterPion(3, pionB);
        assertEquals("noir", damier.getPositionPion(3).getCouleur());
    }
}
