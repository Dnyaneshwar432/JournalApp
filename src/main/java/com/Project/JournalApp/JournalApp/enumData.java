package com.Project.JournalApp.JournalApp;

public enum enumData {
    RAM("RAM","SITA"),
    SHAM("SHAM","RADHA"),
    GHANSHYAM("GHANSHYAM","SAVITA"),
    BALRAM("BALRAM","YOGITA"),
    RAJARAM("RAJARAM","RANI"),
    PRANAM("PRANAM","SHWETA");

    public String getLower() {
        return lower;
    }

    public String lower;

    public String getLadies() {
        return ladies;
    }

    public String ladies;


    private enumData(String lower,String ladies)
    {
        this.lower = lower;
        this.ladies = ladies;
        System.out.println("Our constructor called "+lower+" & "+ladies);

    }

    public  void display(){
        System.out.println("The name is "+this.name());

    }

}
