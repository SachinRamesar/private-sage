package com.example.sage.model;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Session{
    protected int sessionId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String zoomLink;


    public Session(LocalDateTime startDateTime,LocalDateTime endDateTime, String zoomLink){
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.zoomLink = zoomLink;
    }


    //getters
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public String getZoomLink() {
        return zoomLink;
    }

    //setters
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
    }


}
