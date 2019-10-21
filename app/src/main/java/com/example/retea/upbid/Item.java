package com.example.retea.upbid;

/**
 * Created by retea on 03-May-18.
 */

public class Item {

    private String iNume;
    private String iDescriere;
    private int iPretStart;
    private int iPretBuyout;
    private boolean isAuctioned = false;
    private int iPretCurent;
    private boolean vandut = false;

    public boolean isVandut() {
        return vandut;
    }

    public void setVandut(boolean vandut) {
        this.vandut = vandut;
    }

    public Item(String nume, String descriere, int pretStart, int pretBuyout) {
        iNume = nume;
        iDescriere = descriere;
        iPretStart = pretStart;
        iPretBuyout = pretBuyout;
    }

    public String getNume() {
        return iNume;
    }

    public String getDescr() {
        return iDescriere;
    }

    public int getPretStart() {
        return iPretStart;
    }

    public int getPretBuyout() {
        return iPretBuyout;
    }


    public int getPretCurent() {
        return iPretCurent;
    }

    public void setPretCurent(int iPretCurent) {
        this.iPretCurent = iPretCurent;
    }

    public void setiNume(String iNume) {
        this.iNume = iNume;
    }

    public void setDescriere(String iDescriere) {
        this.iDescriere = iDescriere;
    }

    public void setPretStart(int iPretStart) {
        this.iPretStart = iPretStart;
    }

    public void setPretBuyout(int iPretBuyout) {
        this.iPretBuyout = iPretBuyout;
    }

    public void setAuctioned(boolean auctioned) {
        isAuctioned = auctioned;
    }

    public boolean isAuctioned() {
        return isAuctioned;
    }

}