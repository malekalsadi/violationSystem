package Objects;

import java.util.Objects;

public class city {
	private String cityName;
	private int id;
	private int littering;
	private int stop_sign;
	private int red_light;
	private int jaywalking;
	public city(){
		
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        city marks_db = (city) o;
        return Objects.equals(cityName, marks_db.getCityName()) && (id == marks_db.getId());
    }
	public int getLittering() {
		return littering;
	}
	public void setLittering(int littering) {
		this.littering = littering;
	}
	public int getStop_sign() {
		return stop_sign;
	}
	public void setStop_sign(int stop_sign) {
		this.stop_sign = stop_sign;
	}
	public int getRed_light() {
		return red_light;
	}
	public void setRed_light(int red_light) {
		this.red_light = red_light;
	}
	public int getJaywalking() {
		return jaywalking;
	}
	public void setJaywalking(int jaywalking) {
		this.jaywalking = jaywalking;
	}
	
}
