# Sistema de Gestión de Asientos para Auditorio

## Descripción
Este es un sistema desarrollado en Java para gestionar la reserva de asientos en un auditorio con distintas secciones: VIP, Platino, Oro y Plata. El sistema permite:
- Reservar asientos.
- Mostrar la disponibilidad de asientos.
- Cancelar reservas.
- Calcular ingresos por sección y totales.

La interacción se realiza a través de una consola, con un menú simple y amigable para el usuario.

## Requisitos
- Java Development Kit (JDK) 8 o superior.
- Editor de código Java (Eclipse, IntelliJ, NetBeans, etc.).

## Estructura del Proyecto
- **Interfaz.java**: Contiene el punto de entrada al programa y maneja la interacción con el usuario.
- **Seccion.java**: Representa una sección del auditorio, contiene métodos para gestionar asientos y calcular ingresos.
- **Gestionador.java**: Gestiona las operaciones con todas las secciones del auditorio.

## Uso
1. Ejecuta el programa `Interfaz.java`.
2. Sigue las instrucciones del menú para reservar asientos, cancelar reservas, mostrar la disponibilidad o calcular los ingresos.
3. La consola mostrará mensajes e información sobre cada operación.

## Ejecución
Para ejecutar el programa, compila los archivos `.java` y ejecuta `Interfaz.java`:
```bash
javac Interfaz.java Gestionador.java Seccion.java
java Interfaz
