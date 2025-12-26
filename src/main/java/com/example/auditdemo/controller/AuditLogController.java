package com.example.auditdemo.controller;

import com.example.auditdemo.model.AuditLog;
import com.example.auditdemo.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit-logs")
public class AuditLogController {
    @Autowired
    private AuditLogService auditLogService;

            // get all audit log services
    @GetMapping
    public List<AuditLog> getAllAuditLogs(){
        return auditLogService.getAllAuditLogs();
    }

}
