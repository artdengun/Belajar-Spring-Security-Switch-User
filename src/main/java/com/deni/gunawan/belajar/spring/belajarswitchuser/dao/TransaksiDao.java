package com.deni.gunawan.belajar.spring.belajarswitchuser.dao;

import com.deni.gunawan.belajar.spring.belajarswitchuser.entity.Pengguna;
import com.deni.gunawan.belajar.spring.belajarswitchuser.entity.Transaksi;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransaksiDao extends PagingAndSortingRepository<Transaksi, String> {
    Iterable<Transaksi> findByPengguna(Pengguna p);
}
