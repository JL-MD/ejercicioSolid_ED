package rrhh;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioEmpleadosEnMemoria implements RepositorioEmpleado {
    private List<Empleado> empleados = new ArrayList<>();
    @Override
    public void guardar(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado guardado en memoria: " + empleado.getNombre());
    }
}