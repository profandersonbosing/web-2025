package br.unipar.unilivraria.repositories;

import br.unipar.unilivraria.domain.Autor;
import br.unipar.unilivraria.infraestructure.ConnectionFactory;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorRepository {

    private static final String INSERT =
            "insert into autor (nome) values (?)";

    private static final String UPDATE =
            "update autor set nome = ? where id = ?";

    private static final String FIND_ALL =
            "select id, nome from autor";

    private static final String DELETE_BY_ID =
            "delete from autor where id = ?";

    public Autor inserir(Autor autor) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, autor.getNome());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            rs.next();
            autor.setId(rs.getInt(1));

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }

        return autor;
    }

    public void editar(Autor autor) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, autor.getNome());
            pstmt.setInt(2, autor.getId());
            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }

    public List<Autor> buscarTodos() throws SQLException, NamingException {
        List<Autor> autores = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                autores.add(autor);
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }

        return autores;
    }

    public void deletar(Integer id) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }

    }

    public List<Autor> buscarPorNome(String nome) throws SQLException, NamingException {
        List<Autor> autores = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();

            String query = FIND_ALL + " where nome like '%"+nome+"%'";

            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                autores.add(autor);
            }

        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }

        return autores;
    }

}