import processing.core.PApplet;
import processing.core.PImage;

public class Reef extends PApplet {
    public static void main(String[] args) { PApplet.main("Reef"); }

    private final String res = "res/";

    Entity star;

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        frameRate(15);

        PImage image = loadImage(res + "Star.png");
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
}
