package rrhh;

public interface RepositorioEmpleado {
    void guardar(Empleado empleado);

    boolean existe(String dni);
}
