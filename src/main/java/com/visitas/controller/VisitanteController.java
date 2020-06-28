package com.visitas.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visitas.model.entities.AccesoVisitante;
import com.visitas.model.entities.Eps;
import com.visitas.model.entities.Visitante;
import com.visitas.model.service.AccesoVisitanteServiceImp;
import com.visitas.model.service.EpsServiceImp;
import com.visitas.model.service.VisitanteServiceImp;

@Controller
public class VisitanteController {

	@Autowired
	private EpsServiceImp<Eps> epsService;

	@Autowired
	private VisitanteServiceImp<Visitante> visitanteService;

	@Autowired
	private AccesoVisitanteServiceImp<AccesoVisitante> accesoVisitante;
	
	@RequestMapping(value = "/qr")
	public String qr() {
		return "qrscan";
	}

	@RequestMapping(value = "/RegistroVisitante")
	public String registro(Map<String, Object> model, Principal principal) {
		if (principal != null) {
			Visitante v = new Visitante();
			model.put("epss", epsService.findAll());
			model.put("visitante", v);
			return "registroVisitante";
		}

		return "redirect:login";
	}

	@RequestMapping(value = "/registrar-visitante")
	public String ingreso(@RequestParam(name = "doc") String doc, @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "fechanacimiento") String fecha, @RequestParam(name = "eps") String ideps,
			@RequestParam(name = "genero") String genero, @RequestParam(name = "temperatura") String temp, Model model)
			throws ParseException {

		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
		Date fechanacimiento = objSDF.parse(fecha);
		Visitante v = buscarVisitante(doc);
		AccesoVisitante ac = buscarAcceso(v);
		if (v == null) {
			ac = new AccesoVisitante();
			v = new Visitante();
			v.setDocumento(doc);
			if (Integer.parseInt(ideps) > 0) {
				v.setEps(epsService.findOne(Integer.parseInt(ideps)));}
			v.setFechanacimiento(fechanacimiento);
			v.setGenero(genero);
			v.setNombre(nombre);
			ac.setFecha(new Date());
			ac.setTemperatura(Float.parseFloat(temp));
			ac.setVisitante(v);

			visitanteService.save(v);
			accesoVisitante.save(ac);
			model.addAttribute("respuesta", "Registro exitoso");
		} else if(v!=null && ac==null){
			ac = new AccesoVisitante();
			ac.setFecha(new Date());
			ac.setTemperatura(Float.parseFloat(temp));
			ac.setVisitante(v);
			accesoVisitante.save(ac);
			model.addAttribute("respuesta", "Registro exitoso");			
		}else {
			model.addAttribute("respuesta", "El vistante ya se enecontraba registrado");
		}
		model.addAttribute("epss", epsService.findAll());
		return "registroVisitante";
	}

	@RequestMapping(value = "/buscarVisitante", method = RequestMethod.POST)
	private String buscar(@RequestParam(name = "documento") String doc, Model model) {
		Visitante v = buscarVisitante(doc);
		if (v == null) {
			System.out.println("pails");
			System.out.println(doc);
			v = new Visitante();
			model.addAttribute("epss", epsService.findAll());
			model.addAttribute("respuesta", " no se encontro resultados");
			return "registroVisitante";
		}
		System.out.println("bien");
		System.out.println(doc);
		model.addAttribute("visitante", v);		
		model.addAttribute("epss", epsService.findAll());

		return "registroVisitante2";
	}

	private AccesoVisitante buscarAcceso(Visitante v) {
		for (AccesoVisitante ac : accesoVisitante.findAll()) {
			if (ac.getVisitante() == v) {
				if (ac.getFecha().equals(new Date())) {
					return ac;
				}
			}
		}

		return null;
	}

	private Visitante buscarVisitante(String doc) {
		for (Visitante v : visitanteService.findAll()) {
			if (v.getDocumento().equals(doc)) {
				return v;
			}
		}

		return null;
	}
}
