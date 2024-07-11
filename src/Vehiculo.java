public class Vehiculo {
    String placa;
    String marca;
    Double cilindraje;
    String Tipo_combustible;
    String color;
    String propetiario;

    public Vehiculo() {}
    public Vehiculo(String placa, String marca, Double cilindraje, String tipo_combustible, String color, String propetiario) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        Tipo_combustible = tipo_combustible;
        this.color = color;
        this.propetiario = propetiario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipo_combustible() {
        return Tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        Tipo_combustible = tipo_combustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropetiario() {
        return propetiario;
    }

    public void setPropetiario(String propetiario) {
        this.propetiario = propetiario;
    }
}