package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemProps {
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
        System.out.println(val);
    }

}