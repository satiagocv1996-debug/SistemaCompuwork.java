import java.util.ArrayList;

public class Departamento {

    private String nombre;
    private ArrayList<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        empleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public double calcularPromedio() {

        if (empleados.size() == 0) {
            return 0;
        }

        double suma = 0;

        for (Empleado e : empleados) {
            suma += e.getRendimiento();
        }

        return suma / empleados.size();
    }
}