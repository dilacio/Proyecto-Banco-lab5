package frgp.utn.edu.ar.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;
import frgp.utn.edu.ar.entidad.enumDatos.Provincias;
import frgp.utn.edu.ar.entidad.enumDatos.Sexo;
import frgp.utn.edu.ar.entidad.enumMensajes.enumMensajes;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorCliente {

	@Autowired
	@Qualifier("servicioPersona")
	private NegPersona negocioPersona;

	@Autowired
	private Persona persona;

	@Autowired
	private UsuarioLogin usuario;

	@RequestMapping("agregarCliente.html")
	public ModelAndView eventoRedireccionarPag1(String txtEmail, Integer txtDNI, String txtNombre, String txtApellido,
			String provincia, String localidad, String sexo, String direccion, String btnCrear) {

		persona.setApellido(txtApellido);
		persona.setDni(txtDNI);
		persona.setNombre(txtNombre);
		persona.setEmail(txtEmail);
		persona.setProvincia(provincia);
		persona.setLocalidad(localidad);
		persona.setSexo(sexo);
		persona.setDireccion(direccion);
		persona.setNacionalidad("Argentina");

		usuario.setPassword(txtDNI.toString());
		usuario.setUsuario(txtDNI.toString());
		usuario.setDni(txtDNI);
		usuario.setTipoUsuario(true);
		usuario.setEstado(false);
		persona.setUsuario(usuario);

		return eventoAltaModificacionCliente(btnCrear, persona);
	}

	private ModelAndView eventoAltaModificacionCliente(String btnCrear, Persona persona) {

		ModelAndView MV = new ModelAndView();
		boolean agregarModificar = false;
		ArrayList<Persona> listaPersona = new ArrayList<>();
		try {
			if (btnCrear != null) {
				if (negocioPersona.verificarDniExistente(persona.getDni())) {
					agregarModificar = negocioPersona.agregarPersona(persona);
					listaPersona.add(persona);
					MV.addObject("mensaje", enumMensajes.ALTA_EXITOSA);
				} else {
					MV.addObject("mensaje", enumMensajes.DNI_EXISTENTE);
					listaPersona.add(persona);
				}
				MV.addObject("esNuevoCliente", true);
			} else {
				agregarModificar = negocioPersona.editarPersona(persona);
				MV.addObject("mensaje", enumMensajes.MODIFICACION_EXITOSA);
				listaPersona.add(persona);
			}

			MV.addObject("agregadoExitoso", agregarModificar);
			MV.addObject("esBotonCrear", btnCrear);
			MV.addObject("listaPersona", listaPersona);
			MV.addObject("listaProvincias", new ArrayList<Provincias>(Arrays.asList(Provincias.values())));
			MV.addObject("listaSexo", new ArrayList<Sexo>(Arrays.asList(Sexo.values())));
			MV.setViewName("AltaUsuarios");
		} catch (Exception e) {
			MV.addObject("agregadoExitoso", false);
			MV.setViewName("AltaUsuarios");
			return MV;
		}
		return MV;
	}

	@RequestMapping("agregarPersona.html")
	public ModelAndView eventoRedireccionarPag1(Integer txtDni, String txtNombre, String txtApellido) {

		ModelAndView MV = new ModelAndView();
		String cartel = "No se pudo agregar la persona";
		try {
			persona.setApellido(txtApellido);
			persona.setDni(txtDni);
			persona.setNombre(txtNombre);
			cartel = "No se pudo agregar la persona";
			if (negocioPersona.agregarPersona(persona)) {
				cartel = "La persona ha sido agregada exitosamente";
			}

		} catch (Exception e) {
			MV.addObject("estadoAgregarPersona", cartel);
			MV.setViewName("Inicio");
			return MV;
		} finally {
			MV.addObject("estadoAgregarPersona", cartel);
		}
		MV.setViewName("Inicio");
		return MV;
	}

	@RequestMapping("abmlClientes.html")
	public ModelAndView eventoRedireccionarPag1() {

		ModelAndView MV = new ModelAndView();
		try {
			ArrayList<Persona> listaPersona = new ArrayList<>();
			listaPersona = (ArrayList<Persona>) negocioPersona.listarPersonasBajaLogica();
			MV.addObject("listaPersona", listaPersona);
			MV.setViewName("ABMLClientes");
		} catch (Exception e) {
			MV.setViewName("ABMLClientes");
			return MV;
		}
		return MV;
	}

	@RequestMapping("eliminacion.html")
	public ModelAndView eliminar(Integer dni) {

		ModelAndView MV = new ModelAndView();
		try {
			negocioPersona.bajaLogica(dni);
			negocioPersona.bajaLogicabajaLogicaUsuarioLogin(dni);
			ArrayList<Integer> listaCuenta = (ArrayList<Integer>) negocioPersona.obtenerCuentaxCliente(dni);
			for (Integer cbu : listaCuenta) {
				negocioPersona.bajaLogicaCuenta(cbu);
			}
			ArrayList<Persona> listaPersona = new ArrayList<>();
			listaPersona = (ArrayList<Persona>) negocioPersona.listarPersonasBajaLogica();
			MV.addObject("listaPersona", listaPersona);
			MV.setViewName("ABMLClientes");
			return MV;

		} catch (Exception e) {
			MV.setViewName("ABMLClientes");
			return MV;
		}
	}

	@RequestMapping("ModificarCliente.html")
	public ModelAndView modificar(int dni, String nombre, String apellido, String email) {

		ModelAndView MV = new ModelAndView();
		try {
			Persona persona = negocioPersona.obtenerPersona(dni);
			ArrayList<Persona> listaPersona = new ArrayList<>();
			listaPersona.add(persona);
			MV.addObject("listaPersona", listaPersona);
			MV.addObject("listaProvincias", new ArrayList<Provincias>(Arrays.asList(Provincias.values())));
			MV.addObject("listaSexo", new ArrayList<Sexo>(Arrays.asList(Sexo.values())));
			MV.setViewName("AltaUsuarios");
			return MV;

		} catch (Exception e) {
			MV.setViewName("AltaUsuarios");
			return MV;

		}
	}

	@RequestMapping("RedireccionNuevoCliente.html")
	public ModelAndView eventoRedireccionNuevoCliente() {

		ModelAndView MV = new ModelAndView();
		try {
			ArrayList<Persona> listaPersona = new ArrayList<>();
			Persona persona = new Persona();
			listaPersona.add(persona);
			MV.addObject("listaProvincias", new ArrayList<Provincias>(Arrays.asList(Provincias.values())));
			MV.addObject("listaSexo", new ArrayList<Sexo>(Arrays.asList(Sexo.values())));
			MV.addObject("esNuevoCliente", true);
			MV.addObject("listaPersona", listaPersona);
			MV.setViewName("AltaUsuarios");
			return MV;

		} catch (Exception e) {
			MV.setViewName("AltaUsuarios");
			return MV;
		}
	}
}
