package com.example.sage.model;

import com.example.sage.view.Class.ViewClasses;

import java.time.LocalDateTime;
import java.util.Date;
/**
 * Write a description of class ClassSession here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClassSession extends Session{
    private static int classSessionCount = 0;
    
    public ClassSession(LocalDateTime startDateTime, LocalDateTime endDateTime, String zoomLink){
        super(startDateTime, endDateTime, zoomLink);
        classSessionCount++;
        sessionId = classSessionCount;
    }

    //getters
    public int getClassSessionId(){
        return sessionId;
    }


}
