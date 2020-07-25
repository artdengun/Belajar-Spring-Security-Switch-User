package com.deni.gunawan.belajar.spring.belajarswitchuser.dao;

import com.deni.gunawan.belajar.spring.belajarswitchuser.entity.AuditLog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuditLogDao extends PagingAndSortingRepository<AuditLog, String> {
}
