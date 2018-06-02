package klasifikacija.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import klasifikacija.entities.Aktivnost;
import klasifikacija.entities.Proces;
import klasifikacija.entities.ZbirniElement;
import klasifikacija.incomingEntities.KarakterCheckRequest;
import utils.ConnectionUtils;

public class KlasifikacijaBean {

	public <Type> void iterAdd(ResultSet rset,List<Type> aktivnosti,IterAdd<Type> lambda){
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
			
			iterAdd(rset, toReturn, (ResultSet reset,List<Aktivnost> toAdd)->{
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
			
			iterAdd(rset, toReturn, (ResultSet reset,List<Proces> toAdd)->{
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
			
			iterAdd(rset, toReturn, (ResultSet reset,List<ZbirniElement> toAdd)->{
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
	
	public List<ZbirniElement> otpadSaKarakterom(String karakter,String kolona){
		List<ZbirniElement> toReturn = new LinkedList<>();
		ResultSet rset=null;
		Connection con = ConnectionUtils.getConnection();
		Statement stm = null;
		try {
			stm = con.createStatement();
			rset = stm.executeQuery("select * from zbirni_katalog");
			
			iterAdd(rset, toReturn, (ResultSet reset,List<ZbirniElement> toAdd)->{
				ZbirniElement elem = new ZbirniElement();
				try {
					if(reset.getString(kolona).equals(karakter)){
						elem.setKarakter(reset.getString("KARAKTER"));
						elem.setOpis(reset.getString("OPIS"));
						elem.setIndeksDelaProcesa(reset.getString("INJDEKS_DPN"));
						elem.setIndeksAktivnosti(reset.getString("INDEKS_A"));
						elem.setIndeksProcesa(reset.getString("INDEKS_PNO"));
						toAdd.add(elem);
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	
	public List<String> checkStatus(List<KarakterCheckRequest> forChecking){
		
		
		List<String> toReturn = new ArrayList<>();
		ResultSet rset;
		Connection con = ConnectionUtils.getConnection();
		Statement stat = null;
		try {
			stat= con.createStatement();
			rset = stat.executeQuery("select * from zbirni_katalog");
			
			iterAdd(rset, toReturn, (ResultSet reset,List<String> toAdd)->{
				String ind1,ind2,ind3;
				ind1 = null;
				ind2 = null;
				ind3 = null;
				try {
					ind1 = rset.getString("INDEKS_A");
					ind2 = rset.getString("INDEKS_PNO");
					ind3 = rset.getString("INJDEKS_DPN");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				boolean added = false;
				
				for(KarakterCheckRequest cr: forChecking){
					if(cr.getIndeksA().equals(ind1) && cr.getIndeksProces().equals(ind2) && cr.getIndeksDeo().equals(ind3)){
						try {
							toAdd.add(rset.getString("KARAKTER"));
							added = true;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
				
				//redosled ovoga nije dobar ??
				if(!added){
					toAdd.add("Nepoznat otpad");
				}
				
			});
			
			rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return toReturn;
	}
	
}
