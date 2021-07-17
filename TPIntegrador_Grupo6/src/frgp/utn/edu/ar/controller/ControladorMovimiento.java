package frgp.utn.edu.ar.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.enumMensajes.enumMensajes;
import frgp.utn.edu.ar.negocio.NegCuenta;
import frgp.utn.edu.ar.negocio.NegMovimiento;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorMovimiento {

	@Autowired
	@Qualifier("servicioMovimiento")
	private NegMovimiento negocioMovimiento;

	@Autowired
	private NegCuenta negocioCuenta;
	
	@Autowired
	private Cuenta cuentaDestino;
	
	@Autowired
	private Cuenta cuenta;
	
	@Autowired
	private NegPersona negocioPersona;
	
	@Autowired
	private Persona personaDestino;
	
	@Autowired
	private Movimiento Movimiento;
	
	@Autowired
	private Persona persona;
	
	@RequestMapping(value = "buscarSaldo.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView eventoRedireccionar(int cuentas, int CBU, int SaldoTransferir, String Comentario,
			HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView MV = new ModelAndView();
		if (cuentas != 0) {
			cuentaDestino = negocioPersona.obtenerCuentaxCbu(CBU);
			if (cuentaDestino != null) {

				personaDestino = negocioPersona.obtenerPersona(cuentaDestino.getDni());

				cuenta = negocioCuenta.buscarSaldo(cuentas);

				HttpSession misession = (HttpSession) request.getSession();
				Persona Persona = (Persona) misession.getAttribute("Usuario");
				ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());

				MV.addObject("listaCuenta", listaCuenta);
				MV.addObject("cuenta", cuenta);
				MV.addObject("personaDestino", personaDestino);
				MV.addObject("CuentaDestino", cuentaDestino);
				MV.addObject("SaldoTransferir", SaldoTransferir);
				MV.addObject("Comentario", Comentario);
				MV.setViewName("Transferencia");
				return MV;

			} else {
				HttpSession misession = (HttpSession) request.getSession();
				Persona Persona = (Persona) misession.getAttribute("Usuario");
				ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());
				Cuenta cuenta = negocioCuenta.buscarSaldo(cuentas);
				MV.addObject("listaCuenta", listaCuenta);
				MV.addObject("cuenta", cuenta);
				MV.addObject("SaldoTransferir", SaldoTransferir);
				MV.addObject("Comentario", Comentario);
				MV.setViewName("Transferencia");
				MV.addObject("mensaje", enumMensajes.CBU_INCORRECTO);
				return MV;
			}

		} else {
			HttpSession misession = (HttpSession) request.getSession();
			Persona Persona = (Persona) misession.getAttribute("Usuario");
			ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());
			MV.addObject("cuentaSeleccionada", cuentas);
			MV.addObject("listaCuenta", listaCuenta);
			MV.addObject("SaldoTransferir", SaldoTransferir);
			MV.addObject("Comentario", Comentario);
			MV.setViewName("Transferencia");
			MV.addObject("mensaje", enumMensajes.SELECCIONAR_CUENTA);
			return MV;
		}

	}

	@RequestMapping(value = "TransferirDinero.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView Transferir(int CBU, int CBUOrigen, int SaldoTransferir, String Comentario,
			HttpServletRequest request, HttpServletResponse response) {
		Cuenta CuentaOrigen = negocioPersona.obtenerCuentaxCbu(CBUOrigen);

		if (CuentaOrigen.getSaldo() != 0 && CuentaOrigen.getSaldo() >= SaldoTransferir) {

			if (CBU == CBUOrigen) {

				HttpSession misession = (HttpSession) request.getSession();
				Persona Persona = (Persona) misession.getAttribute("Usuario");
				ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());
				cuenta = negocioCuenta.buscarSaldo(CBUOrigen);
				cuentaDestino = negocioPersona.obtenerCuentaxCbu(CBU);
				personaDestino = negocioPersona.obtenerPersona(cuentaDestino.getDni());
				ModelAndView MV = new ModelAndView();
				MV.addObject("cuenta", cuenta);
				MV.addObject("personaDestino", personaDestino);
				MV.addObject("listaCuenta", listaCuenta);
				MV.addObject("CuentaDestino", cuentaDestino);
				MV.addObject("SaldoTransferir", SaldoTransferir);
				MV.addObject("Comentario", Comentario);
				MV.setViewName("Transferencia");
				MV.addObject("mensaje", enumMensajes.TRANSFERIR_MISMA_CUENTA);
				return MV;
			} else {
				double SaldoParaMovimiento = SaldoTransferir;
				Cuenta CuentaDestino = negocioPersona.obtenerCuentaxCbu(CBU);
				Persona personaDestino = negocioPersona.obtenerPersona(CuentaDestino.getDni());
				double SaldoCuentaDestino = CuentaDestino.getSaldo();
				SaldoCuentaDestino += SaldoTransferir;
				CuentaDestino.setSaldo(SaldoCuentaDestino);
				negocioCuenta.actualizarSaldo(CuentaDestino);

				double SaldoCuentaOrigen = CuentaOrigen.getSaldo();
				SaldoCuentaOrigen = SaldoCuentaOrigen - SaldoTransferir;
				CuentaOrigen.setSaldo(SaldoCuentaOrigen);
				negocioCuenta.actualizarSaldo(CuentaOrigen);

				Movimiento.setCbuOrigen(CuentaOrigen.getCbu());
				Movimiento.setCbuDestino(CuentaDestino.getCbu());
				Movimiento.setDetalle(Comentario);
				Movimiento.setSaldo(-SaldoParaMovimiento);
				Movimiento.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
				negocioMovimiento.agregarMovimiento(Movimiento);

				Movimiento.setCbuOrigen(CuentaDestino.getCbu());
				Movimiento.setCbuDestino(CuentaOrigen.getCbu());
				Movimiento.setDetalle(Comentario);
				Movimiento.setSaldo(SaldoParaMovimiento);
				Movimiento.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
				negocioMovimiento.agregarMovimiento(Movimiento);

				Cuenta cuenta = negocioCuenta.buscarSaldo(CBUOrigen);

				HttpSession misession = (HttpSession) request.getSession();
				Persona Persona = (Persona) misession.getAttribute("Usuario");
				ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());

				ModelAndView MV = new ModelAndView();
				MV.addObject("cuenta", cuenta);
				MV.addObject("personaDestino", personaDestino);
				MV.addObject("listaCuenta", listaCuenta);
				MV.addObject("CuentaDestino", CuentaDestino);
				MV.addObject("SaldoTransferir", SaldoTransferir);
				MV.addObject("Comentario", Comentario);
				MV.setViewName("Transferencia");
				MV.addObject("mensaje", enumMensajes.TRANSFERENCIA_EXITOSA);
				return MV;

			}

		} else {
			cuentaDestino = negocioPersona.obtenerCuentaxCbu(CBU);
			personaDestino = negocioPersona.obtenerPersona(cuentaDestino.getDni());

			HttpSession misession = (HttpSession) request.getSession();
			persona = (Persona) misession.getAttribute("Usuario");
			ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(persona.getDni());

			cuenta = negocioCuenta.buscarSaldo(CBUOrigen);

			ModelAndView MV = new ModelAndView();
			MV.addObject("cuenta", cuenta);
			MV.addObject("listaCuenta", listaCuenta);
			MV.addObject("personaDestino", personaDestino);
			MV.addObject("CuentaDestino", cuentaDestino);
			MV.addObject("SaldoTransferir", SaldoTransferir);
			MV.addObject("Comentario", Comentario);
			MV.setViewName("Transferencia");
			MV.addObject("mensaje", enumMensajes.SALDO_INSUFICIENTE);
			return MV;
		}

	}

}
