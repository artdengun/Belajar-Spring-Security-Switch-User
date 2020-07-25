package com.deni.gunawan.belajar.spring.belajarswitchuser;

import com.deni.gunawan.belajar.spring.belajarswitchuser.entity.Pengguna;
import com.deni.gunawan.belajar.spring.belajarswitchuser.entity.Transaksi;
import com.github.javafaker.Faker;
import com.deni.gunawan.belajar.spring.belajarswitchuser.dao.PenggunaDao;
import com.deni.gunawan.belajar.spring.belajarswitchuser.dao.TransaksiDao;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BelajarSwitchuserApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSwitchuserApplication.class, args);
	}

	@Autowired private PenggunaDao penggunaDao;
	@Autowired private TransaksiDao transaksiDao;

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

	@Override
	public void run(String... args) throws Exception {
		penggunaDao.findAll().forEach(p -> generateTransaction(p, 20));
	}

	private void generateTransaction(Pengguna pengguna, Integer jumlahTransaksi) {
		Faker faker = new Faker() ;
		for (int i = 0; i < jumlahTransaksi; i++) {
			Transaksi t = new Transaksi();
			t.setPengguna(pengguna);
			t.setKeterangan("Transaksi "+pengguna.getNama()+" #"+ (i+1));
			t.setWaktuTransaksi(faker.date().past(5, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
			t.setNilai(new BigDecimal(faker.number().numberBetween(10000,100000000)));
			transaksiDao.save(t);
		}
	}
}
