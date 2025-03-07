package co.edu.uniandes.dse.parcial1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcial1.entities.EstacionEntity;
import co.edu.uniandes.dse.parcial1.entities.RutaEntity;

@Repository
public interface RutaRepository extends JpaRepository<RutaEntity, Long> {

    List<RutaEntity> findByNombre(String nombre);
    List<RutaEntity> findByColor(String color);
    List<RutaEntity> findByTipo(String tipo);

}
