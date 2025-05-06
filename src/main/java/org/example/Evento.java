package org.example;

public class Evento {

    private int event_id,start_time,end_time;
    private String description;

    public Evento(int event_id, int start_time, int end_time, String description) {
        this.event_id = event_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.description = description;
    }

    public Evento(Evento e ) {
        this.event_id = e.getEvent_id();
        this.start_time = e.getStart_time();
        this.end_time = e.getEnd_time();
        this.description = e.getDescription();
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
