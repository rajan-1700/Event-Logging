package com.example.auditdemo.service;

import com.example.auditdemo.model.AuditLog;
import com.example.auditdemo.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AuditLogService {
    @Autowired
    private AuditLogRepository auditlogrepository;

    public void logAction(
            String username,
            String action,
            String entityName,
            String entityId
    ){
        AuditLog log=new AuditLog();
        log.setUsername(username);
        log.setAction(action);
        log.setEntityName(entityName);
        log.setEntityId(entityId);
        log.setTimestamp(LocalDateTime.now());
        auditlogrepository.save(log);
    }
    //get all audit logs
    public List<AuditLog> getAllAuditLogs(){
        return auditlogrepository.findAll();
    }
    //get audit log filtering actions
    public List<AuditLog> getByAction(String action) {
        return auditlogrepository.findByAction(action);
    }

    public List<AuditLog> getByUsername(String username)
    {
        return auditlogrepository.findByUsername(username);
    }
    public List<AuditLog> getLatestLogs(){
        return auditlogrepository.findTop5ByOrderByTimestampDesc();
    }

    public List<AuditLog> getAuditLogsByDate(String date)
    {
        LocalDate localDate=LocalDate.parse(date);
        LocalDateTime startOfDay=localDate.atStartOfDay();
        LocalDateTime endOfDay=localDate.atTime(LocalTime.MAX);

        return auditlogrepository.findByTimestampBetween(startOfDay, endOfDay);


    }

}
