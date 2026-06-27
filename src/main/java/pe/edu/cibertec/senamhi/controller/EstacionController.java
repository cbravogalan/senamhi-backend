package pe.edu.cibertec.senamhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.senamhi.model.Estacion;
import pe.edu.cibertec.senamhi.repository.EstacionRepository;

@RestController
@RequestMapping("/api/estaciones")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://tubular-bunny-c07551.netlify.app"})
public class EstacionController {

    @Autowired
    private EstacionRepository estacionRepository;

    @GetMapping
    public List<Estacion> listar() {
        return estacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Estacion obtenerPorId(@PathVariable Integer id) {
        return estacionRepository.findById(id).orElse(null);
    }

    @GetMapping("/buscar")
    public List<Estacion> buscar(@RequestParam String texto) {
        return estacionRepository.findByCodigoNuevoContainingOrEstacionContaining(texto, texto);
    }

    @PostMapping
    public Estacion registrar(@RequestBody Estacion estacion) {
        return estacionRepository.save(estacion);
    }

    @PutMapping("/{id}")
    public Estacion actualizar(@PathVariable Integer id, @RequestBody Estacion estacion) {
        Estacion actual = estacionRepository.findById(id).orElse(null);

        if (actual != null) {
            actual.setCodigoNuevo(estacion.getCodigoNuevo());
            actual.setCodigoAntiguo(estacion.getCodigoAntiguo());
            actual.setEstacion(estacion.getEstacion());
            actual.setClasificacion(estacion.getClasificacion());
            actual.setCondicion(estacion.getCondicion());
            actual.setDireccionZonal(estacion.getDireccionZonal());
            actual.setCategoria(estacion.getCategoria());
            actual.setTipo(estacion.getTipo());
            actual.setDepartamento(estacion.getDepartamento());
            actual.setProvincia(estacion.getProvincia());
            actual.setDistrito(estacion.getDistrito());
            actual.setLatitud(estacion.getLatitud());
            actual.setLongitud(estacion.getLongitud());
            actual.setAltitud(estacion.getAltitud());

            return estacionRepository.save(actual);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        estacionRepository.deleteById(id);
    }
}