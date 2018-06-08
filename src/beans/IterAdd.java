package beans;

import java.sql.ResultSet;
import java.util.List;

public interface IterAdd<Type> {

	public void iterAndAdd(ResultSet rset,List<Type> list);
	
}