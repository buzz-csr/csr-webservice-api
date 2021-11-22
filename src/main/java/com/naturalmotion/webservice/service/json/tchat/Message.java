package com.naturalmotion.webservice.service.json.tchat;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.naturalmotion.webservice.service.MessageDeserializer;

@JsonDeserialize(using = MessageDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	private String id;

	private String zid;

	private String text;

	private Date creationTime;

	private Metadata meta;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Metadata getMeta() {
		return meta;
	}

	public void setMeta(Metadata meta) {
		this.meta = meta;
	}

	public String getZid() {
		return zid;
	}

	public void setZid(String zid) {
		this.zid = zid;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
