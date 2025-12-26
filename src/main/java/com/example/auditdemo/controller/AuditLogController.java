package com.example.auditdemo.controller;

import com.example.auditdemo.model.AuditLog;
import com.example.auditdemo.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //get audit logs through action
    @GetMapping("/action/{action}")
    public List<AuditLog> getAuditLogsByAction(@PathVariable String action) {
        return auditLogService.getByAction(action);
    }

    @GetMapping("/user/{username}")
    public List<AuditLog> getAuditLogByUser(@PathVariable String username)
    {
        return auditLogService.getByUsername(username);
    }
    @GetMapping("/latest")
    public List<AuditLog> getLatestAuditLogs(){
        return auditLogService.getLatestLogs();
    }
    @GetMapping("/date/{date}")
    public List<AuditLog> getAuditLogsByDate(@PathVariable String date)
    {
        return auditLogService.getAuditLogsByDate(date);
    }


}
