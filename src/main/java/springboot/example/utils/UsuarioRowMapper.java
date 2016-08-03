package springboot.example.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springboot.example.model.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario user = new Usuario();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setNombre(rs.getString("nombre"));
		user.setApellido(rs.getString("apellido"));
		return user;
	}

}
