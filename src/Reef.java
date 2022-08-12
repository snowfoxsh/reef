import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.util.HashMap;

public class Reef extends PApplet {
    public static void main(String[] args) { PApplet.main("Reef"); }

    private final String res = "res/";
    private HashMap<String, PImage> imgDb = new HashMap<>();
    Entity star;

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        loadRes();
        frameRate(15);

        PImage image = imgDb.get("Star.png");
        star = new Entity(image, 400, 200, 70, 70);
        star.drawEntity(this);
    }

    @Override
    public void draw() {
        if (star.mouseOver(this)){
            star.translate(2,0);
        }

        star.drawEntity(this);
    }

    private void loadRes() {
        File resDir = new File("src/res");
        File[] files = resDir.listFiles();
        for (File img : files) {
            String name = img.getName();
            if (name.endsWith(".png") || name.endsWith(".jpg")) {
                System.out.println(img.getAbsolutePath());
                imgDb.put(name, loadImage(img.getPath()));
            }
        }
    }
}
