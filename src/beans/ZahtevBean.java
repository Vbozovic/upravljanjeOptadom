package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import entities.Dozvola;
import entities.Izdavac;
import entities.PodnosiocZahteva;
import entities.Postrojenja;
import entities.ZahtevZaDozvolu;
import utils.ConnectionUtils;

public class ZahtevBean {
	
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
	
	public List<Dozvola> getDozvole() {
		
		Connection c = ConnectionUtils.getConnection();
		Statement statement = null;
		List<Dozvola> dozvole = new LinkedList<>();
		ResultSet rset=null;
		
		try {
			
			statement = c.createStatement();
			rset = statement.executeQuery("SELECT * FROM dozvola");
			
			iterAdd(rset, dozvole, (ResultSet reset,List<Dozvola> toAdd)->{
				Dozvola dozvola = new Dozvola();
				try {
					dozvola.setBrojDozvole(reset.getInt("BROJ_DOZVOLE"));
					dozvola.setIdIzdavaca(reset.getInt("ID_IZDAVACA"));
					dozvola.setKodDozvole(reset.getString("KOD_DOZVOLE"));

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dozvole.add(dozvola);
			});
				
			statement.close();
			
		} catch (SQLException e) {
			
			System.out.println("Doslo je do greske, gtfo m8");
			
		} finally {
			
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dozvole;		
		
	}

	public List<Izdavac> getIzdavaci() {
		
		Connection c = ConnectionUtils.getConnection();
		Statement statement = null;
		List<Izdavac> izdavaci = new LinkedList<>();
		ResultSet rset=null;
		
		try {
			
			statement = c.createStatement();
			rset = statement.executeQuery("SELECT * FROM izdavac");
			
			iterAdd(rset, izdavaci, (ResultSet reset,List<Izdavac> toAdd)->{
				Izdavac izdavac = new Izdavac();
				try {
					izdavac.setIdIzdavaca(reset.getInt("ID_IZDAVACA"));
					izdavac.setNazivIzdavaca(reset.getString("NAZIV_IZDAVACA"));

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				izdavaci.add(izdavac);
			});
				
			statement.close();
			
		} catch (SQLException e) {
			
			System.out.println("Doslo je do greske, gtfo m8");
			
		} finally {
			
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return izdavaci;		
		
	}
	
	public List<ZahtevZaDozvolu> getZahtevi() {
		
		Connection c = ConnectionUtils.getConnection();
		Statement statement = null;
		List<ZahtevZaDozvolu> zahtevi = new LinkedList<>();
		ResultSet rset=null;
		
		try {
			
			statement = c.createStatement();
			rset = statement.executeQuery("SELECT * FROM zahtev_za_dozvolu");
			
			iterAdd(rset, zahtevi, (ResultSet reset,List<ZahtevZaDozvolu> toAdd)->{
				ZahtevZaDozvolu zahtev = new ZahtevZaDozvolu();
				try {
					zahtev.setIdPostrojenja(reset.getInt("BROJ_ZAHTEVA"));
					zahtev.setNazivPodnosioca(reset.getString("NAZIV_PODNOSIOCA3"));
					zahtev.setIdPostrojenja(reset.getInt("ID_POSTROJENJA"));
					zahtev.setKodDozvole(reset.getString("KOD_DOZVOLE"));
					zahtev.setOdobren(reset.getInt("ODOBREN"));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				zahtevi.add(zahtev);
			});
				
			statement.close();
			
		} catch (SQLException e) {
			
			System.out.println("Doslo je do greske, gtfo m8");
			
		} finally {
			
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return zahtevi;
	}
	
	public List<PodnosiocZahteva> getPodnosioci() {
		
		Connection c = ConnectionUtils.getConnection();
		Statement statement = null;
		List<PodnosiocZahteva> podnosioci = new LinkedList<>();
		ResultSet rset=null;
		
		try {
			
			statement = c.createStatement();
			rset = statement.executeQuery("SELECT * FROM podnosioc_zahteva");
			
			iterAdd(rset, podnosioci, (ResultSet reset,List<PodnosiocZahteva> toAdd)->{
				PodnosiocZahteva pz = new PodnosiocZahteva();
				try {					
					pz.setNazivPodnosioca(reset.getString("NAZIV_PODNOSIOCA3"));
					pz.setImeOdgovornogLica(reset.getString("IME_ODGOVORNOG_LICA3"));
					pz.setPrezimeOdgovornogLica(reset.getString("PREZIME_ODGOVORNOG_LICA3"));
					pz.setAdresaLica(reset.getString("ADRESA_LICA3"));
					pz.setBrojTelefona(reset.getString("BROJ_TELEFONA3"));
					pz.setBrojFaksa(reset.getString("BROJ_FAKSA3"));
					pz.setEmailOdgovornogLica(reset.getString("EMAIL_ODGOVORNOG_LICA3"));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				podnosioci.add(pz);
			});
				
			statement.close();
			
		} catch (SQLException e) {
			
			System.out.println("Doslo je do greske, gtfo m8");
			
		} finally {
			
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return podnosioci;	
	}
	
	public List<ZahtevZaDozvolu> getZahteviPodnosioca(String nazivPodnosioca){
		
		Connection c = ConnectionUtils.getConnection();
		Statement statement = null;
		ResultSet rset=null;
		List<ZahtevZaDozvolu> zahteviPodnosioca = new LinkedList<>();
		
		//String kveri = "SELECT * FROM zahtev_za_dozvolu WHERE NAZIV_PODNOSIOCA = " + nazivPodnosioca;
		String kveri = "SELECT * FROM zahtev_za_dozvolu";
		
		try {
			
			statement = c.createStatement();
			rset = statement.executeQuery(kveri);
			
			iterAdd(rset, zahteviPodnosioca, (ResultSet reset,List<ZahtevZaDozvolu> toAdd)->{
				ZahtevZaDozvolu zahtev = new ZahtevZaDozvolu();
				try {
					if(reset.getString("NAZIV_PODNOSIOCA3").equals(nazivPodnosioca)) {
						
						zahtev.setBrojZahteva(reset.getInt("BROJ_ZAHTEVA"));
						zahtev.setNazivPodnosioca(reset.getString("NAZIV_PODNOSIOCA3"));
						zahtev.setIdPostrojenja(reset.getInt("ID_POSTROJENJA"));
						zahtev.setKodDozvole(reset.getString("KOD_DOZVOLE"));
						zahtev.setOdobren(reset.getInt("ODOBREN"));						

						zahteviPodnosioca.add(zahtev);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
				
			statement.close();
			
		} catch (SQLException e) {
			
			System.out.println("Doslo je do greske, gtfo m8");
			
		} finally {
			
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return zahteviPodnosioca;	
		
	}
	
	public List<Postrojenja> getZahteviPostrojenja(int idPostrojenja){
		
		Connection c = ConnectionUtils.getConnection();
		Statement statement = null;
		ResultSet rset=null;
		List<Postrojenja> postrojenja = new LinkedList<>();
		
		String kveri = "SELECT * FROM postrojenje_za_upravljanje_otpadom WHERE ID_POSTROJENJA = " + idPostrojenja;
		
		try {
			
			statement = c.createStatement();
			rset = statement.executeQuery(kveri);
			
			iterAdd(rset, postrojenja, (ResultSet reset,List<Postrojenja> toAdd)->{
				Postrojenja postrojenje = new Postrojenja();
				try {
					

						postrojenje.setIdPostrojenja(reset.getInt("ID_POSTROJENJA"));
						postrojenje.setIdTipa2(reset.getInt("ID_TIPA2"));
						postrojenje.setJmbg(reset.getString("JMBG"));
						postrojenje.setImeLica(reset.getString("IME_LICA"));
						postrojenje.setUkupanKapacitet(reset.getInt("UKUPAN_KAPACITET"));						

						postrojenja.add(postrojenje);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
				
			statement.close();
			
		} catch (SQLException e) {
			
			System.out.println("Doslo je do greske, gtfo m8");
			
		} finally {
			
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return postrojenja;	
		
	}
	
	/*
	public ZahtevZaDozvolu dodajZahtev(ZahtevZaDozvolu zahtev) {
		
		String nazivPodnosioca = zahtev.getNazivPodnosioca();
		int idPostrojenja = zahtev.getIdPostrojenja();
		String kodDozvole  = zahtev.getKodDozvole();
		
		ResultSet rset = null;
		ResultSet rset2 = null;
		ResultSet rset3 = null;
		ResultSet rset4 = null;
		Connection con = ConnectionUtils.getConnection();
		Statement statement = null;
		PreparedStatement ps = null;
		
		try {
			
			statement = con.createStatement();
			rset = statement.executeQuery("SELECT * FROM podnosioc_zahteva WHERE `NAZIV_PODNOSIOCA3` =" + nazivPodnosioca);
			rset2 = statement.executeQuery("SELECT * FROM postrojenje_za_upravljanje_otpadom WHERE `ID_POSTROJENJA` =" + idPostrojenja);
			rset3 = statement.executeQuery("SELECT * FROM tip_dozvole WHERE `KOD_DOZVOLE` =" + kodDozvole);
			
			
			if (rset.next() && rset2.next() && rset3.next()) {
				
				ps = con.prepareStatement("INSERT into zahtev_za_dozvolu (`NAZIV_PODNOSIOCA3`, `ID_POSTROJENJA`, `KOD_DOZVOLE`, `ODOBREN`)" + "VALUES(?,?,?,?)");
				ps.setString(1, nazivPodnosioca);
				ps.setInt(2, idPostrojenja);
				ps.setString(3,	kodDozvole);
				ps.setBoolean(4, false);
				
				rset4 = ps.executeQuery();
				
			} else {
				
				System.out.println("HAHAHA REKT SON");
				
			}
			

			statement.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				rset.close();
				rset2.close();
				rset3.close();
				rset4.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				statement.close();
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

		return zahtev;
	}
	*/

}
