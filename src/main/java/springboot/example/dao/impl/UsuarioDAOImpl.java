package springboot.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import springboot.example.dao.UsuarioDAO;
import springboot.example.model.Usuario;

//import springboot.example.utils.UsuarioRowMapper;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Usuario insert(Usuario usuario) {

		final String sql = "insert into usuario(email, nombre, apellido) values(?,?,?)";

		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, usuario.getEmail());
				ps.setString(2, usuario.getNombre());
				ps.setString(3, usuario.getApellido());
				return ps;
			}

		}, holder);

		int newUserId = holder.getKey().intValue();
		usuario.setId(newUserId);

		return usuario;
	}

	@Override
	public Usuario getById(Integer id) {
		return jdbcTemplate.queryForObject("select * from usuario where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}

	@Override
	public List<Usuario> findAll() {
		return jdbcTemplate.query("select * from usuario", new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}

	@Override
	public void update(Usuario usuario) {
		jdbcTemplate.update("update usuario set nombre = ?, apellido = ?, email = ? where id = ?",
				new Object[] { usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getId() });

	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from usuario where id = ?", new Object[] { id });
	}

}
