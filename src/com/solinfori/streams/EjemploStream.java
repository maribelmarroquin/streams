package com.solinfori.streams;

import java.util.ArrayList;
import java.util.List;

public class EjemploStream {

	private List<String> lista;
	private List<String> numeros;

	public EjemploStream() {
		lista = new ArrayList<>();
		lista.add("Maribel");
		lista.add("Guadalupe");
		lista.add("Marroquín");
		lista.add("Caratachea");
		lista.add("SOLINFORI");

		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");

	}

	private void filtrar() {
		System.out.println("\n-------Filtrar-------");
		lista.stream().filter(x -> x.startsWith("M")).forEach(System.out::println);
		//Impresión con expresion lambda
		//lista.stream().filter(x -> x.startsWith("M")).forEach(x->System.out.println(x));
	}

	private void ordenar() {
		System.out.println("\n-------Ordenar-------");
		System.out.println("* Ascendente:");
		lista.stream().sorted().forEach(System.out::println);
		System.out.println("\n* Descendente:");
		lista.stream().sorted((x, y)->y.compareTo(x)).forEach(System.out::println);
	}

	private void transformar() {
		System.out.println("\n------Transformar-----");
		//Map es una función de tranformación y va a ser transformado con la expresión que indique
		lista.stream().map(String::toUpperCase).forEach(System.out::println);
		
		//transformando la lista "numeros" string a entero y sumar un número adicional.
		//Forma tradicional:
		for (String x : numeros) {
			int num = Integer.parseInt(x)+1;
			System.out.println(num);
		} 
		
		//Utilizando streams
		numeros.stream().map(x -> Integer.parseInt(x)+1).forEach(System.out::println);
		
	}

	private void limitar() {
		System.out.println("\n-------Limitar-------");
		lista.stream().limit(2).forEach(System.out::println);
	}

	private void contar() {
		System.out.println("\n-------Contar-------");
		long x = lista.stream().count();
		System.out.println(x);
	}

	public static void main(String[] args) {
		EjemploStream app = new EjemploStream();
		app.filtrar();
		app.ordenar();
		app.transformar();
		app.limitar();
		app.contar();
	}
}
