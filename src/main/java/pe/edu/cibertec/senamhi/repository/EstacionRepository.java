package pe.edu.cibertec.senamhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.senamhi.model.Estacion;

public interface EstacionRepository extends JpaRepository<Estacion, Integer> {

    List<Estacion> findByCodigoNuevoContainingOrEstacionContaining(
            String codigoNuevo,
            String estacion
    );
}