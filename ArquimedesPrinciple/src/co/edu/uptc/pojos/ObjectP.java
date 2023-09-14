package co.edu.uptc.pojos;

import java.awt.*;

public class ObjectP {

    private Rectangle rectangle;
    private double mass;
    private double volume;
    private double density;

    public ObjectP(){}

    public ObjectP(Rectangle rectangle, double mass, double volume) {
        this.rectangle = rectangle;
        this.mass = mass;
        this.volume = volume;
        this.density = mass/volume;
    }

    public Rectangle getRectangle(){
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }
}
