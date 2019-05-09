package com.mmapps.pp.Repository;

import com.mmapps.pp.Entity.Pronos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.Collection;


public interface PronosRepository extends JpaRepository<Pronos, Long> {

    @Query(value="SELECT * FROM `pronos` WHERE `Date_Match` BETWEEN :dateDebut and :dateFin ",nativeQuery = true)
    Collection<Pronos> getPronosByDate(@Param("dateDebut")Date dateDebut,@Param("dateFin")Date dateFin);

    @Query(value = "SELECT * FROM `pronos` WHERE `Date_Match` = :date", nativeQuery = true)
    Collection<Pronos> getTodayProno(@Param("date") Date date);

    @Query(value = "SELECT * FROM `pronos` WHERE `Date_Match` = :date AND `Type` = :typeProno", nativeQuery = true)
    Collection<Pronos> pronoForToday(@Param("date") Date date, @Param("typeProno") String typeProno);

    @Query(value = "SELECT `good_prono` FROM `pronos` WHERE 1", nativeQuery = true)
    Collection<Pronos> getAllResults();
}
