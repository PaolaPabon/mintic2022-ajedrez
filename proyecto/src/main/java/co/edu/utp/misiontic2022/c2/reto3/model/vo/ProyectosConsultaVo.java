package co.edu.utp.misiontic2022.c2.reto3.model.vo;

public class ProyectosConsultaVo {
    // guarda la informacion que viene de la base de  datos y solo tiene metodos set y get para acceder a los registros

    private String ciudad;
    private String clasificacion;
    private Integer total;
    private String viejo;
    private String reciente;

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public String getViejo() {
        return viejo;
    }
    public void setViejo(String viejo) {
        this.viejo = viejo;
    }
    public String getReciente() {
        return reciente;
    }
    public void setReciente(String reciente) {
        this.reciente = reciente;
    }
    @Override
    public String toString() {
        
        return "ProyectosConsultaVo [ciudad=" + ciudad + ", clasificacion=" + clasificacion + ", reciente=" + reciente
                + ", total=" + total + ", viejo=" + viejo + "]";
    }

}
