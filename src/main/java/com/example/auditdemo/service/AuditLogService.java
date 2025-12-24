package com.example.auditdemo.service;

import com.example.auditdemo.model.AuditLog;
import com.example.auditdemo.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

}
