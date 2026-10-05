package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Test de l'affichage.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class TestAffichage extends TestCase {

    /**  Le damier utilisé pour les tests.*/
    private Damier damier;
    /** L'affichage.*/
    private Affichage affichage;
    /** Le plateau. */
    private String plateau;

    /**  Crée un nouveau damier avant chaque test.*/
    public void setUp() {
        affichage = new Affichage();
        damier = new Damier();
    }

    /**  Test pour savoir si la chaine créée est la bonne.*/
    public void testCreerAffichage() {
        damier.initialiser();
        plateau = affichage.creerAffichage(damier);
        assertEquals("""
                -P-P-P-P-P
                P-P-P-P-P-
                -P-P-P-P-P
                P-P-P-P-P-
                ----------
                ----------
                -p-p-p-p-p
                p-p-p-p-p-
                -p-p-p-p-p
                p-p-p-p-p-
                """, plateau);
    }

    /**  Test pour voir l'affichage.*/
    public void testAfficher() {
        testCreerAffichage();
        affichage.afficher(plateau);
    }

}
