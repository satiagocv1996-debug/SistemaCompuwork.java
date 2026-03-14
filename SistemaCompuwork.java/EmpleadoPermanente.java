public class EmpleadoPermanente extends Empleado {

    public EmpleadoPermanente(int id, String nombre, String cargo) {
        super(id, nombre, cargo);
    }

    @Override
    public String getTipo() {
        return "Permanente";
    }
}