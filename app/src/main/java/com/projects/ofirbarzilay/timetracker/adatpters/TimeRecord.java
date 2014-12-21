package com.projects.ofirbarzilay.timetracker.adatpters;

/**
 * Created by Ofir.Barzilay on 19/12/2014.
 */
public class TimeRecord {
    private String time;
    private String notes;

    public TimeRecord(String time, String notes) {
        this.time = time;
        this.notes = notes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
