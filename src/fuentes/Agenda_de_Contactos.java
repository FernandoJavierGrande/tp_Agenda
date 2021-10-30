package fuentes;

public class Agenda_de_Contactos {

    private Contacto[] contactos;

    public Contacto[] getContactos() {
        return contactos;
    }

    public void setContactos(Contacto[] contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "Agenda_de_Contactos{" + "contactos=" + listarContactos() + '}';
    }

    //constructores
    public Agenda_de_Contactos() {
        this.contactos = new Contacto[5];
    }

    public Agenda_de_Contactos(int tamanio) {
        contactos = new Contacto[tamanio];
    }

    public void anadirContacto(Contacto c) {

        boolean full;
        int numeroTel;

        full = agendaLlena();

        if (full) {
            System.out.println("No hay mas espacio para agregar contactos");
        } else {

            numeroTel = buscarPorNombre(c.getNombre());

            if (numeroTel == c.getTelefono()) {
                System.out.println("El nombre ingresado '" + c.getNombre() + "', telefono numero: " + c.getTelefono() + " ya existe");
            } else {
                for (int i = 0; i < contactos.length; i++) {
                    if (contactos[i] == null) {
                        contactos[i] = c;
                        System.out.println("El contacto '" + contactos[i] + "' se cargo correctamente \n");
                        break;
                    }
                }
            }
        }
    }

    public void modificarContacto(int telefono, String nuevoNombre) {

        for (Contacto unContacto : contactos) {

            if (unContacto != null) {
                if (telefono == unContacto.getTelefono()) {
                    unContacto.setNombre(nuevoNombre);
                    System.out.println("Contacto modificado correctamente.");
                    break;
                }
            }

        }
    }

    public Contacto darDeBajaContacto(int telefono) {

        boolean aux = false;
        Contacto contactoEliminado = null;
        String nombre;

        for (int i = 0; i < contactos.length; i++) {

            if (contactos[i] != null) {
                if (contactos[i].getTelefono() == telefono) {
                    contactoEliminado = contactos[i];
                    contactos[i] = null;
                    aux = true;
                    break;
                }
            }
        }

        if (!aux) {
            System.out.println("No existe ningun contacto con los datos ingresados");
        }

        return contactoEliminado;
    }

    public int buscarPorNombre(String nombre) {

        int telefono = 0;

        for (int i = 0; i < contactos.length; i++) {

            if (contactos[i] != null) {
                if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                    telefono = contactos[i].getTelefono();
                }
            }
        }
        return telefono;
    }

    public String listarContactos() {

        String listado = "";
        int contador = 0;

        for (int i = 0; i < contactos.length; i++) {

            if (contactos[i] != null) {
                contador++;
                listado += "  Contacto " + (i + 1) + " - Nombre: " + contactos[i].getNombre() + ". Telefono: " + contactos[i].getTelefono() + ". \n ";
            }
        }
        if (contador == 0) {
            listado = "La lista de contactos está vacia";
        }

        return listado;
    }

    public boolean agendaLlena() {

        boolean estaLlena = false;

        for (int i = 0; i < contactos.length; i++) {

            if (contactos[i] == null) {

                estaLlena = false;
                break;
            } else {
                estaLlena = true;
            }

        }
        return estaLlena;
    }

    public int espacioLibre() {

        int cantidad = 0;

        for (Contacto unContacto : contactos) {

            if (unContacto == null) {

                cantidad++;
            }

        }

        return cantidad;
    }

    public static String codigoPais( String codigo) {

        String nombrePais = "no corresponde a ningun pais";
        
        switch (codigo) {

                case "49":
                    nombrePais = " corresponde a Alemania";
                    
                    break;
                case "54":
                    nombrePais = " corresponde a Argentina";
                    break;
                case "880":
                    nombrePais = " corresponde a Bangladés";
                    break;
                case "55":
                    nombrePais = " corresponde a Brasil";                  
                    break;
                case "56":
                    nombrePais = " corresponde a Chile";
                    break;
                case "86":
                    nombrePais = " corresponde a China";
                    break;
                case "679":
                    nombrePais = " corresponde a Fiji";
                    break;
                case "692":
                    nombrePais = " corresponde a Islas Marshall";
                    break;
                default:
                    
            }

        return nombrePais;
    }

}
