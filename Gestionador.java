/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 06/09/2024
 * DESCRIPCION: Clase Gestionador encargada de gestionar las clases modelo
 */

 import java.util.ArrayList;

 public class Gestionador {
     private ArrayList<Seccion> secciones;
 
     public Gestionador(ArrayList<Seccion> secciones) {
         this.secciones = secciones;
     }
 
     public ArrayList<Seccion> getSecciones() {
         return secciones;
     }
 
     public void setSecciones(ArrayList<Seccion> secciones) {
         this.secciones = secciones;
     }
 
     // Método para reservar un asiento en una sección específica
     public boolean reservarAsiento(String seccionNombre, int fila, int asiento) {
         try {
             for (Seccion seccion : secciones) {
                 if (seccion.getNombre().equalsIgnoreCase(seccionNombre)) {
                     return seccion.reservarAsiento(fila, asiento);
                 }
             }
         } catch (Exception e) {
             // Devolver false en caso de una excepción
             return false;
         }
         return false; // Retornar false si no se encontró la sección
     }
 
     // Método para obtener la disponibilidad de una sección específica
     public String mostrarDisponibilidad(String seccionNombre) {
         try {
             for (Seccion seccion : secciones) {
                 if (seccion.getNombre().equalsIgnoreCase(seccionNombre)) {
                     return seccion.mostrarDisponibilidad();
                 }
             }
         } catch (Exception e) {
             return "Excepción: " + e.getClass().getSimpleName();
         }
         return "Sección no encontrada.";
     }
 
     // Método para cancelar una reserva en una sección específica
     public boolean cancelarReserva(String seccionNombre, int fila, int asiento) {
         try {
             for (Seccion seccion : secciones) {
                 if (seccion.getNombre().equalsIgnoreCase(seccionNombre)) {
                     return seccion.cancelarReserva(fila, asiento);
                 }
             }
         } catch (Exception e) {
             // Devolver false en caso de una excepción
             return false;
         }
         return false; // Retornar false si no se encontró la sección
     }
 
     // Método para calcular los ingresos de una sección específica
     public double calcularIngresosPorSeccion(String seccionNombre) {
         try {
             for (Seccion seccion : secciones) {
                 if (seccion.getNombre().equalsIgnoreCase(seccionNombre)) {
                     return seccion.calcularIngresos();
                 }
             }
         } catch (Exception e) {
             return 0; // Retornar 0 en caso de una excepción
         }
         return 0; // Retornar 0 si no se encontró la sección
     }
 
     // Método para calcular los ingresos totales del auditorio
     public double calcularIngresosTotales() {
         double ingresosTotales = 0;
         try {
             for (Seccion seccion : secciones) {
                 ingresosTotales += seccion.calcularIngresos();
             }
         } catch (Exception e) {
             return 0; // Retornar 0 en caso de una excepción
         }
         return ingresosTotales; // Retornar los ingresos totales
     }
 }
 