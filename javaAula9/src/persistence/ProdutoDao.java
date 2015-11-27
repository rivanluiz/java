package persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import entity.Produto;

public class ProdutoDao extends Dao {

	public void create(Produto p) throws Exception {
		open();
		stmt = con.prepareStatement("insert into produto values(null,?,?,?,?");
		stmt.setString(1, p.getNome());
		stmt.setDouble(2, p.getPreco());
		stmt.setInt(3, p.getQuantidade());
		stmt.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(p.getDataCompra()));
		close();
	}

	public void update(Produto p) throws Exception {
		open();
		stmt = con.prepareStatement("update produto set nome=?, preco=?, quantidade=?, dataCompra=? where idProduto=?");
		stmt.setString(1, p.getNome());
		stmt.setDouble(2, p.getPreco());
		stmt.setInt(3, p.getQuantidade());
		stmt.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(p.getDataCompra()));
		close();
	}
	
	public void delete(Integer idProduto) throws Exception{
		open();
		stmt = con.prepareStatement("delete from produto where idProduto = ?");
		stmt.setInt(1, idProduto);
		stmt.execute();
		close();
	}
	
	public List<Produto> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select * from produto");
		rs = stmt.executeQuery();
		
		List<Produto> lista = new ArrayList<Produto>();
		
		while (rs.next()) {
			Produto p = new Produto();
			p.setIdProduto(rs.getInt("idProduto"));
			p.setNome(rs.getString("nome"));
			p.setPreco(rs.getDouble("preco"));
			p.setQuantidade(rs.getInt("quantidade"));
			
			int ano = new Integer(rs.getString("dataCompra").substring(0, 4));
			int mes = new Integer(rs.getString("dataCompra").substring(5, 7));
			int dia = new Integer(rs.getString("dataCompra").substring(8, 10));
			p.setDataCompra(new GregorianCalendar(ano, mes-1,dia).getTime());
			
			lista.add(p);
		}
		
		close();
		return null;
	}
	
	public Produto findById(Integer idProduto) throws Exception {
		open();
		
		stmt = con.prepareStatement("select * from produto where idProduto = ?");
		stmt.setInt(1, idProduto);
		rs = stmt.executeQuery();
		
		Produto p = null;
	
		if (rs.next()){
			p = new Produto();
			p.setIdProduto(rs.getInt("idProduto"));
			p.setNome(rs.getString("nome"));
			p.setPreco(rs.getDouble("preco"));
			p.setQuantidade(rs.getInt("quantidade"));
			
			int ano = new Integer(rs.getString("dataCompra").substring(0, 4));
			int mes = new Integer(rs.getString("dataCompra").substring(5, 7));
			int dia = new Integer(rs.getString("dataCompra").substring(8, 10));
			p.setDataCompra(new GregorianCalendar(ano, mes-1,dia).getTime());
		}
		
		close();
		return p;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
