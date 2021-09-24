package org.htw.prog2.ampel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LightImageTest {

    @Test
    void constructorThrowsInexistentFile() {
        assertThrows(IOException.class, () -> {
            LightImage image = new LightImage(new File("IDONTEXIST"));
        });
    }

    @Test
    void getLightIntensity() {
        LightImage image = null;
        Light lightRed = null;
        Light lightYellow = null;
        Light lightGreen = null;
        try {
            image = new LightImage(new File("1609183932.jpg"));
            lightRed = new Light("red, 274, 80, 3");
            lightYellow = new Light("red, 274, 90, 3");
            lightGreen = new Light("red, 274, 99, 3");
        } catch (Exception e) {
            fail("Should not throw, but throws " + e.getMessage());
        }
        assertEquals(716d, image.getLightIntensity(lightRed), 1d);
        assertEquals(350d, image.getLightIntensity(lightYellow), 1d);
        assertEquals(257d, image.getLightIntensity(lightGreen), 1d);
    }

    @Test
    void getActiveLight() {
        LightImage image = null;
        LinkedList<Light> lights = new LinkedList<>();
        try {
            image = new LightImage(new File("1609183932.jpg"));
            lights.add(new Light("red, 274, 80, 3"));
            lights.add(new Light("red, 274, 90, 3"));
            lights.add(new Light("red, 274, 99, 3"));
        } catch (Exception e) {
            fail("Should not throw, but throws " + e.getMessage());
        }
        assertEquals("red", image.getActiveLight(lights));
    }
}