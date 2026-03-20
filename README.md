# Ejercicio SOLID

Este proyecto contiene **4 mini-casos independientes**, cada uno en su propio paquete, diseñados para practicar la detección y corrección de **violaciones de principios SOLID** en código Java “realista” (estilo junior, funcional, pero mejorable).

El objetivo no es “reescribirlo todo”, sino **identificar el principio vulnerado**, explicar **qué problemas provoca** y proponer una **refactorización razonable** que lo corrija.

## Profesor

- **Alfonso Jiménez Vílchez** - [@sambrista](https://github.com/sambrista)

## Alumnos
**Tomás Pérez Reche** - [@tprxd07](https://github.com/tprxd07)

**José Luis Moreno Dobao** - [@JL-MD](https://github.com/JL-MD)

---

## Estructura del proyecto

Paquetes:

- `matricula`
- `mensajes`
- `biblioteca`
- `rrhh`

Cada paquete incluye:
- Clases del dominio (modelo)
- Un servicio principal con la lógica
- Una clase `App` o `*App` para ejecutar el ejemplo

---

## Qué hay que hacer

- Haz fork de este repositorio a tu cuenta.
- Modifica este archivo para añadir el nombre de los alumnos, incluyendo enlace a su cuenta de GitHub.
- En tu fork, trabaja paquete por paquete (matricula, mensajes, biblioteca, rrhh).
- En cada paquete:
    - Revisa el código y detecta la violación principal de SOLID.
    - Refactoriza para corregir el problema manteniendo el comportamiento lo máximo posible (misma idea de funcionamiento, salidas por consola similares si aplica).
    - Modifica el README.md del paquete y documenta tu análisis y tu solución.

> Recomendación: intenta que la solución mantenga el comportamiento observable (salidas por consola, flujo general) salvo que el propio diseño actual sea incoherente.

---

# Paquete `matricula`

## Contexto
Una academia gestiona matrículas: se crea una matrícula, se calcula el precio final, se valida el DNI, se guarda un listado y se genera un resumen (exportación a texto). Además, se muestra un aviso por consola simulando una notificación.

## Clases (orientativo)
- `Matricula` → modelo de matrícula (dni, curso, fecha, precioFinal).
- `MatriculaService` → crea matrículas, calcula el precio, valida y exporta resumen.
- `App` → ejecuta un ejemplo.

# Paquete `mensajes`

## Contexto
Un instituto genera mensajes automáticos para comunicaciones internas (avisos, incidencias, felicitaciones). El mensaje final es un texto con formato.

## Clases (orientativo)
- `TipoMensaje` → enum con tipos: AVISO, INCIDENCIA, FELICITACION.
- `Mensaje` → modelo de mensaje (con campos comunes y algunos extra).
- `GeneradorTextoMensajes` → genera el texto final según tipo.
- `App` → ejecuta un ejemplo.

# Paquete `biblioteca`

## Contexto
Una biblioteca gestiona materiales. Hay libros “normales” que se pueden prestar a socios y libros de referencia que solo se consultan en sala y **no se prestan**. El sistema tiene un servicio de préstamo/devolución.

## Clases (orientativo)
- `Libro` → libro prestable con estado de préstamo.
- `LibroReferencia` → libro de consulta (no debería prestarse).
- `PrestamoService` → presta y devuelve.
- `BibliotecaApp` → ejecuta el ejemplo con un array y bucles `foreach`.

# Paquete `rrhh`

## Contexto
Un módulo de RRHH da de alta empleados creando credenciales iniciales. Hoy se guarda en memoria y la contraseña es simple, pero en el futuro:
- el repositorio será una base de datos,
- la contraseña será más segura.

## Clases (orientativo)
- `Empleado` → modelo (dni, nombre, passwordTemporal).
- `RepositorioEmpleadosEnMemoria` → almacenamiento en memoria.
- `GeneradorPasswordSimple` → genera password temporal simple.
- `AltaEmpleadoService` → orquesta el alta usando repositorio + generador.
- `App` → ejecuta el ejemplo.

## Ejecución

Cada paquete incluye una clase `App`/`*App` con `main`.  
Compila y ejecuta desde tu IDE o con `javac/java` según tu estructura.

> Si tienes un proyecto Maven/Gradle, basta con ejecutar la clase `main` correspondiente en cada paquete.