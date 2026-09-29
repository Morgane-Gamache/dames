package cstjean.mobile.jeu;

import junit.framework.TestCase;

public class TestAffichage extends TestCase {

    /**  Le damier utilisé pour les tests.*/
    private Damier damier;
    private Affichage affichage;
    private String plateau;

    /**  Crée un nouveau damier avant chaque test.*/
    public void setUp() {
        affichage = new Affichage();
        damier = new Damier();
    }

    /**  Test pour savoir si la chaine créer est la bonne.*/
    public void testCreerAffichage() {
        damier.initialiser();
        plateau = affichage.creerAffichage(damier);
        assertEquals( "-P-P-P-P-P\n" +
                "P-P-P-P-P-\n" +
                "-P-P-P-P-P\n" +
                "P-P-P-P-P-\n" +
                "----------\n" +
                "----------\n" +
                "-p-p-p-p-p\n" +
                "p-p-p-p-p-\n" +
                "-p-p-p-p-p\n" +
                "p-p-p-p-p-\n", plateau);
    }

    /**  Test pour voir l'affichage.*/
    public void testAfficher() {
        testCreerAffichage();
        affichage.afficher(plateau);
    }

}
