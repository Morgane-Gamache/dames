package cstjean.mobile.jeu;

import junit.framework.TestSuite;

/**
 * Tests pour l'ensemble du projet.
 *
 * @author Morgane Gamache, Ian LeBlanc
 *
 */
public class TestComplet {
    /**  Retourne une suite de tests.
     *
     * @return La suite contenant les tests.
     *
     * */
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TestPion.class);
        suite.addTestSuite(TestDamier.class);
        return suite;
    }
}
