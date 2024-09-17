/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 06/09/2024
 * DESCRIPCION: Clase Seccion encargada de la representacion de la seccion
 */

 import java.util.Arrays;

 public class Seccion {
     private String nombre;
     private double precio;
     private boolean[][] filas;
 
     public Seccion(String nombre, double precio, int numFilas, int numAsientosPorFila) {
         this.nombre = nombre;
         this.precio = precio;
         this.filas = new boolean[numFilas][numAsientosPorFila];
         for (boolean[] fila : filas) {
             Arrays.fill(fila, false);
         }
     }
 
     public String getNombre() {
         return nombre;
     }
 
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
 
     public double getPrecio() {
         return precio;
     }
 
     public void setPrecio(double precio) {
         this.precio = precio;
     }
 
     public boolean[][] getFilas() {
         return filas;
     }
 
     public void setFilas(boolean[][] filas) {
         this.filas = filas;
     }
 
     public boolean reservarAsiento(int fila, int asiento) {
         try {
             if (!filas[fila][asiento]) {
                 filas[fila][asiento] = true;
                 return true;
             }
         } catch (ArrayIndexOutOfBoundsException e) {
             return false;
         }
         return false;
     }
 
     // Método que devuelve una cadena con la disponibilidad de los asientos
     public String mostrarDisponibilidad() {
         StringBuilder disponibilidad = new StringBuilder();
         try {
             for (int i = 0; i < filas.length; i++) {
                 for (int j = 0; j < filas[i].length; j++) {
                     disponibilidad.append("(").append(i).append(",").append(j).append(")");
                     disponibilidad.append(filas[i][j] ? " Ocupado. " : " Libre. ");
                 }
                 disponibilidad.append("\n");
             }
         } catch (Exception e) {
             return "Excepción: " + e.getClass().getSimpleName();
         }
         return disponibilidad.toString();
     }
 
     public boolean cancelarReserva(int fila, int asiento) {
         try {
             if (filas[fila][asiento]) {
                 filas[fila][asiento] = false;
                 return true;
             }
         } catch (ArrayIndexOutOfBoundsException e) {
             return false;
         }
         return false;
     }
 
     public double calcularIngresos() {
         int asientosReservados = 0;
         try {
             for (boolean[] fila : filas) {
                 for (boolean asiento : fila) {
                     if (asiento) {
                         asientosReservados++;
                     }
                 }
             }
         } catch (Exception e) {
             return 0;
         }
         return asientosReservados * precio;
     }
 }
 