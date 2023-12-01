package net.pe.yallerco.segu6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Segu6Application {

	public static void main(String[] args) {
		SpringApplication.run(Segu6Application.class, args);
	}

}

/*

GET: localhost:8020/api/v1/productos
GET: localhost:8020/api/v1/productos/6
POST: localhost:8020/api/v1/productos
	{
	    "nombre": "Smartphone xx",
	    "precio": 80.00,
	    "categoriaId": 1
	}
PUT: localhost:8020/api/v1/productos/1
	{
	    "nombre": "Smartphone modificado",
	    "precio": 500.00,
	    "categoriaId": 1
	}
	
errores sale si pones una categoria que no existe
errores sale si pones un precio 0.0, debe ser mayor a 1

*/