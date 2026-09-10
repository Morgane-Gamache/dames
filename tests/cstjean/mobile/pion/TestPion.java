package cstjean.mobile.pion;
import junit.framework.TestCase;
public class TestPion extends TestCase {
    public void testCreer() {
        Pion pionA = new Pion("blanc");
        Pion pionB = new Pion("noir");
        assertEquals("blanc", pionA.getCouleur());
        assertEquals("noir", pionB.getCouleur());
    }
}
