package brokerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.theplu.MyRestApp;
import org.theplu.controllers.ZahteviController;

import com.google.gson.Gson;

import brokerUtils.listServices.BrokerListServicesResponse;
import brokerUtils.listServices.Service;
import controllers.KlasifikacijaController;
import controllers.PostrojenjaController;
import controllers.TestController;

public class BrokerUtils {

	
	private static final String brokerIP = "http://192.168.99.100:8000";
	private static final String userName = "Ekologija";
	private static final String email = "kurjak9595@gmail.com";
	private static final String password = "password";
	private static String[] premissions = new String[1];//nemamo dozvole
	private static int id = 0;
	
	public static int getID(){
		return id++;
	}
	
	public static String getJsonResponse(HttpResponse response){
		BufferedReader rdr = null;
		try {
			rdr = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		} catch (UnsupportedOperationException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuffer buf = new StringBuffer();
		
		try {
			while(rdr.ready()){
				buf.append(rdr.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rdr.toString();
	}
	
	public static void initService(){
		String id = getOurID("ekologija");
		String token = getToken();
	
		Set<String> registeredServices,ourServices;
		registeredServices = new HashSet<>();
		ourServices = new HashSet<>();
		
		registeredServices.addAll(getRegisteredServices(id,token));
		ourServices.addAll(getOurServices());
		
		ourServices.removeAll(registeredServices); //razlika nasih i registrovanih servisa
		registerMissing(ourServices,id,token);
	}
	
	public static void registerMissing(Collection<String> missing,String ourID,String token){
		
		System.out.println("registrujem");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost createServices = new HttpPost(brokerIP+"/services/"+ourID);
		createServices.addHeader("Authorization",token);
		Gson g = new Gson();
		
		int counter = 0;
		
		CreateService serReq = new CreateService();
		List<brokerUtils.Service> ffs = new LinkedList<>();
		
		missing.forEach((String str)->{
			brokerUtils.Service service = new brokerUtils.Service();
			//moramo da oduzmemo /rest deo
			service.setName("ekologija "+getID());
			service.setRoute(str.substring(5, str.length()));
			service.setMethod(ReflectUtils.getMethod(str.substring(5+1, str.length())));
			serReq.getServices().add(service);
			ffs.add(service);
		});
		
		/*
		 * Ne radi u bulk dodavanju ?
		 */
		
		try {
			createServices.setEntity(new StringEntity(g.toJson(serReq)));
			HttpResponse response = client.execute(createServices);
			BrokerListServicesResponse blsr = new BrokerListServicesResponse();
			BufferedReader rdr = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer buf = new StringBuffer();
			
			while(rdr.ready()){
				buf.append(rdr.readLine());
			}
			
			System.out.println("Gor response "+buf.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<String> getOurServices(){
		
		Gson g = new Gson();
		List<String> toReturn = new LinkedList<>();
		
		List<Method> metode = new LinkedList<>();

		Class<MyRestApp> klasa = MyRestApp.class;
		
		String path = klasa.getAnnotation(ApplicationPath.class).value();
		
		ReflectUtils.getMethodsAnnotatedWith(KlasifikacijaController.class, Path.class).forEach((Method m)->{
			toReturn.add(path+"/klasifikacija"+m.getAnnotation(Path.class).value());
		});
		
		ReflectUtils.getMethodsAnnotatedWith(PostrojenjaController.class,Path.class).forEach((Method m)->{
			toReturn.add(path+"/postrojenja"+m.getAnnotation(Path.class).value());
		});
		
	
		ReflectUtils.getMethodsAnnotatedWith(TestController.class,Path.class).forEach((Method m)->{
			toReturn.add(path+"/test"+m.getAnnotation(Path.class).value());
		});
		
		ReflectUtils.getMethodsAnnotatedWith(ZahteviController.class,Path.class).forEach((Method m)->{
			toReturn.add(path+"/zahtevi"+m.getAnnotation(Path.class).value());
		});
		
		return toReturn;
	}
	
	public static List<String> getRegisteredServices(String id,String token){
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getServices = new HttpGet(brokerIP+"/services/"+id);
		getServices.addHeader("Authorization",token);
		Gson g = new Gson();
		List<String> toReturn = new LinkedList<>();
		try {
			HttpResponse listServicesResponse = client.execute(getServices);
			BufferedReader rdr = new BufferedReader(new InputStreamReader(listServicesResponse.getEntity().getContent()));
			StringBuffer buf = new StringBuffer();
			
			while(rdr.ready()){
				buf.append(rdr.readLine());
			}
			
			BrokerListServicesResponse lres = g.fromJson(buf.toString(), BrokerListServicesResponse.class);
			
			for(Service ser:lres.getResult().getServices()){
				toReturn.add(ser.getRoute());// NE PRAVIMO RAZLIKU IZMEDJU RUTA SA RAZLICITIM METODAMA POZIVA
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public static boolean registerDefaultUser(){
		
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost registerReq = new HttpPost(brokerIP+"/users/register");
		Gson g = new Gson();
		BrokerRegisterRequest brokerRegReq = new BrokerRegisterRequest();
		brokerRegReq.setUsername(userName);
		brokerRegReq.setEmail(email);
		brokerRegReq.setPassword(password);
		brokerRegReq.setPermissions(null);
		brokerRegReq.setName("Ekologija");
		
		
		HttpEntity ent;
		
		try {
			ent = new StringEntity(g.toJson(brokerRegReq));
			registerReq.setEntity(ent);
			HttpResponse regResponse = client.execute(registerReq);
			BrokerRegisterResponse resp;
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public static String getOurID(String ourName){
		
		String token = getToken();
		Gson g = new Gson();
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getProviders = new HttpGet(brokerIP+"/providers");
		getProviders.addHeader("Authorization",token);
		
		try {
			HttpResponse response = client.execute(getProviders);
			BufferedReader rdr = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer buf = new StringBuffer();
			
			while(rdr.ready()){
				buf.append(rdr.readLine());
			}
			
			String test = buf.toString();
			
			ListProvidersResponse resp = g.fromJson(buf.toString(), ListProvidersResponse.class);
			Result ourService;
			
			for(Result res :resp.getResult()){
				if(res.getName().equals(ourName)){
					return res.getId();
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String getToken(){
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost loginRequest = new HttpPost(brokerIP+"/users/login");
		Gson g = new Gson();
		HttpEntity ent;
		try {
			ent = new StringEntity(g.toJson(new UserLogin(email, password)));
			loginRequest.setEntity(ent);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String token = null;
		try {
			HttpResponse response = client.execute(loginRequest);

			BufferedReader rdr = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer buf = new StringBuffer();
			
			while(rdr.ready()){
				buf.append(rdr.readLine());
			}
			
			BrokerLoginResponse resp = g.fromJson(buf.toString(), BrokerLoginResponse.class);
			token = resp.getResult().getToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}
	
	public static boolean login(){
		
		HttpGet request;
		
		return false;
	}
	
}
