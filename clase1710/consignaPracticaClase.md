# Diseño inicial de clases para un sistema de ventas (GRASP)

## Objetivo
Diseñar las clases iniciales para un sistema que registra la **venta de productos**, aplicando los patrones **GRASP**.

### 🎯 Patrones a aplicar
- **Experto en Información (Information Expert):** asignar la responsabilidad a la clase que tiene la información necesaria para cumplirla.
- **Creador (Creator):** asignar la responsabilidad de crear una instancia de clase **B** a la clase **A**, si **A** contiene o agrega instancias de **B**.
- **Controlador (Controller):** asignar la responsabilidad de gestionar los eventos del sistema (interfaz o usuario) a una clase de fachada para el sistema o subsistema.

---

## 1) Escenario inicial (el problema)
El sistema (caja registradora simple) debe ser capaz de:
- Registrar una nueva venta.  
- Ingresar productos (líneas de venta) a esa venta.  
- Calcular el total de la venta.

### 1.1) Clases iniciales (sin responsabilidades asignadas)
Tendremos las siguientes clases con sus datos, pero **sin** métodos de lógica de negocio:

| Clase              | Atributos clave (información que posee)        |
|--------------------|-------------------------------------------------|
| **SistemaPOS**     | Referencia a **RegistroVentas**                |
| **RegistroVentas** | Lista de objetos **Venta**                     |
| **Venta**          | Fecha y hora; Lista de objetos **DetalleVenta**|
| **DetalleVenta**   | Cantidad; Referencia a **Producto**            |
| **Producto**       | Nombre; Precio; ISBN/Código                    |

### Preguntas clave para GRASP
1. **Creador:** ¿Quién es responsable de crear una nueva **Venta**?  
2. **Experto:** ¿Quién calcula el **subtotal** de un **DetalleVenta**?  
3. **Controlador:** ¿Quién inicia una nueva venta desde la interfaz o API?  
4. **Experto:** ¿Quién calcula el **total** final de la **Venta**?

---

## 2) Aplicación de patrones GRASP

### 2.1) Patrón **Creador** (Creator): creación de objetos
- **Problema:** ¿Quién debería crear una instancia de **Venta**?  
- **Solución (Creator):** la clase que **contiene/agrupa** las instancias de **Venta**.  
- **Resultado:** **RegistroVentas** define un método (p. ej. `crearVenta()`) que instancia **Venta** y la agrega a su lista.

### 2.2) Patrón **Experto en Información** (Information Expert): responsabilidades de cálculo
- **Problema:** ¿Quién calcula el **subtotal** del **DetalleVenta** (*Cantidad × Precio del Producto*)?  
- **Solución (Expert):** **DetalleVenta** conoce la *cantidad* y referencia a **Producto**, que conoce el *precio*.  
- **Resultado:** **DetalleVenta** implementa `calcularSubTotal()`.

- **Problema:** ¿Quién calcula el **total** final de la **Venta** (suma de subtotales)?  
- **Solución (Expert):** **Venta** conoce su lista de **DetalleVenta**.  
- **Resultado:** **Venta** implementa `calcularTotal()`.

### 2.3) Patrón **Controlador** (Controller): manejo de eventos del sistema
- **Problema:** cuando el cajero pulsa **“Nueva Venta”**, ¿qué objeto recibe la señal y coordina la acción?  
- **Solución (Controller):** una clase **fachada** del sistema.  
- **Resultado:** **SistemaPOS** (o `ControladorVentas`) implementa `iniciarVenta()` y `agregarItemAVenta()`, delegando:
  - **Creación de ventas** a **RegistroVentas** (Creator).
  - **Cálculo y agregado de ítems** a **Venta/DetalleVenta** (Expert).
