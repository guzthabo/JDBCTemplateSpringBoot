package springboot.example.service;

import java.util.List;

//import springboot.example.dto.UsuarioDTO;
import springboot.example.model.Usuario;

public interface UsuarioService {
	
//	public UsuarioDTO registrarUsuario(Usuario usuario);
//	public UsuarioDTO buscarPorId(Integer id);
//	public List<UsuarioDTO> listarTodos();
//	public void actualizarUsuario(Usuario usuario);
//	public void eliminarUsuario(Integer id);
	
	
	public Usuario registrarUsuario(Usuario usuario);
	public Usuario buscarPorId(Integer id);
	public List<Usuario> listarTodos();
	public void actualizarUsuario(Usuario usuario);
	public void eliminarUsuario(Integer id);
}
