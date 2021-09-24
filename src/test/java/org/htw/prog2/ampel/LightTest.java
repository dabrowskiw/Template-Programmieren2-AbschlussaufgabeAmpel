package org.htw.prog2.ampel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {
    @Test
    void constructorWrongLineLength() {
        try {
            Light l = new Light("blue, 24, 9");
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'blue, 24, 9': Wrong number of elements.",
                    e.getMessage());
        }
    }

    @Test
    void constructorxNotInt() {
        try {
            Light l = new Light("orange, x, 9, 99");
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'orange, x, 9, 99': Could not parse x as coordinate (need an integer).",
                    e.getMessage());
        }
    }

    @Test
    void constructoryNotInt() {
        try {
            Light l = new Light("orange, 3842, fawe, 99");
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'orange, 3842, fawe, 99': Could not parse fawe as coordinate (need an integer).",
                    e.getMessage());
        }
    }

    @Test
    void constructordNotInt() {
        try {
            Light l = new Light("green, 38, 102, blub");
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'green, 38, 102, blub': Could not parse blub as radius (need an integer).",
                    e.getMessage());
        }
    }

    @Test
    void constructor() {
        assertDoesNotThrow(() -> new Light("green, 1, 2, 3"));
    }

    @Test
    void getX() {
        Light l = null;
        try {
            l = new Light("green, 1, 2, 3");
        } catch(FormatException e) {
            fail("Should not throw, but trows " + e.getMessage());
        }
        assertEquals(1, l.getX());
    }

    @Test
    void getY() {
        Light l = null;
        try {
            l = new Light("green, 1, 2, 3");
        } catch(FormatException e) {
            fail("Should not throw, but trows " + e.getMessage());
        }
        assertEquals(2, l.getY());
    }

    @Test
    void getD() {
        Light l = null;
        try {
            l = new Light("green, 1, 2, 3");
        } catch(FormatException e) {
            fail("Should not throw, but trows " + e.getMessage());
        }
        assertEquals(3, l.getR());
    }

    @Test
    void getName() {
        Light l = null;
        try {
            l = new Light("green, 1, 2, 3");
        } catch(FormatException e) {
            fail("Should not throw, but trows " + e.getMessage());
        }
        assertEquals("green", l.getName());
    }
}