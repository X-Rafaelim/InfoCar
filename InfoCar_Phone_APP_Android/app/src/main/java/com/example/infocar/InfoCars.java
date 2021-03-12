package com.example.infocar;

public class InfoCars {
    private String production_years;
    private String engine_code;
    private String fuel_type;
    private String aspiration;
    private String traction;
    private String gearbox;
    private String hp;
    private String top_speed;
    private String max_rpm;
    private String fuel_tank_capacity;
    private String weight;
    private String num_doors;
    private String fuel_consumption;
    private String image;


    public InfoCars(String production_years, String engine_code, String fuel_type, String aspiration, String traction, String gearbox, String hp, String top_speed, String max_rpm, String fuel_tank_capacity, String weight, String num_doors, String fuel_consumption, String image) {
        this.production_years = production_years;
        this.engine_code = engine_code;
        this.fuel_type = fuel_type;
        this.aspiration = aspiration;
        this.traction = traction;
        this.gearbox = gearbox;
        this.hp = hp;
        this.top_speed = top_speed;
        this.max_rpm = max_rpm;
        this.fuel_tank_capacity = fuel_tank_capacity;
        this.weight = weight;
        this.num_doors = num_doors;
        this.fuel_consumption = fuel_consumption;
        this.image = image;
    }

    public String getProduction_years() {
        return production_years;
    }

    public void setProduction_years(String production_years) {
        this.production_years = production_years;
    }

    public String getEgine_code() {
        return engine_code;
    }

    public void setEgine_code(String egine_code) {
        this.engine_code = egine_code;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getAspiration() {
        return aspiration;
    }

    public void setAspiration(String aspiration) {
        this.aspiration = aspiration;
    }

    public String getTraction() {
        return traction;
    }

    public void setTraction(String traction) {
        this.traction = traction;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getTop_speed() {
        return top_speed;
    }

    public void setTop_speed(String top_speed) {
        this.top_speed = top_speed;
    }

    public String getMax_rpm() {
        return max_rpm;
    }

    public void setMax_rpm(String max_rpm) {
        this.max_rpm = max_rpm;
    }

    public String getFuel_tank_capacity() {
        return fuel_tank_capacity;
    }

    public void setFuel_tank_capacity(String fuel_tank_capacity) {
        this.fuel_tank_capacity = fuel_tank_capacity;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNum_doors() {
        return num_doors;
    }

    public void setNum_doors(String num_doors) {
        this.num_doors = num_doors;
    }

    public String getFuel_consumption() {
        return fuel_consumption;
    }

    public void setFuel_consumption(String fuel_consumption) {
        this.fuel_consumption = fuel_consumption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
