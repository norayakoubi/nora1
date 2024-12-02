package clase;

import java.util.Scanner;

/*
 * EJERCICIO 1
Crea una clase llamada Tren que tendrá los siguientes atributos [0,5p]:
tipo (Cercanías, Ave o Mercancías)
referencia
asientos ocupados
km recorridos
duración del viaje (en minutos)
Crea dos constructores distintos que cumplan con las siguientes condiciones: que el atributo tipo del tren sea
obligatorio y que, si no se corresponde con uno de los tres valores posibles, se le asigne el valor “Indefinido”. [0,5p]
Crear sus respectivos métodos get y set correspondientes para cada atributo. [0,25p]
Crear el método que muestre todos los datos del tren [0,25p]
Tendrá dos métodos especiales[1,5p]:
trenLLeno(): este método devuelve un valor booleano que nos indica si el tren está o no lleno. La capacidad máxima
de un tren es de 400 viajeros (este valor lo guardaremos en una constante para su tratamiento).
obtenerVelocidadTotal(): este método nos devuelve la velocidad en Km/h del tren. Teniendo en cuenta que la
duración del viaje viene expresada en minutos, la velocidad se obtiene de dividir los kilómetros recorridos entre la
duración del viaje expresado en horas.
EJERCICIO 2
Una vez creada la clase anterior y utilizando cuando se precise, los métodos en ella implementados, vamos a diseñar
un programa que gestione todos los trenes con salida desde Bilbao (máximo 30).
El programa tendrá un menú repetitivo como se especifica a continuación: [0,25p]
1. Introducir los trenes. [1p]
Podemos introducir hasta 30 trenes, pero no tenemos que introducirlos todos a la vez. Controlar que no se
metan más de 30.
2. Mostrar los trenes que superen una velocidad dada. [1,25p]
Pediremos por pantalla la velocidad. Vamos a mostrar todos los trenes cuya velocidad sea superior a la
introducida. De cada tren solo queremos visualizar la información de su referencia y velocidad.
Si no existe ningún tren que supere dicha velocidad, mostraremos un mensaje informando de este hecho.
3. Ordenar los trenes de cercanías por duración del viaje. [1,25p]
Ordenamos los trenes por duración del viaje de menor a mayor, y mostraremos solo los que son de Cercanías.
4. Reserva de asientos. [1,25p]
Se pide la referencia del tren, si existe y no está lleno, se le pedirá al usuario el nº de asientos que quiere reservar.
Se le indicará si es o no posible (en función de los asientos disponibles en ese momento) y si todo es correcto, se
actualizará la información de los asientos ocupados del tren. Mensaje de aviso si no se puede llevar a cabo la
reserva por no encontrarse el tren buscado o estar lleno.
5. Mostrar todos los trenes que se han introducido. [1p]
Se ha de mostrar toda la información respectiva al tren.
6. Salir

 */
public class Tren {
	Scanner teclado = new Scanner(System.in);

	//constante
	final public static int CAPACIDAD_MAXIMA = 400;
	
	//atributos siempre private
	private String tipo;
	private String referencias;
	private int asientosOcupados;
	private int kmRecorridos;
	private int duracionViaje;
	
	//constructores (source-- generate constructor ussing fields)
	public Tren(String tipo, String referencias, int asientosOcupados, int kmRcorridos, int duracionViaje) {
		this.tipo = tipo;
		if (!(tipo.equalsIgnoreCase("Cercanias") || tipo.equalsIgnoreCase("Mercancias")||tipo.equalsIgnoreCase("Ave") )) {
			tipo="Indefinido";
		}
		this.referencias = referencias;
		this.asientosOcupados = asientosOcupados;
		this.kmRecorridos = kmRcorridos;
		this.duracionViaje = duracionViaje;
	}
	//me pide el tipo y me lo comprueva 
	public Tren(String tipo, String referencias, int asientosOcupados, int kmRecorridos, int duracionViaje) {
		this.tipo = tipo;
		if (!(tipo.equalsIgnoreCase("Cercanias") || tipo.equalsIgnoreCase("Mercancias")||tipo.equalsIgnoreCase("Ave") )) {
			tipo="Indefinido";
		}
		this.referencias = "";
		this.asientosOcupados = 0;
		this.kmRecorridos = 0;
		this.duracionViaje = 0;
		
	}
	
	//generate getter and setters
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getReferencias() {
		return referencias;
	}
	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}
	public int getAsientosOcupados() {
		return asientosOcupados;
	}
	public void setAsientosOcupados(int asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}
	public int getKmRcorridos() {
		return kmRecorridos;
	}
	public void setKmRcorridos(int kmRcorridos) {
		this.kmRecorridos = kmRcorridos;
	}
	public int getDuracionViaje() {
		return duracionViaje;
	}
	public void setDuracionViaje(int duracionViaje) {
		this.duracionViaje = duracionViaje;
	}
	
	// metodos propios
	
	public String  trenLleno() {
		return asientosOcupados=CAPACIDAD_MAXIMA;
	}
	public float obtenerVelocidad() {
		return kmRecorridos/duracionViaje/60;
	}
	public void setDatos() {
		System.out.println("Introduce refencia");
		referencias = teclado.next();
		System.out.println("Introduce asientos Ocupados");
		asientosOcupados = teclado.next();
		
	}
	public Object getRefencia() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
