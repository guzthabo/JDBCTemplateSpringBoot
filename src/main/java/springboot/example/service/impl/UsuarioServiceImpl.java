package springboot.example.service.impl;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.example.dao.UsuarioDAO;
//import springboot.example.dto.UsuarioDTO;
import springboot.example.model.Usuario;
import springboot.example.service.UsuarioService;
//import springboot.example.utils.Transform;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		Usuario newUsuario = dao.insert(usuario);
//		if (newUsuario != null) {
//			UsuarioDTO dto = Transform.transformUsuario(newUsuario);
//			return dto;
//		}
		return newUsuario;
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		Usuario result = dao.getById(id);
//		if (result != null) {
//			UsuarioDTO dto = Transform.transformUsuario(result);
//			return dto;
//		}
		return result;
	}

	@Override
	public List<Usuario> listarTodos() {
		List<Usuario> result = dao.findAll();
//		if (!result.isEmpty()) {
//			List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
//			for (Usuario u : result) {
//				usuarios.add(Transform.transformUsuario(u));
//			}
//			return usuarios;
//		}
		return result;
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		dao.update(usuario);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		dao.delete(id);
	}

}
