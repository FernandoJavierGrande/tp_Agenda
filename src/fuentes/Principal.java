package fuentes;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        boolean salir = false;
        boolean agendaLlena;
        Contacto contactoEliminado;
        String respuesta, nombre, paisCodigo;
        int numero, espaciosLibres, tamanio;

        Agenda_de_Contactos agd = new Agenda_de_Contactos();
        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Desea definir la cantidad de contactos de su agenda?");
        respuesta = entrada.nextLine().trim();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("¿Que tamaño desea que tenga su agenda? ingrse la cantidad con numeros. ");

            try {
                tamanio = Integer.parseInt(entrada.nextLine().trim());
                agd = new Agenda_de_Contactos(tamanio);
            } catch (Exception e) {
                System.out.println(" Ingreso incorrecto. ");
                System.out.println("Tamaño por defecto (5)");
            }

        } else {

            System.out.println("Tamaño por defecto (5)");
        }

        do {

            System.out.println("*****************************************************************");
            System.out.println("                       Bievenido/a a su agenda \n");
            System.out.println("Ingrese con el numero correspondiente la tarea que desea realizar ");
            System.out.println("                       1- Añadir contacto");
            System.out.println("                       2- Modificar un contacto");
            System.out.println("                       3- Dar de baja un contacto ");
            System.out.println("                       4- Buscar un contacto por Nombre");
            System.out.println("                       5- Listar todos los contactos");
            System.out.println("                       6- ¿La agenda está llena?");
            System.out.println("                       7- Espacio libre de la agenda");
            System.out.println("                       8- Codigo de un pais");
            System.out.println("                       9- Salir");
            System.out.println("********************************************************************");

            respuesta = entrada.nextLine().trim();

            switch (respuesta) {

                case "1":

                    System.out.print("Ingrese el nombre del contacto: ");
                    nombre = entrada.nextLine().trim();

                    try {
                        System.out.print("Ingrese sin espacios el numero de telefono: ");
                        numero = Integer.parseInt(entrada.nextLine().trim());
                        Contacto contacto = new Contacto(nombre, numero);
                        agd.anadirContacto(contacto);

                    } catch (Exception e) {
                        System.out.println("En el campo telefono solo pueden ingresarse numeros");
                    }

                    break;
                case "2":

                    System.out.print("Ingrese el numero de contacto que desea cambiar");

                    try {
                        numero = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Ingrese el nombre nuevo: ");
                        nombre = entrada.nextLine();
                        agd.modificarContacto(numero, nombre);

                    } catch (Exception e) {

                        System.out.println("En el campo telefono solo pueden ingresarse numeros");
                    }

                    break;
                case "3":

                    System.out.print("Ingrese el numero de telefono del contacto que desea dar de baja: ");
                    try {

                        numero = Integer.parseInt(entrada.nextLine());

                        contactoEliminado = agd.darDeBajaContacto(numero);

                        System.out.println("El contacto eliminado es Nombre: '" + contactoEliminado.getNombre() + "' Teléfono: " + contactoEliminado.getTelefono());

                    } catch (Exception e) {

                        System.out.println("En el campo telefono solo pueden ingresarse numeros");

                    }

                    break;
                case "4":

                    System.out.print("Escriba a continuacion el nombre del contacto que desea buscar: ");

                    nombre = entrada.nextLine();

                    numero = agd.buscarPorNombre(nombre);

                    if (numero == 0) {
                        System.out.println("El contacto no existe");

                    } else {
                        System.out.println("El telefono de '" + nombre + "' es: " + numero);
                    }

                    break;
                case "5":

                    String listaDeContactos;
                    listaDeContactos = agd.listarContactos();

                    System.out.println(listaDeContactos);

                    break;
                case "6":

                    agendaLlena = agd.agendaLlena();

                    if (agendaLlena) {
                        System.out.println("La agenda está llena");
                    } else {
                        System.out.println("La agenda aun tiene espacios libres");
                    }

                    break;
                case "7":
                    espaciosLibres = agd.espacioLibre();

                    System.out.println("Quedan " + espaciosLibres + " espacios libres.");

                    break;
                case "8":

                    System.out.print("Ingrese el codigo del pais:");

                    respuesta = entrada.nextLine().trim();

                    paisCodigo = Agenda_de_Contactos.codigoPais(respuesta);

                    System.out.println("El codigo ingresado" + paisCodigo);

                    break;
                case "9":

                    salir = true;
                    break;
                default:
                    System.err.println("Ingrese una opcion valida");
            }

        } while (!salir);

    }
}
