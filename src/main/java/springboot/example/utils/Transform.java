package springboot.example.utils;

import springboot.example.dto.UsuarioDTO;
import springboot.example.model.Usuario;

@Deprecated
public class Transform {

	public static UsuarioDTO transformUsuario(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getId());
		dto.setNombre(usuario.getNombre());
		dto.setApellido(usuario.getApellido());
		dto.setEmail(usuario.getEmail());
		return dto;
	}
}
