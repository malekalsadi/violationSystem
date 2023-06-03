package Objects;

public class violation {
	private int vioId;
	private String phone;
	private int countryId;
	private String city;
	private String media;
	private String vioType;
	private String date;
	public violation(){
		
	}
	public violation(int vioId, String phone, int countryId, String city, String media, String vioType,String date) {
		setVioId(vioId);
		setPhone(phone);
		setCountryId(countryId);
		setCity(city);
		setMedia(media);
		setVioType(vioType);
		setDate(date);
	}
	
	public String getVioType() {
		return vioType;
	}
	public void setVioType(String vioType) {
		this.vioType = vioType;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getVioId() {
		return vioId;
	}
	public void setVioId(int vioId) {
		this.vioId = vioId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
