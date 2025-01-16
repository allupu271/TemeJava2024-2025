package com.example.jdbc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MasinaJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Masina> findAll() {
        return jdbcTemplate.query("select * from masini", new MasinaMapper());
    }

    public int insert(Masina masina) {
        return jdbcTemplate.update("insert into masini (NrInm, Marca, AnFabr, Culoare, NrKm) values(?, ?, ?, ?, ?)",
                new Object[]{masina.getNrInmatriculare(), masina.getMarca(), masina.getAnulFabricatiei(), masina.getCuloare(), masina.getNrKm()});
    }

    public int update(Masina masina) {
        return jdbcTemplate.update("update masini set Marca = ?, AnFabr = ?, Culoare = ?, NrKm = ? where NrInm = ?",
                new Object[]{masina.getMarca(), masina.getAnulFabricatiei(), masina.getCuloare(), masina.getNrKm(), masina.getNrInmatriculare()});
    }

    public int deleteById(String nrInmatriculare) {
        return jdbcTemplate.update("delete from masini where NrInm = ?", new Object[]{nrInmatriculare});
    }

    public Masina findById(String nrInmatriculare) {
        return jdbcTemplate.queryForObject("select * from masini where NrInm = ?", new Object[]{nrInmatriculare}, new MasinaMapper());
    }




}
