package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import entities.Aktivnost;
import entities.Proces;
import entities.ZbirniElement;
import utils.ConnectionUtils;

public class KlasifikacijaBean {

	public <Type> void iterAddAktivnost(ResultSet rset,List<Type> aktivnosti,IterAdd<Type> lambda){
		try {
			while(rset.next()){
				lambda.iterAndAdd(rset, aktivnosti);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Aktivnost> getAktivnosti(){
		
		List<Aktivnost> toReturn = new LinkedList<>();
		ResultSet rset=null;
		Connection con = ConnectionUtils.getConnection();
		Statement stm = null;
		try {
			stm = con.createStatement();
			rset = stm.executeQuery("select * from aktivnost");
			
			iterAddAktivnost(rset, toReturn, (ResultSet reset,List<Aktivnost> toAdd)->{
				Aktivnost a = new Aktivnost();
				try {
					a.setIndeks(reset.getString(1));
					a.setOpis(reset.getString(2));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				toReturn.add(a);
			});
			
			stm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

	
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public List<Proces> getProcesi(){
		List<Proces> toReturn = new LinkedList<>();
		ResultSet rset=null;
		Connection con = ConnectionUtils.getConnection();
		Statement stm = null;
		try {
			stm = con.createStatement();
			rset = stm.executeQuery("select * from proces_nastajanja_otpada");
			
			iterAddAktivnost(rset, toReturn, (ResultSet reset,List<Proces> toAdd)->{
				Proces p = new Proces();
				try {
					p.setIndeksAktivnosti(reset.getString(1));
					p.setIndeksProcesa(reset.getString(2));
					p.setOpis(reset.getString(3));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				toReturn.add(p);
			});
			
			stm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

	
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}

	
	public List<ZbirniElement> getZbirnaLista(){
		
		List<ZbirniElement> toReturn = new LinkedList<>();
		ResultSet rset=null;
		Connection con = ConnectionUtils.getConnection();
		Statement stm = null;
		try {
			stm = con.createStatement();
			rset = stm.executeQuery("select * from zbirni_katalog as zk left OUTER JOIN proces_nastajanja_otpada as pno on zk.INDEKS_A=pno.INDEKS_A and zk.INDEKS_PNO = pno.INDEKS_PNO UNION select * from zbirni_katalog as zk right OUTER JOIN proces_nastajanja_otpada as pno on zk.INDEKS_A=pno.INDEKS_A and zk.INDEKS_PNO = pno.INDEKS_PNO");
			
			iterAddAktivnost(rset, toReturn, (ResultSet reset,List<ZbirniElement> toAdd)->{
				ZbirniElement elem = new ZbirniElement();
				try {
					String check = reset.getString(2);
					
					if(check == null){
						//onda je element liste sa 2 dela primarnog kljuca od 3
						elem.setKarakter(null);
						elem.setOpis(reset.getString(11));
					}else{
						//onda je kompletan 
						elem.setKarakter(reset.getString(6));
						elem.setOpis(reset.getString(8));
						elem.setIndeksDelaProcesa(reset.getString(2));
					}
					elem.setIndeksAktivnosti(reset.getString(9));
					elem.setIndeksProcesa(reset.getString(10));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				toAdd.add(elem);
			});
			
			stm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

	
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
}
