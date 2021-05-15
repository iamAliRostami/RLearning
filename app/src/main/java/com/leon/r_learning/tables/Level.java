package com.leon.r_learning.tables;

public class Level {
    private int perctot;
    private String liv;
    private int prog;
    private int tot;
    private int[] percentCourses;

    public Level(int perctot, String liv, int prog, int tot, int[] percentCourses) {
        this.perctot = perctot;
        this.liv = liv;
        this.prog = prog;
        this.tot = tot;
        this.percentCourses = percentCourses;
    }

    public int getPerctot() {
        return perctot;
    }

    public void setPerctot(int perctot) {
        this.perctot = perctot;
    }

    public String getLiv() {
        return liv;
    }

    public void setLiv(String liv) {
        this.liv = liv;
    }

    public int getProg() {
        return prog;
    }

    public void setProg(int prog) {
        this.prog = prog;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public int[] getPercentCourses() {
        return percentCourses;
    }

    public void setPercentCourses(int[] percentCourses) {
        this.percentCourses = percentCourses;
    }
}
