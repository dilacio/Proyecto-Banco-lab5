package main;

import java.time.LocalDateTime;
import java.util.ArrayList;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.DaoCuenta;
import frgp.utn.edu.ar.dao.DaoMovimiento;
import frgp.utn.edu.ar.dao.DaoPersona;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;

public class mainApp {

	private DaoCuenta daoCuenta;

	private DaoMovimiento daoMovimiento;

	private DaoPersona daoPersona;

	public static void main(String[] args) {

		mainApp mainApp = new mainApp();
		mainApp.cargarPersonas();
		mainApp.cargarCuentas();
		mainApp.cargarMovimientos();
	}

	public void cargarMovimientos() {

		Movimiento mov = new Movimiento();
		ArrayList<Movimiento> listaMov = new ArrayList<>();

		// '1', '1000000', '0', 'Saldo Inicial', '2021-06-27T22:32:56.777', '10000'
		mov.setCbuDestino(1000000);
		mov.setCbuOrigen(1000000);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '2', '1000001', '0', 'Saldo Inicial', '2021-06-27T22:33:18.753', '10000'
		mov.setCbuDestino(1000001);
		mov.setCbuOrigen(1000001);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.00);
		listaMov.add(mov);
		mov = new Movimiento();

		// '3', '1000002', '0', 'Saldo Inicial', '2021-06-27T22:33:45.383', '10000'
		mov.setCbuDestino(1000002);
		mov.setCbuOrigen(1000002);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '4', '1000003', '0', 'Saldo Inicial', '2021-06-27T22:35:48.096', '10000'
		mov.setCbuDestino(1000003);
		mov.setCbuOrigen(1000003);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '5', '1000004', '0', 'Saldo Inicial', '2021-06-27T22:36:12.434', '10000'
		mov.setCbuDestino(1000004);
		mov.setCbuOrigen(1000004);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '6', '1000005', '0', 'Saldo Inicial', '2021-06-27T22:36:24.594', '10000'
		mov.setCbuDestino(1000005);
		mov.setCbuOrigen(1000005);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '7', '1000006', '0', 'Saldo Inicial', '2021-06-27T22:36:38.264', '10000'
		mov.setCbuDestino(1000006);
		mov.setCbuOrigen(1000006);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '8', '1000007', '0', 'Saldo Inicial', '2021-06-27T22:36:53.842', '10000'
		mov.setCbuDestino(1000007);
		mov.setCbuOrigen(1000007);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '9', '1000008', '0', 'Saldo Inicial', '2021-06-27T22:37:09.692', '10000
		mov.setCbuDestino(1000008);
		mov.setCbuOrigen(1000008);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '11', '1000009', '0', 'Saldo Inicial', '2021-06-27T22:47:05.097', '10000'
		mov.setCbuDestino(1000009);
		mov.setCbuOrigen(1000009);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		// '12', '1000010', '0', 'Saldo Inicial', '2021-06-27T22:48:12.157', '10000'
		mov.setCbuDestino(1000010);
		mov.setCbuOrigen(1000010);
		mov.setDetalle("Saldo Inicial");
		mov.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		mov.setSaldo(10000.);
		listaMov.add(mov);
		mov = new Movimiento();

