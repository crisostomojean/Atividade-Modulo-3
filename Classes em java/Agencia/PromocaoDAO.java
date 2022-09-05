package Agencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PromocaoDAO {

	private Connection connection;

	public PromocaoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void save(Promocao promocao) {
		String sql = "INSERT INTO promocao(nome, valor, id ,fk_destino_id) VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, promocao.getNome());
			stmt.setDouble(2, promocao.getValor());
			stmt.setInt(3, promocao.getId());
			stmt.setInt(4, promocao.getDestino().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeById(int id) {
		String sql = "DELETE FROM promocao WHERE id= ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(Promocao promocao) {
		String sql = "UPDATE promocao SET nome = ? , valor = ? WHERE id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, promocao.getNome());
			stmt.setDouble(2, promocao.getValor());
			stmt.setInt(3, promocao.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet getPromocao() throws SQLException {
		String sql = "SELECT * FROM promocao";
		Statement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = connection.createStatement();
			resultado = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;

	}

}
