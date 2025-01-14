package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.dao.ProgramStatusDao;
import com.codecrafters.tvpss.model.ProgramStatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProgramStatusService {

    @Autowired
    private ProgramStatusDao programStatusDao;

    public void saveProgramStatus(ProgramStatusModel programStatus) {
        programStatus.setCreatedAt(LocalDateTime.now()); // Set current time for createdAt
        programStatusDao.save(programStatus);
    }

    public List<ProgramStatusModel> getAllProgramStatuses() {
        return programStatusDao.findAll();
    }
}
