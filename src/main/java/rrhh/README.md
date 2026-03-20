# Análisis y corrección SOLID — Paquete: rrhh

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP): DIP**

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- AltaEmpleadoService asume la responsabilidad de orquestar el alta, pero está fuertemente acoplada a implementaciones concretas.
-RepositorioEmpleadosEnMemoria y GeneradorPasswordSimple: Son clases concretas que el servicio utiliza directamente.

**Síntomas que lo delatan (marca y explica brevemente):**
-El servicio AltaEmpleadoService instancia directamente new RepositorioEmpleadosEnMemoria() y new GeneradorPasswordSimple(). Si mañana queremos usar una base de datos, debemos modificar el código del servicio.
-No existen interfaces que definan el "qué" se hace (guardar, generar password), solo clases que definen el "cómo".
-Para cambiar la política de contraseñas a una "segura", hay que alterar el servicio que debería ser agnóstico a la complejidad de la clave.

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
-Si se decide pasar de memoria a una base de datos (MySQL, MongoDB), se tendría que editar el core de la lógica de negocio (AltaEmpleadoService), lo que podría introducir errores en un código que ya funcionaba.
-El sistema está atado a contraseñas simples. Implementar una contraseña segura requeriría cambiar el tipo de dato o la lógica interna del servicio.
-No se pueden hacer Mocks del repositorio o del generador porque están cableados (hardcoded) dentro del servicio, lo que obliga a probar todo el conjunto (prueba de integración) en lugar de solo la lógica de alta.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
-Crearemos RepositorioEmpleado y GeneradorContraseña como interfaces.
-El servicio AltaEmpleadoService recibirá las interfaces en su constructor (Inyección de Dependencias).
-Podremos tener EmpleadoRepositorio o GeneradorContraseña sin que el servicio se entere del cambio.