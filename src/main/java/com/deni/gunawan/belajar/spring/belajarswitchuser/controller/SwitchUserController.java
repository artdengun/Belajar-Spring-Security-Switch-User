package com.deni.gunawan.belajar.spring.belajarswitchuser.controller;

import com.deni.gunawan.belajar.spring.belajarswitchuser.dao.AuditLogDao;
import com.deni.gunawan.belajar.spring.belajarswitchuser.dao.PenggunaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwitchUserController {
    @Autowired private PenggunaDao penggunaDao;
    @Autowired private AuditLogDao auditLogDao;

    @GetMapping("/switchuser/auditlog")
    public ModelMap daftarKegiatan() {
        return new ModelMap()
                .addAttribute("daftarAuditLog",
                        auditLogDao.findAll());
    }

    @GetMapping("/switchuser/select")
    public ModelMap pilihUser() {
        return new ModelMap()
                .addAttribute("daftarPengguna",
                        penggunaDao.findAll());
    }
}
