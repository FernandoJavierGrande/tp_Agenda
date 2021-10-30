
package fuentes;


public class Contacto {
    
    private String Nombre;
    private int telefono;

    public Contacto(String Nombre, int telefono) {
        this.Nombre = Nombre;
        this.telefono = telefono;
    }

    public Contacto(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return   "Nombre = " + Nombre + ", telefono = " + telefono ;
    }
    
    
}
