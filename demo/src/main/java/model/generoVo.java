package model;

public class generoVo {

    private int idGenero;
    private String nombreGenero;
    private Boolean estadoGenero;

    public generoVo() {

    }

    public generoVo(int idGenero, String nombreGenero, Boolean estadoGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
        this.estadoGenero = estadoGenero;
    }

    public int getidGenero() {
        return idGenero;
    }

    public void setidGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getnombreGenero() {
        return nombreGenero;
    }

    public void setnombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public Boolean getestadoGenero() {
        return estadoGenero;
    }

    public void setestadoGenero(Boolean estadoGenero) {
        this.estadoGenero = estadoGenero;
    }

    public void editgenero(int r) {
    }

}
