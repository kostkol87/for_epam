package HW02.t06.t07;

import junit.framework.Assert;
import org.junit.Test;

public class AtomicBoatTest {
    @Test
    public void testNestedClass() throws Exception {
        Assert.assertEquals("Bonvoyage!!!", new AtomicBoat().new EngineForAtominBoat().bonvoyage());
    }
}