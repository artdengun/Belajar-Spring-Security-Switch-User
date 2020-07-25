package com.deni.gunawan.belajar.spring.belajarswitchuser.dao;

import com.deni.gunawan.belajar.spring.belajarswitchuser.entity.Pengguna;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PenggunaDao extends PagingAndSortingRepository<Pengguna, String> {
    Optional<Pengguna> findByUsername(String name);
}
