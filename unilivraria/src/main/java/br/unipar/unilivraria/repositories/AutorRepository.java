package br.unipar.unilivraria.repositories;

import br.unipar.unilivraria.domain.Autor;
import br.unipar.unilivraria.infraestructure.ConnectionFactory;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutorRepository {

    private static final String INSERT =
            "insert into autor (nome) values (?)";

    public Autor inserir(Autor autor) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new ConnectionFactory().getConnection();

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }

    }

}
