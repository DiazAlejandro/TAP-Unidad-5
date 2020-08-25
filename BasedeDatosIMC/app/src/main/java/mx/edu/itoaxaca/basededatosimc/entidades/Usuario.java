package mx.edu.itoaxaca.basededatosimc.entidades;

public class Usuario {
    private Integer id;
    private String  nombre;
    private Double  cintura;
    private Double  cadera;

    public Usuario(Integer id, String nombre, Double cintura, Double cadera) {
        this.id = id;
        this.nombre = nombre;
        this.cintura = cintura;
        this.cadera = cadera;
    }

    public Usuario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCintura() {
        return cintura;
    }

    public void setCintura(Double cintura) {
        this.cintura = cintura;
    }

    public Double getCadera() {
        return cadera;
    }

    public void setCadera(Double cadera) {
        this.cadera = cadera;
    }
}
