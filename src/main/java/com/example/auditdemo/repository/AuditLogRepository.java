package com.example.auditdemo.repository;

import com.example.auditdemo.model.AuditLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditLogRepository extends MongoRepository<AuditLog, String> {
    List<AuditLog> findByAction(String action);
    List<AuditLog> findByUsername(String username);
    List<AuditLog> findTop5ByOrderByTimestampDesc();
    List<AuditLog> findByTimestampBetween(LocalDateTime from, LocalDateTime to);
}
