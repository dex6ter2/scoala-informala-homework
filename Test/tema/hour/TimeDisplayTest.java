package tema.hour;

import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class TimeDisplayTest {

    @Test
    void main() {
        TimeDisplay test1 = new TimeDisplay();
        assertFalse(test1.validateHour("23"));
        assertFalse(test1.validateHour("0"));
        assertTrue(test1.validateHour("24"));
        assertTrue(test1.validateHour("-1"));
        assertFalse(test1.validateMinutes("59"));
        assertFalse(test1.validateMinutes("0"));
        assertTrue(test1.validateMinutes("60"));
        assertTrue(test1.validateMinutes("-1"));

    }
}