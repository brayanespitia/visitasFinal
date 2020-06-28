package com.visitas.controller;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
import com.visitas.model.entities.Acceso;
import com.visitas.model.entities.Basico;
import com.visitas.model.entities.Cormobilidad;
import com.visitas.model.entities.Eps;
import com.visitas.model.entities.Modalidad;
import com.visitas.model.entities.Registro;
import com.visitas.model.entities.Tipo;
import com.visitas.model.entities.Usuario;
import com.visitas.model.entities.Visitante;
import com.visitas.model.service.AccesoServiceImp;
import com.visitas.model.service.BasicoServiceImp;
import com.visitas.model.service.CormobilidadServiceImp;
import com.visitas.model.service.EpsServiceImp;
import com.visitas.model.service.ModalidadServiceImp;
import com.visitas.model.service.RegistroServiceImp;
import com.visitas.model.service.TipoServiceImp;
import com.visitas.model.service.UsuarioServiceImp;
import com.visitas.model.service.VisitanteServiceImp;

@Controller
public class UsuarioController {
	
	@Autowired
	AccesoServiceImp<Acceso> accesoService; 

	
	@Autowired
	private CormobilidadServiceImp<Cormobilidad> cormobilidadService;
	
	@Autowired
	private BasicoServiceImp<Basico> basicoService;

	@Autowired
	private RegistroServiceImp<Registro> registroService;
	
	@Autowired
	private EpsServiceImp<Eps> epsService;

	@Autowired
	private TipoServiceImp<Tipo> tipoService;

	@Autowired
	private ModalidadServiceImp<Modalidad> modalidadService;

	@Autowired
	private VisitanteServiceImp<Visitante> visitanteService;

	@Autowired
	private UsuarioServiceImp<Usuario> usuarioService;

	

	@RequestMapping(value = "/registro-personas")
	private String registrar(Model model) {

		model.addAttribute("modalidades", modalidadService.findAll());
		model.addAttribute("tipos", tipoService.findAll());
		model.addAttribute("epss", epsService.findAll());
		return "datosPersonales";
	}

	@RequestMapping(value = "/lecturaIngreso")
	private String lectura(Model model) {
		return "lecturaIngreso";
	}
	
	@RequestMapping(value = "/guardar-datos")
	private String personales(@RequestParam(name = "embarazada", required = false)String en,
			@RequestParam(name = "docu")String doc,
			@RequestParam(name = "nombre")String nombre,
			@RequestParam(name = "fechanacimiento")String fecha,
			@RequestParam(name = "eps")String eps,
			@RequestParam(name = "tipo")String tipo,
			@RequestParam(name = "genero")String genero,
			@RequestParam(name = "telefono")String telefono,
			@RequestParam(name = "mod")String mod,
			Model model) throws ParseException{
		
		
		RestTemplate plantilla = new RestTemplate();
		String resultado = plantilla.getForObject("http://siaweb.ufps.edu.co/prueba.php?documento=" + doc,
				String.class);
		JSONObject jasonObject = new JSONObject(resultado);
		if(jasonObject.getBoolean("error")) {
			model.addAttribute("respuesta","esta persona no pertenece a la institución");
			model.addAttribute("modalidades", modalidadService.findAll());
			model.addAttribute("tipos", tipoService.findAll());
			model.addAttribute("epss", epsService.findAll());
			return "datosPersonales";
		}else {
		
		Cormobilidad cor= new Cormobilidad();
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
		Date fechanacimiento = objSDF.parse(fecha);
		
		Registro r = new Registro();
		Basico b= new Basico();
		
		if(en!=null)b.setEmbarazo((byte) 1);
	
		b.setDocumento(doc);		
		b.setEps(epsService.findOne(Integer.parseInt(eps)));
		b.setModalidadBean(modalidadService.findOne(Integer.parseInt(mod)));
		b.setGenero(genero);

		b.setTipoBean(tipoService.findOne(Integer.parseInt(tipo)));
		b.setFechanacimiento(fechanacimiento);
		b.setNombre(nombre);
		b.setTelefono(telefono);					
		basicoService.save(b);
		model.addAttribute("idb", idbasico(b));		
		return "datosPersonas";}
	}
	@RequestMapping(value = "/guardar-persona")
	private String personas(@RequestParam(name = "60", required = false)String mas60,
			@RequestParam(name = "15", required = false)String men15,
			@RequestParam(name = "salud", required = false)String salud,
			@RequestParam(name = "contacto")String contacto,
			@RequestParam(name = "telefono2")String telefono,
			@RequestParam(name = "idbas")String basic,
			Model model) {
		
		Basico b = basicoService.findOne(Integer.parseInt(basic));
		if(mas60!=null)b.setMas60((byte) 1);
		if(men15!=null)b.setMenos15((byte)1);
		if(salud!=null)b.setSalud((byte)1);
		b.setContactotelefono(telefono);
		b.setContactonombre(contacto);
		basicoService.save(b);
		model.addAttribute("idb", idbasico(b));	
		return "datosCormobilidades";
	}
	
