package com.ic.dinin.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class MapCoordinates {

    private float CoordinateX;
    private float CoordinateY;
    protected MapCoordinates() {
    }

    public MapCoordinates(float coordinateX, float coordinateY) {
        CoordinateX = coordinateX;
        CoordinateY = coordinateY;
    }

    public float getCoordinateX() {
        return CoordinateX;
    }

    public float getCoordinateY() {
        return CoordinateY;
    }
}
