package principal;

public class Principal {

	import java.util.Scanner;

import clase.Tren;

	public static void main(String[] args) {
		//menu 
		Scanner teclado = new Scanner(System.in);
		int opc ;
		
		//importar clase
		Tren[] tren =new Tren [30];
		int numTrenes =0;
		
		do {
			menu();
		    if(numTrenes== 0 &&(opc>2 && opc<6)) {
		    	System.out.println("No hay ningun tren introducido");
		    }else {
			    
				switch (opc) {
				case 1:
					introducirTrenes(tren, numTrenes);
					break;
	
				case 2:
					mostrarTrenesConVelocidadSuperiorA(tren, numTrenes);
					break;
					 
				case 3:
					ordenarTrenesSegunDuracion(tren, numTrenes);
					break;
	
				case 4:
					reservaAsientos(tren, numTrenes);
					break;
	
				case 5:
					mostrarTrenesIntroducidos(tren, numTrenes);
					break;
					
				case 6:
					
					break;
					
				default:
					System.out.println("ERROR");
					break;
				}
		    }
		} while (opc != 6);

		teclado.close();

	}
	//CASE 4***
	private static void reservaAsientos(Tren[] trenes, int numTrenes) {
		Scanner teclado = new Scanner(System.in);
		String ref;
		int asientos;
		String proceso= "correcto";
		
		System.out.println("Introduce referencia");
		ref=teclado.next();
		
		for(int i=0; i<numTrenes; i++) {
			if(trenes[i].getRefencia().equalsIngnoreCase(ref)) {
				proceso="encontrado";
				if(!trenes[i].trenLleno()) {
					proceso="dispolibilidad";
					System.out.println("Introducce el numero de asientos que quiere reservar");
					asientos= teclado.nextInt();
					if((trenes[i].getAsientosOcupados()+asientos)<Tren.CAPACIDAD_MAXIMA) {
						trenes[i].setAsientosOcupados(asientos+trenes[i].getAsientosOcupados());
						proceso="correcto";
					}
				}
			}
		}
		if(proceso.equalsIgnoreCase("correcto")) {
			System.out.println("Actualizacion realizada con exito");
		}else if (proceso.equalsIgnoreCase("disponibilidad")) {
			System.out.println("ERROR no hay tantos asientos disponibles en este tren ");
		}else if (proceso.equalsIgnoreCase("encontrado")) {
			System.out.println("Tren lleno");
		}else  {
			System.out.println("Tren no encontrado");
		}
			
		}
	}
	//CASE 3***
	private static void ordenarTrenesSegunDuracion(Tren[] trenes, int numTrenes) {
		Tren inter;
		
	
		for(int i=0; i< numTrenes-1;i++) {
			for(int j=i+1; j<numTrenes; j++) {
				if (trenes[j].getDuracionViaje()<trenes[i].getDuracionViaje()) {
					inter= trenes[i];
					trenes[i]= trenes[j];
					trenes[j]= inter;
				}
			}
			if(trenes[i].getTipo().equalsIgnoreCase("Cercanias"));
				System.out.println(trenes[i]);
		}
	}
	//CASO 2***
    private static void mostrarTrenesConVelocidadSuperiorA(Tren[] trenes, int numTrenes) {
    	Scanner teclado = new Scanner(System.in);
    	float velocidad;
    	boolean encontrado= false;
    	
    	System.out.println("Introduce un a velocidad");
    	velocidad=teclado.nextInt();
    	
    	for(int i =0; i<numTrenes; i++) {
    		if(trenes[i].obtenerVelocidad()>velocidad) {
    			System.out.printf("Este tren con refencia %s tiene una velocidad de %.2f ", trenes[i].getRefencia());
    			encontrado=true;
    		}
    	}
		if(!encontrado) {
			System.out.println("No hay ninguno que cumpla la condicion");
		}
	}
    //CASO 5***
	private static void mostrarTrenesIntroducidos(Tren[] trenes, int numTrenes) {
		for(int i=0; i<numTrenes; i++ ) {
			System.out.println(trenes[i]);
		}
		
	}
	//CASO 1***
	private static void introducirTrenes(Tren[] trenes, int numTrenes) {
		Scanner teclado = new Scanner(System.in);
		boolean seguir=true;
		String tipo;
		Tren tren ;
		
		for (;numTrenes<trenes.length && seguir;) {
			System.out.println("Introduce el tipo");
			tipo =teclado.next();
			
			tren = new Tren(tipo);
			tren.setDatos();
			trenes[numTrenes]=tren;
			numTrenes++;
		 
			System.out.println("Quieres seguir introduciendo trenes?");
			seguir=teclado.next().equalsIgnoreCase("si");
		}
		// mensaje de limite de trenes sobrepasado
		if(numTrenes>=trenes.length) {
			System.out.println("LIMITE SOBREPASADO DE TRENES");
		}
	}
    // MENU
	private static void menu() {
		System.out.println("");
		System.out.println("Elija una opcion");
		System.out.println("*****MENU*****");
		System.out.println("1. Introducir trenes");
		System.out.println("2. Mostrar los trenes que superen una velocidad dada  ");
		System.out.println("3.Ordenar los trenes de cercanias por duracion del viaje");
		System.out.println("4. Reserva de asientos");
		System.out.println("5. Mostrar todos los trenes introducidos");
		System.out.println("6. SALIR");
	}


