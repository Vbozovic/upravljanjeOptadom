package postrojenja.beans;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import postrojenja.entities.Postrojenje;
import postrojenja.entities.ZbirniElement;
import postrojenja.incomingEntities.TypeSearch;
import utils.ConnectionUtils;

public class PostrojenjeBean {

	private <Type> void iterAndAdd(String query,List<Type> toAdd,PostrojenjaLambda<Type> lambda) throws SQLException{
		Connection con = ConnectionUtils.getConnection();
		Statement stm = con.createStatement();
		ResultSet rset = stm.executeQuery(query);
		
		while(rset.next()){
			toAdd.add(lambda.addWhileIter(rset));
		}
		
		stm.close();
		rset.close();
		con.close();
	}
	
	private Postrojenje standardPostrojenje(ResultSet incomingData){
		Postrojenje p = new Postrojenje();
		try {
			p.setIdPostrojenja(Integer.parseInt(incomingData.getString("ID_POSTROJENJA")));
			p.setGrad(incomingData.getString("NAZIV_GRADA"));
			p.setTipOtpada(incomingData.getString("NAZIV2"));
			p.setImeZaduzenog(incomingData.getString("IME_LICA"));
			p.setOpstina(incomingData.getString("NAZIV_OPSTINE"));
			p.setJmbgZaduzenog(incomingData.getString("JMBG"));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
	
	public List<Postrojenje> getPostrojenja(){
		List<Postrojenje> svaPostrojenja = new LinkedList<>();
		String query = "select * from postrojenje_za_upravljanje_otpadom";
		try {
			iterAndAdd(query, svaPostrojenja, (ResultSet incomingData)->{
				return standardPostrojenje(incomingData);
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return svaPostrojenja;
	}
	
	//Ne moze kolona da bude int !!!
	public List<Postrojenje> getPostrojenjaSaKolonaEquals(String kolona,String equals){
		List<Postrojenje> lista = new LinkedList<>();
		String query = String.format("select * from postrojenje_za_upravljanje_otpadom where %s = %s",kolona,"'"+equals+"'");
		try {
			iterAndAdd(query,lista,(ResultSet incomingData)->{
				return standardPostrojenje(incomingData);
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Postrojenje> getPostrojenjaSaKolonaEquals(String kolona,int equals){
		List<Postrojenje> lista = new LinkedList<>();
		String query = String.format("select * from postrojenje_za_upravljanje_otpadom where %s = %s",kolona,equals);
		try {
			iterAndAdd(query,lista,(ResultSet incomingData)->{
				return standardPostrojenje(incomingData);
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Postrojenje> getPostrojenjaSaTipom(TypeSearch ts){
		List<Postrojenje> lista = new LinkedList<>();
		String kolona = "NAZIV2";
		String query = String.format("select * from postrojenje_za_upravljanje_otpadom join tip_postorjenja on postrojenje_za_upravljanje_otpadom.ID_TIPA2 = tip_postorjenja.ID_TIPA2 where tip_postorjenja.%s = %s",kolona,"'"+ts.getKarakter()+"'");
		try {
			iterAndAdd(query,lista,(ResultSet incomingData)->{
				Postrojenje p = new Postrojenje();
				p = standardPostrojenje(incomingData);
				p.setTipOtpada(ts.getKarakter());
				return p;
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<ZbirniElement> inventarZaSpecificnoPostrojenje(int idPostrojenja){
		List<ZbirniElement> stanje = new LinkedList<>();

		String query = "select * from inventar_postrojenja join zbirni_katalog on inventar_postrojenja.INDEKS_A = zbirni_katalog.INDEKS_A and inventar_postrojenja.INDEKS_KO = zbirni_katalog.INDEKS_KO and inventar_postrojenja.INDEKS_PNO = zbirni_katalog.INDEKS_PNO and inventar_postrojenja.INJDEKS_DPN = zbirni_katalog.INJDEKS_DPN where inventar_postrojenja.ID_POSTROJENJA = "+idPostrojenja;
		
		try {
			iterAndAdd(query, stanje, (ResultSet incoming)->{
				ZbirniElement elem = new ZbirniElement();
				try {
					elem.setIndeksAktivnosti(incoming.getString("INDEKS_A"));
					elem.setIndeksProcesa(incoming.getString("INDEKS_PNO"));
					elem.setIndeksDelaProcesa(incoming.getString("INJDEKS_DPN"));
					elem.setKolicina(incoming.getInt("KOLICINA_OTPADA"));
					elem.setKategorijaOtpada(incoming.getString("INDEKS_KO"));
					elem.setKarakter(incoming.getString("KARAKTER"));
					elem.setOpis(incoming.getString("OPIS"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return elem;
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return stanje;
	}
	
	//Svo djubre u opstini nekoj ili u gradu
	public List<ZbirniElement> inventarZaPostrojenjaColumnEqual(String column,String equal){
		
		return null;
	}
	
	public List<Postrojenje> getPostrojenjaJoinOnColumnEquals(String joinWith,String column,String equals){
		List<Postrojenje> toReturn = new LinkedList<>();
		String query;
		PostrojenjaLambda<Postrojenje> lambda;
		
		if(column == null){
			//query = String.format("select * from postrojenje_za_upravljanje_otpadom", args);
		}else{
			
		}
		
		return toReturn;
	}
}
