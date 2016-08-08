package springboot.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import springboot.example.dto.UsuarioDTO;
import springboot.example.model.Usuario;
import springboot.example.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	@ResponseBody
	public List<Usuario> listarTodos() {
		return service.listarTodos();
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Usuario buscarPorId(@PathVariable("id") int id) {
		return service.buscarPorId(id);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	@ResponseBody
	public Usuario registrarUsuario(@RequestBody Usuario usuario) {
		return service.registrarUsuario(usuario);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public void actualizarUsuario(@RequestBody Usuario usuario) {
		service.actualizarUsuario(usuario);
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public void eliminarUsuario(@PathVariable("id") int id) {
		service.eliminarUsuario(id);
	}
}
