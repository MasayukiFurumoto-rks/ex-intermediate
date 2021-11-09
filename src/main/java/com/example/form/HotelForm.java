package com.example.form;

import javax.validation.constraints.Pattern;


/**
 * hotel-search.htmlからデータを受け取り、エラーチェックを行うためのフォームクラスです。<br>
 * @author cyjoh
 *
 */
public class HotelForm {
	private String id;
	
	private String areaName;
	
	private String hotelName;
	
	private String address;
	
	private String nearestStation;
	
	/**
	 * 価格を表すフィールド変数。
	 * 入力文字が半角数字全角数字のみになるよう入力エラーチェック。
	 * また、0~300000の範囲内の数値になるよう入力エラーチェック。
	 * 
	 */
	@Pattern(regexp="^$|^[0-9]|[1-9][0-9]{1,4}|[1-2][0-9]{5}|300000$",message="価格は0円以上30万円以下の数字で入力してください")
	private String price;
	
	private String parking;

	public Integer getIntPrice() {
		return Integer.parseInt(price);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", address=" + address
				+ ", nearestStation=" + nearestStation + ", price=" + price + ", parking=" + parking + "]";
	}

}
