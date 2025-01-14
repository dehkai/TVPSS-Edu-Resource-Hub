package com.codecrafters.tvpss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecrafters.tvpss.dao.EventActivitiesDao;
import com.codecrafters.tvpss.model.EventActivity;

@Service
public class EventActivitiesService {

    @Autowired
    private EventActivitiesDao eventActivitiesDao;

    public List<EventActivity> getAllEventActivities() {
        return eventActivitiesDao.findAll();
    }

    // public Optional<EventActivity> getEventActivityById(Long id) {
    //     return Optional.ofNullable(eventActivitiesDao.findById(id));
    // }

    public void saveEventActivity(EventActivity eventActivity) {
        if (eventActivity.getId() == null) {
            eventActivitiesDao.addEventActivity(eventActivity);
        } else {
            eventActivitiesDao.updateEventActivity(eventActivity);
        }
    }

    // public EventActivity getEventById(Long eventId) {
    //     return eventActivitiesDao.findById(eventId)
    //            .orElseThrow(() -> new RuntimeException("Event not found"));
    // }

    public void deleteEventActivity(Long id) {
        eventActivitiesDao.deleteById(id); // Call DAO to delete by ID
    }

    public EventActivity getEventById(Long id) {
        return eventActivitiesDao.findById(id);
    }     

    public void updateEvent(EventActivity event) {
        eventActivitiesDao.updateEventActivity(event);
    }    
}
