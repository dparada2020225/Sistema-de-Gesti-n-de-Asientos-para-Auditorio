/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 06/09/2024
 * DESCRIPCION: Clase Interfaz encargada de la interaccion con el usuario
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class Interfaz {
 
     public static void main(String[] args) {
         // Crear lista de secciones del auditorio y agregar diferentes secciones
         ArrayList<Seccion> secciones = new ArrayList<>();
         secciones.add(new Seccion("VIP", 150, 5, 10));
         secciones.add(new Seccion("Platino", 100, 8, 12));
         secciones.add(new Seccion("Oro", 75, 10, 15));
         secciones.add(new Seccion("Plata", 50, 12, 20));
 
         // Crear el objeto Gestionador con las secciones previamente creadas
         Gestionador gestionador = new Gestionador(secciones);
         Scanner scanner = new Scanner(System.in);
         int opcion = 0; // Inicializar la variable de opción para el menú
 
         // Bucle principal del menú
         do {
             try {
                 // Mostrar el menú de opciones
                 System.out.println("");
                 System.out.println("------------------------------");
                 System.out.println("------------------------------");
                 System.out.println("Sistema de Gestión de Asientos");
                 System.out.println("------------------------------");
                 System.out.println("------------------------------");
                 System.out.println("1. Reservar Asiento");
                 System.out.println("2. Mostrar Disponibilidad");
                 System.out.println("3. Cancelar Reserva");
                 System.out.println("4. Calcular Ingresos por Sección");
                 System.out.println("5. Calcular Ingresos Totales");
                 System.out.println("6. Salir");
                 System.out.println("------------------------------");
                 System.out.print("Seleccione una opción: ");
                 opcion = scanner.nextInt(); // Leer la opción del usuario
                 System.out.println("------------------------------");
 
                 // Switch para manejar las diferentes opciones del menú
                 switch (opcion) {
                     case 1:
                         // Reservar asiento
                         System.out.print("Ingrese la sección (VIP, Platino, Oro, Plata): ");
                         String seccion = scanner.next();
                         System.out.print("Ingrese el número de fila: ");
                         int fila = scanner.nextInt();
                         System.out.print("Ingrese el número de asiento: ");
                         int asiento = scanner.nextInt();
                         // Intentar reservar el asiento
                         if (gestionador.reservarAsiento(seccion, fila, asiento)) {
                             System.out.println("Asiento reservado con éxito.");
                         } else {
                             System.out.println("El asiento ya está reservado o la sección es incorrecta.");
                         }
                         System.out.println("------------------------------");
                         break;
                     case 2:
                         // Mostrar disponibilidad de asientos
                         System.out.print("Ingrese la sección (VIP, Platino, Oro, Plata): ");
                         seccion = scanner.next();
                         String disponibilidad = gestionador.mostrarDisponibilidad(seccion);
                         System.out.println(disponibilidad);
                         break;
                     case 3:
                         // Cancelar reserva
                         System.out.print("Ingrese la sección (VIP, Platino, Oro, Plata): ");
                         seccion = scanner.next();
                         System.out.print("Ingrese el número de fila: ");
                         fila = scanner.nextInt();
                         System.out.print("Ingrese el número de asiento: ");
                         asiento = scanner.nextInt();
                         if (gestionador.cancelarReserva(seccion, fila, asiento)) {
                             System.out.println("Reserva cancelada con éxito.");
                         } else {
                             System.out.println("El asiento no estaba reservado o la sección es incorrecta.");
                         }
                         System.out.println("------------------------------");
                         break;
                     case 4:
                         // Calcular ingresos por sección
                         System.out.print("Ingrese la sección (VIP, Platino, Oro, Plata): ");
                         seccion = scanner.next();
                         double ingresosSeccion = gestionador.calcularIngresosPorSeccion(seccion);
                         System.out.println("Ingresos generados en la sección " + seccion + ": $" + ingresosSeccion);
                         System.out.println("------------------------------");
                         break;
                     case 5:
                         // Calcular ingresos totales
                         double ingresosTotales = gestionador.calcularIngresosTotales();
                         System.out.println("Ingresos totales del auditorio: $" + ingresosTotales);
                         System.out.println("------------------------------");
                         break;
                     case 6:
                         // Salir del sistema
                         System.out.println("Saliendo del sistema...");
                         scanner.close(); // Cerrar el scanner
                         break;
                     default:
                         System.out.println("Opción no válida.");
                         System.out.println("------------------------------");
                 }
             } catch (Exception e) {
                 // Capturar excepciones y mostrar el tipo de error
                 System.out.println("Excepción: " + e.getClass().getSimpleName());
                 scanner.nextLine(); // Limpiar el buffer de entrada
                 opcion = 0; // Restablecer la variable a un valor válido para continuar el bucle
             }
         } while (opcion != 6); // Continuar en el bucle mientras la opción no sea salir
     }
 }
 