package springboot.example.dao;

import java.util.List;

import springboot.example.model.Usuario;

public interface UsuarioDAO {
	
	public Usuario insert(Usuario usuario);
	public Usuario getById(Integer id);
	public List<Usuario> findAll();
	public void update(Usuario usuario);
	public void delete(Integer id);
	
}
