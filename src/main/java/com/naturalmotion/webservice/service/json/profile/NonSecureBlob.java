package com.naturalmotion.webservice.service.json.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NonSecureBlob {

	private String blob;
	private int version_number;
	private String player_name;
	private String gamecenter_id;
	private String facebook_id;
	private String facebook_access_token;
	private int facebook_access_token_expiration;
	private int preferred_avatar_type;
	private int avatar_index;
	private int garage_value;
	private int license_level;
	private String player_current_car;
	private int car_paint_id;
	private int car_interior_id;
	private int car_calliper_id;
	private int car_flag_id;
	private int car_number_id;
	private int car_number_shape_color_id;
	private int car_number_color_id;
	private int car_number_zone_id;
	private int car_numberplate_style_id;
	private int car_crewname_state;
	private int car_playername_state;
	private int car_numberZone_id;
	private int car_liveryZonesSet_id;
	private int car_am_milestone_level;
	private int car_livery_id;
	private String car_wheel_name;
	private String license_plate_text;
	private int rarity;
	private boolean is_super_rare;
	private int car_pp;
	private int car_ep;
	private int car_elite_level;
	private String car_source;
	private CarGachConfig car_gacha_config;
	private int car_milestone_level;
	private TunerCustomSetup tuner_customisation_setup;
	private int player_rp;

	public int getVersion_number() {
		return version_number;
	}

	public void setVersion_number(int version_number) {
		this.version_number = version_number;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public String getGamecenter_id() {
		return gamecenter_id;
	}

	public void setGamecenter_id(String gamecenter_id) {
		this.gamecenter_id = gamecenter_id;
	}

	public String getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(String facebook_id) {
		this.facebook_id = facebook_id;
	}

	public String getFacebook_access_token() {
		return facebook_access_token;
	}

	public void setFacebook_access_token(String facebook_access_token) {
		this.facebook_access_token = facebook_access_token;
	}

	public int getFacebook_access_token_expiration() {
		return facebook_access_token_expiration;
	}

	public void setFacebook_access_token_expiration(int facebook_access_token_expiration) {
		this.facebook_access_token_expiration = facebook_access_token_expiration;
	}

	public int getPreferred_avatar_type() {
		return preferred_avatar_type;
	}

	public void setPreferred_avatar_type(int preferred_avatar_type) {
		this.preferred_avatar_type = preferred_avatar_type;
	}

	public int getAvatar_index() {
		return avatar_index;
	}

	public void setAvatar_index(int avatar_index) {
		this.avatar_index = avatar_index;
	}

	public int getGarage_value() {
		return garage_value;
	}

	public void setGarage_value(int garage_value) {
		this.garage_value = garage_value;
	}

	public int getLicense_level() {
		return license_level;
	}

	public void setLicense_level(int license_level) {
		this.license_level = license_level;
	}

	public String getPlayer_current_car() {
		return player_current_car;
	}

	public void setPlayer_current_car(String player_current_car) {
		this.player_current_car = player_current_car;
	}

	public int getCar_paint_id() {
		return car_paint_id;
	}

	public void setCar_paint_id(int car_paint_id) {
		this.car_paint_id = car_paint_id;
	}

	public int getCar_interior_id() {
		return car_interior_id;
	}

	public void setCar_interior_id(int car_interior_id) {
		this.car_interior_id = car_interior_id;
	}

	public int getCar_calliper_id() {
		return car_calliper_id;
	}

	public void setCar_calliper_id(int car_calliper_id) {
		this.car_calliper_id = car_calliper_id;
	}

	public int getCar_flag_id() {
		return car_flag_id;
	}

	public void setCar_flag_id(int car_flag_id) {
		this.car_flag_id = car_flag_id;
	}

	public int getCar_number_id() {
		return car_number_id;
	}

	public void setCar_number_id(int car_number_id) {
		this.car_number_id = car_number_id;
	}

	public int getCar_number_shape_color_id() {
		return car_number_shape_color_id;
	}

	public void setCar_number_shape_color_id(int car_number_shape_color_id) {
		this.car_number_shape_color_id = car_number_shape_color_id;
	}

	public int getCar_number_color_id() {
		return car_number_color_id;
	}

	public void setCar_number_color_id(int car_number_color_id) {
		this.car_number_color_id = car_number_color_id;
	}

	public int getCar_number_zone_id() {
		return car_number_zone_id;
	}

	public void setCar_number_zone_id(int car_number_zone_id) {
		this.car_number_zone_id = car_number_zone_id;
	}

	public int getCar_numberplate_style_id() {
		return car_numberplate_style_id;
	}

	public void setCar_numberplate_style_id(int car_numberplate_style_id) {
		this.car_numberplate_style_id = car_numberplate_style_id;
	}

	public int getCar_crewname_state() {
		return car_crewname_state;
	}

	public void setCar_crewname_state(int car_crewname_state) {
		this.car_crewname_state = car_crewname_state;
	}

	public int getCar_playername_state() {
		return car_playername_state;
	}

	public void setCar_playername_state(int car_playername_state) {
		this.car_playername_state = car_playername_state;
	}

	public int getCar_numberZone_id() {
		return car_numberZone_id;
	}

	public void setCar_numberZone_id(int car_numberZone_id) {
		this.car_numberZone_id = car_numberZone_id;
	}

	public int getCar_liveryZonesSet_id() {
		return car_liveryZonesSet_id;
	}

	public void setCar_liveryZonesSet_id(int car_liveryZonesSet_id) {
		this.car_liveryZonesSet_id = car_liveryZonesSet_id;
	}

	public int getCar_am_milestone_level() {
		return car_am_milestone_level;
	}

	public void setCar_am_milestone_level(int car_am_milestone_level) {
		this.car_am_milestone_level = car_am_milestone_level;
	}

	public int getCar_livery_id() {
		return car_livery_id;
	}

	public void setCar_livery_id(int car_livery_id) {
		this.car_livery_id = car_livery_id;
	}

	public String getCar_wheel_name() {
		return car_wheel_name;
	}

	public void setCar_wheel_name(String car_wheel_name) {
		this.car_wheel_name = car_wheel_name;
	}

	public String getLicense_plate_text() {
		return license_plate_text;
	}

	public void setLicense_plate_text(String license_plate_text) {
		this.license_plate_text = license_plate_text;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public boolean getIs_super_rare() {
		return is_super_rare;
	}

	public void setIs_super_rare(boolean is_super_rare) {
		this.is_super_rare = is_super_rare;
	}

	public int getCar_pp() {
		return car_pp;
	}

	public void setCar_pp(int car_pp) {
		this.car_pp = car_pp;
	}

	public int getCar_ep() {
		return car_ep;
	}

	public void setCar_ep(int car_ep) {
		this.car_ep = car_ep;
	}

	public int getCar_elite_level() {
		return car_elite_level;
	}

	public void setCar_elite_level(int car_elite_level) {
		this.car_elite_level = car_elite_level;
	}

	public String getCar_source() {
		return car_source;
	}

	public void setCar_source(String car_source) {
		this.car_source = car_source;
	}

	public CarGachConfig getCar_gacha_config() {
		return car_gacha_config;
	}

	public void setCar_gacha_config(CarGachConfig car_gacha_config) {
		this.car_gacha_config = car_gacha_config;
	}

	public int getCar_milestone_level() {
		return car_milestone_level;
	}

	public void setCar_milestone_level(int car_milestone_level) {
		this.car_milestone_level = car_milestone_level;
	}

	public TunerCustomSetup getTuner_customisation_setup() {
		return tuner_customisation_setup;
	}

	public void setTuner_customisation_setup(TunerCustomSetup tuner_customisation_setup) {
		this.tuner_customisation_setup = tuner_customisation_setup;
	}

	public int getPlayer_rp() {
		return player_rp;
	}

	public void setPlayer_rp(int player_rp) {
		this.player_rp = player_rp;
	}

	public String getBlob() {
		return blob;
	}

	public void setBlob(String blob) {
		this.blob = blob;
	}

}
