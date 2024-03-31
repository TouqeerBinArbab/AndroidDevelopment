package com.example.androiddevelopment;

public class Planet {

    // Attributes
    private final String planetName;
    private final String moonCount;
    private final int planetImage;


    public Planet(String planetName, String moonCount, int planetImage) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
    }

    public String getPlanetName() {
        return planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }
}