	@RequestMapping(value = "/guardar-cormobilidades")
	private String cormobilidades(@RequestParam(name = "diabestes", required = false)String diabe,
			@RequestParam(name = "cardiov", required = false)String cardio,
			@RequestParam(name = "accidente", required = false)String accid,			
			@RequestParam(name = "vih", required = false)String vih,
			@RequestParam(name = "cancer", required = false)String cancer,
			@RequestParam(name = "corticoides", required = false)String cort,
			@RequestParam(name = "obstructiva", required = false)String obst,
			@RequestParam(name = "nutricion", required = false)String nutri,
			@RequestParam(name = "fuma", required = false)String fuma,
			@RequestParam(name = "idbas")String idbas,Model model) {
		
		
		
		Basico b = basicoService.findOne(Integer.parseInt(idbas));
		
		Cormobilidad cor= new Cormobilidad();
		cor.setId(b.getId());		
		
		if(diabe!=null)cor.setDiabetes((byte)1);
		if(cardio!=null)cor.setCardio((byte)1);
		if(accid!=null)cor.setCerebro((byte)1);
		if(vih!=null)cor.setVih((byte)1);
		if(cancer!=null)cor.setCancer((byte)1);
		if(cort!=null)cor.setCorticoides((byte)1);
		if(obst!=null)cor.setEpoc((byte)1);
		if(nutri!=null)cor.setNutricion((byte)1);
		if(fuma!=null)cor.setFumador((byte)1);
		
		cormobilidadService.save(cor);
		model.addAttribute("idb", idbasico(b));
		return "datosRegistro";
	}
	
	@RequestMapping(value = "/guardar-registro3")
	public String gg(Model model) {
		return "datosPersonales";
	}
	
	
	@RequestMapping(value = "/guardar-registro")
	public String registro(@RequestParam(name = "tos", required = false)String tos,
			@RequestParam(name = "malestar", required = false)String malestar,
			@RequestParam(name = "fatiga", required = false)String fatiga,			
			@RequestParam(name = "secrecion", required = false)String secrecion,
			@RequestParam(name = "garganta", required = false)String garganta,
			@RequestParam(name = "respirar", required = false)String respirar,			
			@RequestParam(name = "idbas")String idbas,
			Model model) {
		System.out.println(0);
		
		Basico b = basicoService.findOne(Integer.parseInt(idbas));		
		System.out.println(1);
		Registro re= new Registro();
		System.out.println(2);
		Acceso a = new Acceso();
		System.out.println(3);
		re.setBasico(b);
		System.out.println(4);
		if(tos!=null)re.setTos((byte)1);
		if(malestar!=null)re.setMalestar((byte)1);
		if(fatiga!=null)re.setFatiga((byte)1);
		if(secrecion!=null)re.setNasal((byte)1);
		if(garganta!=null)re.setGarganta((byte)1);
		if(respirar!=null)re.setDificultad((byte)1);		
		re.setFecha(new Date());
		System.out.println(5);
		a.setRegistro(re);		
		System.out.println(5);
		registroService.save(re);
		System.out.println(7);
		accesoService.save(a);
		model.addAttribute("respuesta","registro exitoso");
		return "datosPersonales";
	}
	
	
	@RequestMapping(value = "/buscaPersona")
	public String buscap(@RequestParam(name = "documento")String doc,Model model) {
		Acceso a = new Acceso();
		
		Basico ba= buscarPersona(doc);
		if(ba!=null) {
			if(buscarAcceso(registroService.findOne(ba.getId()))==0) {
				a.setRegistro(registroService.findOne(ba.getId()));			
				accesoService.save(a);
				model.addAttribute("respuesta","registro exitoso");
				return "datosPersonales";
			}
			model.addAttribute("modalidades", modalidadService.findAll());
			model.addAttribute("tipos", tipoService.findAll());
			model.addAttribute("epss", epsService.findAll());
			model.addAttribute("respuesta","ya se habia registrado el dia de hoy");
			return "datosPersonales";
		}
		model.addAttribute("modalidades", modalidadService.findAll());
		model.addAttribute("tipos", tipoService.findAll());
		model.addAttribute("epss", epsService.findAll());
		model.addAttribute("respuesta","por favor registrese");
		return "datosPersonales";
	}
	
	@RequestMapping(value = "/registrar-ingreso")
	public String ingreso(@Validated Usuario usuario
							, Model model) {
		
		
		return "redirect:lecturaImgreso";
	}

	private Basico buscarPersona(String doc) {
		for(Basico b: basicoService.findAll()) {
			if(b.getDocumento().equals(doc)){
				return b;
			}
		}
		return null;
	}
	
	
	private int buscarAcceso(Registro r) {
		for(Acceso a: accesoService.findAll()) {
			if(a.getRegistro()==r && a.getFechareg()!= new Date() ) {
				return 1;
			}
		}
		return 0;
	}

	private int idbasico(Basico b) {
		for(Basico bas: basicoService.findAll()) {
			if(bas.getDocumento()==b.getDocumento()) {
				return bas.getId();
			}
		}
		return -1;
	}
	
}
