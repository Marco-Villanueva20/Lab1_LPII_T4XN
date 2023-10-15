package views;
import controllers.EmpleadoController;
public class EmpleadoView {
public static void main(String[] args) {
	String empleado;
	//Create   C
	//empleado = new EmpleadoController().createEmpleado("Garcia Ramirez", "Jeison", 23,"Masculino" , 2300.40);
	empleado = new EmpleadoController().createEmpleado("Garcia", "Jeison", 23,"Masculino" , 2300.40);
	System.out.println(empleado);
	
	//Read   R
	empleado = new EmpleadoController().getEmpleado(1);
	System.out.println(empleado);
	
	//Update U
	empleado = new EmpleadoController().updateEmpleado(1, "Lopez Flores");
	System.out.println(empleado);
	
	//Delete D
	empleado = new EmpleadoController().deleteEmpleado(2);
	System.out.println(empleado);
}
}
