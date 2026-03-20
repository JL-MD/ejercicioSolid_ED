package rrhh;

public class AltaEmpleadoService {
    private RepositorioEmpleado repositorio = null;
    private GeneradorContraseña generador = null;

    // Inyección por constructor: el servicio no sabe qué implementación usa
    public AltaEmpleadoService() {
        this.repositorio = repositorio;
        this.generador = generador;
    }

    public void alta(String dni, String nombre) {
        String password = generador.generar();
        Empleado nuevo = new Empleado(dni, nombre, password);
        repositorio.guardar(nuevo);
        System.out.println("Alta procesada para: " + nombre);
    }
}