package com.example.repository;

import com.example.entity.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {

    @Query("SELECT c FROM ChiTietSP c WHERE c.idSP.id = :idSP" )
    List<ChiTietSP> findBySanPamId(@Param("idSP") UUID idSP);

    @Query("SELECT c FROM ChiTietSP c WHERE c.idSP.idDongSP.ten LIKE %:keyword%"
            + " OR c.idSP.idDeGiay.chatLieu LIKE %:keyword%"
            + " OR c.idMauSP.mau LIKE %:keyword%"
            + " OR c.idKichCo.coGiay LIKE %:keyword%"
            + " OR CAST(c.idSP.giaBan AS string) LIKE %:keyword%"
            + " OR CAST(c.soLuong AS string) LIKE %:keyword%")
    Page<ChiTietSP> search(@Param("keyword")String keyword, Pageable pageable);

}
