package pe.edu.cibertec.senamhi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estaciones")
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_nuevo")
    private String codigoNuevo;

    @Column(name = "codigo_antiguo")
    private String codigoAntiguo;

    private String estacion;
    private String clasificacion;
    private String condicion;

    @Column(name = "direccion_zonal")
    private Integer direccionZonal;

    private String categoria;
    private String tipo;
    private String departamento;
    private String provincia;
    private String distrito;
    private String latitud;
    private String longitud;
    private Double altitud;

    public Estacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoNuevo() {
        return codigoNuevo;
    }

    public void setCodigoNuevo(String codigoNuevo) {
        this.codigoNuevo = codigoNuevo;
    }

    public String getCodigoAntiguo() {
        return codigoAntiguo;
    }

    public void setCodigoAntiguo(String codigoAntiguo) {
        this.codigoAntiguo = codigoAntiguo;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Integer getDireccionZonal() {
        return direccionZonal;
    }

    public void setDireccionZonal(Integer direccionZonal) {
        this.direccionZonal = direccionZonal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Double getAltitud() {
        return altitud;
    }

    public void setAltitud(Double altitud) {
        this.altitud = altitud;
    }
}