package org.htw.prog2.ampel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {
    @Test
    void constructorWrongLineLength() {
        try {
            Configuration c = new Configuration(new File("coords_wrongLineLength.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'yellow, 274, 90, 3, 5': Wrong number of elements.",
                    e.getMessage());
        } catch(IOException e) {
            fail("Should now throw an IOException");
        }
    }

    @Test
    void constructorxNotInt() {
        try {
            Configuration c = new Configuration(new File("coords_xNotInt.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'red, center, 80, 3': Could not parse center as coordinate (need an integer).",
                    e.getMessage());
        } catch(IOException e) {
            fail("Should now throw an IOException");
        }
    }

    @Test
    void constructoryNotInt() {
        try {
            Configuration c = new Configuration(new File("coords_yNotInt.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'yellow, 274, ninety, 3': Could not parse ninety as coordinate (need an integer).",
                    e.getMessage());
        } catch(IOException e) {
            fail("Should now throw an IOException");
        }
    }

    @Test
    void constructordNotInt() {
        try {
            Configuration c = new Configuration(new File("coords_dNotInt.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'green, 274, 99, d': Could not parse d as diameter (need an integer).",
                    e.getMessage());
        } catch(IOException e) {
            fail("Should now throw an IOException");
        }
    }

    @Test
    void constructor() {
        assertDoesNotThrow(() -> new Configuration(new File("config.txt")));
    }

    @Test
    void getLights() {
        Configuration c = null;
        try {
            c = new Configuration(new File("config.txt"));
        } catch(Exception e) {
            fail("Should not throw, but throws " + e.getMessage());
        }
        assertEquals(3, c.getLights().size());
    }
}