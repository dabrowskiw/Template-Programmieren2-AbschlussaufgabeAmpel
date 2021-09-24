package org.htw.prog2.ampel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class LightImage {
    public LightImage(File imagefile) {
    }

    public double getLightIntensity(Light light) {
        return 0d;
    }

    public boolean isInLight(int x, int y, Light light) {
        return false;
    }

    public String getActiveLight(List<Light> lights) {
        return null;
    }

    public BufferedImage getImage() {
        return null;
    }
}
