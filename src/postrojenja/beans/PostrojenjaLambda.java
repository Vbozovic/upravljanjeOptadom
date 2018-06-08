package postrojenja.beans;

import java.sql.ResultSet;
import java.util.List;

public interface PostrojenjaLambda<Type> {

	public Type addWhileIter(ResultSet incomingData);
	
}
