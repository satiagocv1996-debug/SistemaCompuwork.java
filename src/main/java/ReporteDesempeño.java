public class ReporteDesempeño {

    public void reporteIndividual(Empleado e) {

        System.out.println("ID: " + e.getId());
        System.out.println("Nombre: " + e.getNombre());
        System.out.println("Cargo: " + e.getCargo());
        System.out.println("Tipo: " + e.getTipo());

        if (e.getDepartamento() != null) {
            System.out.println("Departamento: " + e.getDepartamento().getNombre());
        }

        System.out.println("Rendimiento: " + e.getRendimiento());
    }

    public void reporteDepartamento(Departamento d) {

        System.out.println("Departamento: " + d.getNombre());

        for (Empleado e : d.getEmpleados()) {
            System.out.println("- " + e.getNombre());
        }

        System.out.println("Promedio rendimiento: " + d.calcularPromedio());
    }
}