package tema.FarenheitConversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarenheitToCelsiusTest {

    @Test
    void main() {
        FarenheitToCelsius test1 = new FarenheitToCelsius();
        assertEquals(0, test1.convertToCelsius(32));
        assertEquals(50,test1.convertToCelsius(122));
    }
}