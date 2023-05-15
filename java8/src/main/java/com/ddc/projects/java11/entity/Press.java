package com.ddc.projects.java11.entity;

public class Press {
    private int pressid;
    private String pressname;
    private String pressaddr;
    private int presstel;

    public Press() {
    }

    public Press(int pressid, String pressname, String pressaddr,
                 int presstel) {
        this.pressid = pressid;
        this.pressname = pressname;
        this.pressaddr = pressaddr;
        this.presstel = presstel;
    }

    public int getPressid() {
        return pressid;
    }

    public void setPressid(int pressid) {
        this.pressid = pressid;
    }

    public String getPressname() {
        return pressname;
    }

    public void setPressname(String pressname) {
        this.pressname = pressname;
    }

    public String getPressaddr() {
        return pressaddr;
    }

    public void setPressaddr(String pressaddr) {
        this.pressaddr = pressaddr;
    }

    public int getPresstel() {
        return presstel;
    }

    public void setPresstel(int presstel) {
        this.presstel = presstel;
    }
}
