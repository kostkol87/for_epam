package HW02.t02;

import junit.framework.Assert;
import org.junit.Test;

public class InventoryTest {
    @Test
    public void testName() throws Exception {
        Employee milonov = new Employee("Vitaliy", "Milonov",
                new Stationery("Pen", 25.5, 2),
                new Stationery("Pencil", 51.7, 5),
                new Stationery("stapler", 129.9, 5),
                new Stationery("Paper", 351.0, 1));
        Employee medvedev = new Employee("Dmitriy", "Medvedev",
                new Stationery("Pen", 25.5, 1),
                new Stationery("Pencil", 51.7, 1));
        Employee putin = new Employee("Vladimir", "Putin",
                new Stationery("Pen", 1975112.5, 1),
                new Stationery("Pencil", 25771, 5));

        Company company = new Company(milonov, medvedev, putin);

        Assert.assertEquals(25.5*2+51.7*5+129.9*5+351, company.getEmployee("Vitaliy", "Milonov").inventory());
    }
}