package ua.nure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO implements UserInterface {
	private static MySQLUserDAO dao = null;
	private MySQLUserDAO() {
		
	}

	public static MySQLUserDAO getInctance() {
		if(dao == null) {
			dao = new MySQLUserDAO();
		}return dao;
	}
	
	@Override
	public List<User> getAllUsers() {
String url = "jdbc:mysql://localhost/GamesDB?user=root&password=root";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement stm1 = null;
		try {
			 stm1 = con.prepareStatement("SELECT * FROM USER");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stm1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		    stm1.close();
		} catch (SQLException e111) {
		    // TODO Auto-generated catch block
		    e111.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e111) {
			// TODO Auto-generated catch block
			e111.printStackTrace();
		}
		
		List<User> list=new ArrayList<User>();
		return list;
		
	}

	@Override
	public void addUser(User user) {
		String url = "jdbc:mysql://localhost/GamesDB?user=root&password=root";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement stm = null;
		try {
			 stm = con.prepareStatement("INSERT INTO USER (Nickname, email, Phone) VALUES (?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			stm.setString(1, user.getNicke());
			stm.setString(2, user.getEmail());
			stm.setString(3, user.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stm.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		    stm.close();
		} catch (SQLException e111) {
		    // TODO Auto-generated catch block
		    e111.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e111) {
			// TODO Auto-generated catch block
			e111.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User userhave, User userwant) {
String url = "jdbc:mysql://localhost/GamesDB?user=root&password=root";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement s = null;





		try {
			s = con.prepareStatement("UPDATE `mydb`.`user` SET `Nickname`=?, `Phone`=?, `email`=? WHERE  `Nickname`=? AND`Phone`=? AND `email`=? ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


try {
	s.setString(1, userwant.getNicke());
	s.setString(2, userwant.getPhone());
	s.setString(3, userwant.getEmail());
	s.setString(4, userhave.getNicke());
	s.setString(5, userhave.getPhone());
	s.setString(6, userhave.getEmail());

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
s.executeUpdate();
} catch (SQLException e10) {
// TODO Auto-generated catch block
e10.printStackTrace();
}
try {
    s.close();
} catch (SQLException e111) {
    // TODO Auto-generated catch block
    e111.printStackTrace();
}
try {
	con.close();
} catch (SQLException e111) {
	// TODO Auto-generated catch block
	e111.printStackTrace();
}
		
	}

	@Override
	public void deleteUser(User usertodel) {
String url = "jdbc:mysql://localhost/GamesDB?user=root&password=root";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement s1 = null;


        try {
			s1 = con.prepareStatement("DELETE FROM `mydb`.`user` WHERE `Nickname`=? AND`Phone`=? AND `email`=?"); //
		} catch (SQLException e21) {
			// TODO Auto-generated catch block
            e21.printStackTrace();
        }



try {
	s1.setString(1, usertodel.getNicke());
	s1.setString(2, usertodel.getPhone());
	s1.setString(3, usertodel.getEmail());
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
    s1.close();
} catch (SQLException e111) {
    // TODO Auto-generated catch block
    e111.printStackTrace();
}
		
		try {
			con.close();
		} catch (SQLException e111) {
			// TODO Auto-generated catch block
			e111.printStackTrace();
		}
		
	}

}
