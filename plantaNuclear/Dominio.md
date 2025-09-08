# Dominio del problema: Central Nuclear

Una **central nuclear** es un sistema complejo de generación de energía eléctrica que transforma la energía liberada en reacciones nucleares de fisión en electricidad utilizable. Para ello, integra múltiples subsistemas que interactúan de manera coordinada y segura.  

En el corazón de la central se encuentra el **reactor nuclear**, donde la fisión del combustible (generalmente uranio enriquecido) libera grandes cantidades de calor. Este calor se transmite a través de un **circuito primario** de agua a presión, impulsado por **bombas** de gran caudal, que mantienen la refrigeración del reactor y permiten transportar la energía térmica.  

El calor del circuito primario se transfiere, mediante intercambiadores, a un **circuito secundario**, en el cual se genera vapor que mueve una **turbina** acoplada a un **generador eléctrico**. De esta forma, la energía nuclear se convierte en energía eléctrica.  

La seguridad es fundamental en una instalación de este tipo. Existen múltiples **sensores** que monitorean constantemente variables críticas como temperatura, presión, caudal y radiación ambiental. Además, los sistemas deben poder ejecutar una parada de emergencia inmediata —conocida como **SCRAM**— que detiene el reactor y los equipos asociados en caso de anomalía.  

El dominio de una central nuclear refleja la necesidad de modelar:

- **Equipos** que comparten características comunes (identificación, estado de servicio, diagnóstico).  
- **Comportamientos abstractos** como “encender”, “apagar” o “leer una variable”.  
- **Distintos tipos de equipos** que heredan propiedades generales, pero implementan de forma diferente sus operaciones (reactores, bombas, turbinas, sensores).  
- **Mecanismos de control centralizado**, que coordinan y supervisan la operación segura de todos los subsistemas.  

En términos de programación orientada a objetos, este dominio resulta especialmente adecuado para ejercitar **abstracción, herencia, encapsulamiento, polimorfismo, clases abstractas e interfaces**, dado que la central nuclear se compone de actores con roles diferenciados, responsabilidades claras y comportamientos comunes que se expresan en contratos y jerarquías.  
