package br.com.nutriseg.persistence;

import java.sql.SQLException;

import org.jcommon.encryption.SimpleMD5;

import br.com.nutriseg.model.User;

public class UserDao extends Dao{

	public String login(User user) throws ClassNotFoundException, SQLException {
		return "SUCCESS";
		/*open();
		
		ps = con.prepareStatement("select count(*) from usuario where email = ? and senha = ?;");
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		
		rs = ps.executeQuery();
		rs.next();
		String response = rs.getString("response");
		
		close();
		return response;*/
	}
	
	public User buscarLogin(String email)throws Exception{
		open();
		User user = null;
		ps = con.prepareStatement("select * from usuario where email = ?");
		ps.setString(1, email);
		
		rs = ps.executeQuery();
		if(rs.next()){
//			user = new User(rs.getInt("idusuario"), rs.getString("email"), 
//					null, rs.getString("nome"), rs.getInt("tentativa"));
			user = new User(null, "rivan@gmail.com", "123", 
					"Administrador", 0);
		}
		
		close();
		return user;
	}
	
	
}
