package tema.BiggestNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiggestNumberOutOfThreeTest {

    @Test
    void main() {
        BiggestNumberOutOfThree test1 = new BiggestNumberOutOfThree();
        assertEquals(7, test1.getMax(5,7));
        assertEquals(7, test1.getMax(7,7));
    }
}