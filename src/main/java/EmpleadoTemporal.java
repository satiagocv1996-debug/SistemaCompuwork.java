public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(int id, String nombre, String cargo) {
        super(id, nombre, cargo);
    }

    @Override
    public String getTipo() {
        return "Temporal";
    }
}