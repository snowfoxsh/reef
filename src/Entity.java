import processing.core.PApplet;
import processing.core.PImage;

import org.gamecontrolplus.*;
import org.gamecontrolplus.gui.*;

public class Entity extends PApplet {
    PImage img;

    Box bounds;

    /**
     * @param image drawn image
     * @param x x coordinate of top left corner of image
     * @param y y coordinate of top left corner of image
     * @apiNote sets width and height to default of the image
     */
    public Entity(PImage image, int x, int y) {
        img = image;
        bounds = new Box(x, y, img.width, img.height);
    }

    /**
     * @param image drawn image
     * @param x x coordinate of top left corner of entity
     * @param y y coordinate of top left corner of entity
     * @param width width of image
     * @param height height of image
     */
    public Entity(PImage image, int x, int y, int width, int height) {
        img = image;
        bounds = new Box(x, y, width, height);
    }

    /**
     * changes the current entity's image that is drawn
     * @param image the new image
     */
    public void changeImage(PImage image) {
        img = image;
    }

    /**
     * draws the image
     * @param app applet that entity's image should be drawn on
     * @hint usually passing {this} works
     */
    public void drawEntity(PApplet app) {
        app.image(img, bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }

    /**
     * easy way to check if the users mouse is over the entity
     * @param app the applet that the entity is drawn on
     * @hint usually passing {this} works
     * @return if mouse is over the entity
     */
    public boolean mouseOver(PApplet app) {
        if (app.mouseX < bounds.getX() || app.mouseX > bounds.getX() + bounds.getWidth()) return false;
        if (app.mouseY < bounds.getY() || app.mouseY > bounds.getY() + bounds.getHeight()) return false;

        return true;
    }

    /**
     * easy way to check if the user is clicking on the entity
     * @param app the applet that the entity is drawn on
     * @hint usually passing {this} works
     * @return if mouse is over the entity and mouse is being clicked
     */
    public boolean entityClicked(PApplet app) {
        return mouseOver(app) && app.mousePressed;
    }

    /**
     * changes the height and width of the entity
     * @param width new width of entity
     * @param height new height of entity
     */
    public void resize(int width, int height) {
        bounds.setWidth(width);
        bounds.setHeight(height);
    }

    /**
     * @return entity's height
     */
    public int getHeight() {
        return bounds.getHeight();
    }

    /**
     * sets entity's height
     * @param height new height
     */
    public void setHeight(int height) {
        bounds.setHeight(height);
    }

    /**
     * @return entity's width
     */
    public int getWidth() {
        return bounds.getWidth();
    }

    /**
     * sets entity's width
     * @param width new width
     */
    public void setWidth(int width) {
        bounds.setWidth(width);
    }

    /**
     * @return x absolute position
     */
    public int getX() {
        return bounds.getX();
    }

    /**
     * @return y absolute possition
     */
    public int getY() {
        return bounds.getY();
    }

    // move methods

    /**
     * moves the entity to the coordinate. movement is absolute
     * @param x x component (absolute)
     * @param y y component (absolute)
     */
    public void move(int x, int y) {
        bounds.setX(x);
        bounds.setY(y);
    }

    /**
     * translates the entity relative to itself on xy-axis
     * @param x x component (relative)
     * @param y y component (relative)
     */
    public void translate(int x, int y) {
        int xTmp = bounds.getX();
        int yTmp = bounds.getY();

        bounds.setX(xTmp + x);
        bounds.setY(yTmp + y);
    }

    /**
     * translates the entity relative to itself on x-axis
     * @param x x component (relative)
     */
    public void translateX(int x) {
        int xTmp = bounds.getX();
        bounds.setX(xTmp + x);
    }

    /**
     * translates the entity relative to itself on y-axis
     * @param y y component (relative)
     */
    public void translateY(int y) {
        int yTmp = bounds.getY();
        bounds.setX(yTmp + y);
    }
}

class Box {
    private int x, y, width, height;
    public Box(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
