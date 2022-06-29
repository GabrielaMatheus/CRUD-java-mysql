import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO é um objeto responsavel por se comunicar com o banco de dados;
public class ProdutoDAO {
	
	private static Connection conn;
	private static String sql;
	
	public ProdutoDAO() {
		try {
			
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos","Gabriela", "51887887806");
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		 
	}
	
	public  List<Produto> buscar() {
		sql = "select * from produto";
		try {
			 
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				ResultSet result = statement.executeQuery();
				
				List<Produto> produtos = new ArrayList<>();
				
				while(result.next()) {
					//instancia aqui pra cada vez que passar criar um novo Produto e adicionar as informações.
					Produto produto = new Produto();
					
					produto.setId(result.getInt("id")) ;
					produto.setDesc(result.getString("descricao"));
					produto.setValor(result.getDouble("valor"));
					produto.setQtd(result.getInt("qtd"));
					
					produtos.add(produto);
					
				}
				
				return produtos;
				
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
			
			
}
	
	
	
	public  List<Produto> buscarOne(Produto id) {
		sql = "select * from produto where id = ?";
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			List<Produto> produtos = new ArrayList<>();
			statement.setInt(1,id.getId());
			
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				do {
					  Produto produtoBuscar = new Produto();
						
	 		           produtoBuscar.setId(result.getInt("id")) ;
	 		           produtoBuscar.setDesc(result.getString("descricao"));
	 		           produtoBuscar.setValor(result.getDouble("valor"));
	 		           produtoBuscar.setQtd(result.getInt("qtd"));
	 					
	 				   produtos.add(produtoBuscar);
	 				   
				}while(result.next());
				
			}else {
				
				System.out.print("O ID inserido não existe.");
				
			}
			

		   return  produtos;

		
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
			
}
		


	public  void inserir(Produto produto) {
		
		sql = "insert into produto(descricao,valor,qtd) values(?,?,?)";
		
		try {
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1,produto.getDesc());
			statement.setDouble(2,produto.getValor());
			statement.setInt(3,produto.getQtd());
			
			int count = statement.executeUpdate();
			
			if(count > 0) {
				System.out.println("Inserido com sucesso! ");
			}else {
				System.out.println("Erro ao inserir. ");
			}
		
		
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
	}
	
	
	
public  void alterar(Produto produto) {
		
		sql = "UPDATE produto SET descricao = ?, valor = ?, qtd = ? WHERE id = ? ";
		
		try {
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(4,produto.getId());
			statement.setString(1,produto.getDesc());
			statement.setDouble(2,produto.getValor());
			statement.setInt(3,produto.getQtd());
			
			
			
			int count = statement.executeUpdate();
			
			if(count > 0) {
				System.out.println("Alterado com sucesso! ");
			}else {
				System.out.println("Erro ao alterar. ");
			}
		
		
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
	}



public  void remover(Produto produto) {
	
	sql = "delete from produto where id = ?";
	
	try {
	
		PreparedStatement statement = conn.prepareStatement(sql);
		
	
		statement.setInt(1,produto.getId());
		
		
		int count = statement.executeUpdate();
		
		if(count > 0) {
			System.out.println("Excluído com sucesso! ");
		}else {
			System.out.println("Erro ao excluir. ");
		}
	
	
	}catch(SQLException ex) {
		ex.printStackTrace();
		throw new RuntimeException(ex);
	}
	
}
	

}
