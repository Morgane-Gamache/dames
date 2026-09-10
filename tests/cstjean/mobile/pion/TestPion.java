package cstjean.mobile.pion;
import junit.framework.TestCase;
public class TestPion extends TestCase {
    public void testCreer() {
        Pion pionA = new Pion("rouge");
        Pion pionB = new Pion("noir");
        assertEquals("rouge", pionA.getCouleur());
        assertEquals("noir", pionB.getCouleur());
    }
}
