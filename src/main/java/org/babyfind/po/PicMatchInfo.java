package org.babyfind.po;

public class PicMatchInfo {
    private String pic1;
    private String pic2;
    /**
     * 对比分值，0~100，表示百分比
     */
    private double score;

    public PicMatchInfo() {
    }

    public PicMatchInfo(String pic1, String pic2, double score) {
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.score = score;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
