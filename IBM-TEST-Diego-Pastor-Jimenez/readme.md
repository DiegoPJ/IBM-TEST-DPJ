## Pasos a seguir:
1º descarga el repositorio
2º importalo 
3º compila el proyecto (clean install)
4º ejecuta el script en tu MySQL (script.sql)
5º ejecuta el comando en cmd apuntando a target :

java -jar IBM-TEST-Diego-Pastor-Jimenez-0.0.1-SNAPSHOT.jar <id_proveedor>
te generará un txt con los productos de <id_proveedor> proveedor.

El fichero plano se generará en la misma carpeta con el nombre `proveedores_<client_id>.txt`.

## Dependencias utilizadas

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

