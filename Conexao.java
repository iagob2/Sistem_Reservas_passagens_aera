package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/dados";
    private static final String USUARIO = "root";
    private static final String SENHA = "Kansas4580#";

    // Método para obter a conexão com o banco de dados
    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