		Conexion conexion = new Conexion();
		for (Movimiento movimiento : listaMov) {

			daoMovimiento = new DaoMovimiento(conexion);
			daoMovimiento.agregarMovimiento(movimiento);
		}
	}

	private void cargarCuentas() {
		// # cbu, alias, dni, estado, fechaCreacion, nroCuenta, saldo, tipoCuenta

		Cuenta cuenta = new Cuenta();
		ArrayList<Cuenta> listaCuentas = new ArrayList<>();

		// '1000000', 'perro.gato', '11111111', '0', '2021-06-27T22:32:56.681',
		// '5000000', '10000', 'Caja de ahorro en pesos'
		cuenta.setCbu(1000000);
		cuenta.setAlias("perro.gato");
		cuenta.setDni(11111111);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000000);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en pesos");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000001', 'condor.celular', '18000000', '0', '2021-06-27T22:33:18.673',
		// '5000001', '10000', 'Caja de ahorro en pesos'
		cuenta.setCbu(1000001);
		cuenta.setAlias("condor.celular");
		cuenta.setDni(18000000);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000001);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en pesos");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000002', 'pa�o.azul', '19000000', '0', '2021-06-27T22:33:45.302',
		// '5000002', '10000', 'Caja de ahorro en dolares'
		cuenta.setCbu(1000002);
		cuenta.setAlias("pato.azul");
		cuenta.setDni(19000000);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000002);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en dolares");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000003', 'cuchillo.plato', '22222222', '0', '2021-06-27T22:35:48.002',
		// '5000003', '10000', 'Caja de ahorro en dolares'
		cuenta.setCbu(1000003);
		cuenta.setAlias("perro.gato");
		cuenta.setDni(22222222);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000003);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en dolares");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000004', 'cuctenedor.cubierto', '44444444', '0', '2021-06-27T22:36:12.359',
		// '5000004', '10000', 'Caja de ahorro en dolares'
		cuenta.setCbu(1000004);
		cuenta.setAlias("cuctenedor.cubierto");
		cuenta.setDni(44444444);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000004);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en dolares");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000005', 'plato.verde', '55555555', '0', '2021-06-27T22:36:24.511',
		// '5000005', '10000', 'Caja de ahorro en pesos'
		cuenta.setCbu(1000005);
		cuenta.setAlias("plato.verde");
		cuenta.setDni(18000000);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000005);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en pesos");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000006', 'calor.frio', '66666666', '0', '2021-06-27T22:36:38.190',
		// '5000006', '10000', 'Caja de ahorro en pesos'
		cuenta.setCbu(1000006);
		cuenta.setAlias("calor.frio");
		cuenta.setDni(66666666);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000006);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en pesos");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000007', 'termo.negro', '77777777', '0', '2021-06-27T22:36:53.771',
		// '5000007', '10000', 'Caja de ahorro en pesos'
		cuenta.setCbu(1000007);
		cuenta.setAlias("termo.negro");
		cuenta.setDni(77777777);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000007);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en pesos");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000008', 'cancion.nube', '88888888', '0', '2021-06-27T22:37:09.607',
		// '5000008', '10000', 'Caja de ahorro en pesos'
		cuenta.setCbu(1000008);
		cuenta.setAlias("cancion.nube");
		cuenta.setDni(88888888);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000008);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en pesos");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000009', 'estrella.cielo', '99999999', '0', '2021-06-27T22:47:04.978',
		// '5000009', '10000', 'Caja de ahorro en dolares'
		cuenta.setCbu(1000009);
		cuenta.setAlias("estrella.cielo");
		cuenta.setDni(99999999);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000009);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en dolares");
		listaCuentas.add(cuenta);
		cuenta = new Cuenta();

		// '1000010', 'estrella.cielo', '88888888', '0', '2021-06-27T22:48:12.055',
		// '5000010', '10000', 'Caja de ahorro en dolares'
		cuenta.setCbu(1000010);
		cuenta.setAlias("estrella.cielo");
		cuenta.setDni(88888888);
		cuenta.setEstado(false);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
		cuenta.setNroCuenta(5000010);
		cuenta.setSaldo(10000.00);
		cuenta.setTipoCuenta("Caja de ahorro en dolares");
		listaCuentas.add(cuenta);

		Conexion conexion = new Conexion();
		for (Cuenta cuenta2 : listaCuentas) {

			daoCuenta = new DaoCuenta(conexion);
			daoCuenta.agregarCuenta(cuenta2);
		}

	}

	private void cargarPersonas() {
		Persona persona = new Persona();
		UsuarioLogin usuario = new UsuarioLogin();
		ArrayList<Persona> listaPersonas = new ArrayList<>();

		persona.setDni(11111111);
		persona.setApellido("Rush");
		persona.setDireccion("francia 123");
		persona.setEmail("rutrum.justo@euultricessit.com");
		persona.setEstado(false);
		persona.setFechaNacimiento("12-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Coby");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Masculino");
		// '11111111', '0', '11111111', '1', '11111111'
		usuario.setDni(11111111);
		usuario.setEstado(false);
		usuario.setPassword("11111111");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("11111111");
		persona.setUsuario(usuario);

		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();
		// '18000000', 'Mclaughlin', 'Afganistán 123',
		// 'Etiam.bibendum@nislMaecenasmalesuada.org', '0', '13-12-1990', 'capital',
		// 'Argentina', 'Ishmael', 'Buenos Aires', 'Masculino'
		persona.setDni(18000000);
		persona.setApellido("Mclaughlin");
		persona.setDireccion("francia 123");
		persona.setEmail("Etiam.bibendum@nislMaecenasmalesuada.org");
		persona.setEstado(false);
		persona.setFechaNacimiento("13-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Ishmael");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Masculino");
		// '18000000', '0', '18000000', '1', '18000000'
		usuario.setDni(18000000);
		usuario.setEstado(false);
		usuario.setPassword("18000000");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("18000000");
		persona.setUsuario(usuario);

		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();

		// '19000000', 'Steele', 'Albania 123', 'id@vitaesodales.com', '0',
		// '14-12-1990', 'capital', 'Argentina', 'Ronan', 'Buenos Aires', 'Masculino'
		persona.setDni(19000000);
		persona.setApellido("Steele");
		persona.setDireccion("Albania 123");
		persona.setEmail("ante@anteipsumprimis.com");
		persona.setEstado(false);
		persona.setFechaNacimiento("14-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Ronan");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Masculino");
		// '19000000', '0', '19000000', '1', '19000000'
		usuario.setDni(19000000);
		usuario.setEstado(false);
		usuario.setPassword("19000000");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("19000000");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();

		// '22222222', 'Dickson', 'Alemania 123', 'tortor.Nunc.commodo@Donec.org', '0',
		// '15-12-1990', 'capital', 'Argentina', 'Carter', 'Buenos Aires', 'Masculino'
		persona.setDni(22222222);
		persona.setApellido("Dickson");
		persona.setDireccion("Alemania 123");
		persona.setEmail("tortor.Nunc.commodo@Donec.org");
		persona.setEstado(false);
		persona.setFechaNacimiento("15-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Carter");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Masculino");
		// '22222222', '0', '22222222', '1', '22222222'
		usuario.setDni(22222222);
		usuario.setEstado(false);
		usuario.setPassword("22222222");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("22222222");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();

		// '33333333', 'admin', 'Andorra 123', 'admin@admin.com', '0', '16-12-1990',
		// 'capital', 'Argentina', 'admin', 'Buenos Aires', 'Masculino'
		persona.setDni(33333333);
		persona.setApellido("admin");
		persona.setDireccion("Andorra 123");
		persona.setEmail("admin@admin.com");
		persona.setEstado(false);
		persona.setFechaNacimiento("16-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("admin");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Masculino");
		// '33333333', '0', 'admin', '0', 'admin'
		usuario.setDni(33333333);
		usuario.setEstado(false);
		usuario.setPassword("admin");
		usuario.setTipoUsuario(false);
		usuario.setUsuario("admin");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();

		// '44444444', 'Obrien', 'Angola 123', 'quam.vel@lacus.org', '0', '17-12-1990',
		// 'capital', 'Argentina', 'Xerxes', 'Buenos Aires', 'Masculino'
		persona.setDni(44444444);
		persona.setApellido("Obrien");
		persona.setDireccion("Angola 123");
		persona.setEmail("quam.vel@lacus.org");
		persona.setEstado(false);
		persona.setFechaNacimiento("17-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Xerxes");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Masculino");
		// '44444444', '0', '44444444', '1', '44444444'
		usuario.setDni(44444444);
		usuario.setEstado(false);
		usuario.setPassword("44444444");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("44444444");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();

		// '55555555', 'Holden', 'Argelia 123', 'eget.odio.Aliquam@Curabitur.edu', '0',
		// '18-12-1990', 'capital', 'Argentina', 'Hunter', 'Buenos Aires', 'Femenino'
		persona.setDni(55555555);
		persona.setApellido("Holden");
		persona.setDireccion("Argelia 123");
		persona.setEmail("eget.odio.Aliquam@Curabitur.edu");
		persona.setEstado(false);
		persona.setFechaNacimiento("18-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Hunter");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Masculino");
		// '55555555', '0', '55555555', '1', '55555555'
		usuario.setDni(55555555);
		usuario.setEstado(false);
		usuario.setPassword("55555555");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("55555555");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();

		// '66666666', 'Nicholson', 'Argentina 123', 'laoreet@afacilisis.edu', '0',
		// '19-12-1990', 'capital', 'Argentina', 'Riley', 'Buenos Aires', 'Femenino'
		persona.setDni(66666666);
		persona.setApellido("Nicholson");
		persona.setDireccion("Argentina 123");
		persona.setEmail("laoreet@afacilisis.edu");
		persona.setEstado(false);
		persona.setFechaNacimiento("19-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Riley");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Femenino");
		// '66666666', '0', '66666666', '1', '66666666'
		usuario.setDni(66666666);
		usuario.setEstado(false);
		usuario.setPassword("66666666");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("66666666");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();

		// '77777777', 'Green', 'Armenia 123', 'Curabitur.egestas.nunc@ornare.edu', '0',
		// '20-12-1990', 'capital', 'Argentina', 'Brent', 'Buenos Aires', 'Femenino'
		persona.setDni(77777777);
		persona.setApellido("Green");
		persona.setDireccion("Armenia 123");
		persona.setEmail("Curabitur.egestas.nunc@ornare.edu");
		persona.setEstado(false);
		persona.setFechaNacimiento("20-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Brent");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Femenino");
		// '77777777', '0', '77777777', '1', '77777777'
		usuario.setDni(77777777);
		usuario.setEstado(false);
		usuario.setPassword("77777777");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("77777777");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);
		persona = new Persona();
		usuario = new UsuarioLogin();

		// '88888888', 'Murray', 'Australia 123', 'tempor.est.ac@loremsit.edu', '0',
		// '21-12-1990', 'capital', 'Argentina', 'Hoyt', 'Buenos Aires', 'Femenino'
		persona.setDni(88888888);
		persona.setApellido("Murray");
		persona.setDireccion("Australia 123");
		persona.setEmail("tempor.est.ac@loremsit.edu");
		persona.setEstado(false);
		persona.setFechaNacimiento("21-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Hoyt");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Femenino");
		// '88888888', '0', '88888888', '1', '88888888'
		usuario.setDni(88888888);
		usuario.setEstado(false);
		usuario.setPassword("88888888");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("88888888");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);

		persona = new Persona();
		usuario = new UsuarioLogin();

		// '99999999', 'Mclaughlin', 'Austria 123', 'Duis@sagittisDuisgravida.net', '0',
		// '22-12-1990', 'capital', 'Argentina', 'Ishmael', 'Buenos Aires', 'Femenino'*/
		persona.setDni(99999999);
		persona.setApellido("Mclaughlin");
		persona.setDireccion("Austria 123");
		persona.setEmail("Duis@sagittisDuisgravida.net");
		persona.setEstado(false);
		persona.setFechaNacimiento("12-12-1990");
		persona.setLocalidad("capital");
		persona.setNacionalidad("Argentina");
		persona.setNombre("Ishmael");
		persona.setProvincia("Buenos Aires");
		persona.setSexo("Femenino");
		// '99999999', '0', '99999999', '1', '99999999'
		usuario.setDni(99999999);
		usuario.setEstado(false);
		usuario.setPassword("99999999");
		usuario.setTipoUsuario(true);
		usuario.setUsuario("99999999");

		persona.setUsuario(usuario);
		listaPersonas.add(persona);

		Conexion conexion = new Conexion();
		for (Persona persona2 : listaPersonas) {
			daoPersona = new DaoPersona(conexion);
			daoPersona.agregarPersona(persona2);
		}
	}
}
