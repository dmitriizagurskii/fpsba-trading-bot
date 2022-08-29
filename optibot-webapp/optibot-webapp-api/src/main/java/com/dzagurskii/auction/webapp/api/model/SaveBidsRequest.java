package com.dzagurskii.auction.webapp.api.model;

public class SaveBidsRequest {
    private int own;
    private int other;

    public int getOwn() {
        return own;
    }

    public void setOwn(int own) {
        this.own = own;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "BidsRequest{" +
                "own=" + own +
                ", other=" + other +
                '}';
    }
}
