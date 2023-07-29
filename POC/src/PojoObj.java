import java.util.List;

public class PojoObj {
	
	String fieldString;
	
	List<String> list;
	
	public PojoObj(String fieldString,List<String> list) {
		this.fieldString=fieldString;
		this.list = list;
}

	/**
	 * @return the fieldString
	 */
	public String getFieldString() {
		return fieldString;
	}

	/**
	 * @return the list
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * @param fieldString the fieldString to set
	 */
	public void setFieldString(String fieldString) {
		this.fieldString = fieldString;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<String> list) {
		this.list = list;
	}

}
