public class Empleado {

    private int id;
    private String nombre;
    private String cargo;
    private double rendimiento;
    private Departamento departamento;

    public Empleado(int id, String nombre, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.rendimiento = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getTipo() {
        return "Empleado";
    }
}