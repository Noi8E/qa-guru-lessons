package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.lang.module.Configuration;

public class SystemProps extends TestBase {
    @Test
    @Tag("props")
    void someTest() {
        String val = System.getProperty("value");
    }
    @Test
    @Tag("props")
    void someTest1() {
        System.setProperty("value", "an_value");
        String val = System.getProperty("value","def_props");
        System.out.println(val);
    }
    @Test
    @Tag("props")
    void someTest2() {
        String val = System.getProperty("browser","chrome");
        String val2 = System.getProperty("version", "90");
        String val3 = System.getProperty("resolution", "100*100");
        System.out.println("browser is" + val);
        System.out.println("version is" + val2);
        System.out.println("resolution is" + val3);
        System.out.println(selenoidRemoteAddress);
    }

}
