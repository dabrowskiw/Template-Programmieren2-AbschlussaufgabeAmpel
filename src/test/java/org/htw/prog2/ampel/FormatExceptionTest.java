package org.htw.prog2.ampel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatExceptionTest {

    @Test
    void getLine() {
        FormatException e = new FormatException("coords 1 4 7 8", "name 'coords' unknown");
        assertEquals("coords 1 4 7 8", e.getLine());
    }

    @Test
    void getError() {
        FormatException e = new FormatException("coords 1 4 7 8", "name 'coords' unknown");
        assertEquals("name 'coords' unknown", e.getError());
    }

    @Test
    void getMessage() {
        FormatException e = new FormatException("coords 1 4 7 8", "name 'coords' unknown");
        assertEquals("Wrong format in line 'coords 1 4 7 8': name 'coords' unknown.", e.getMessage());
    }
}