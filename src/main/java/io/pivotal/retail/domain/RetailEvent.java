package io.pivotal.retail.domain;

import javax.persistence.Column;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RetailEvent {

	@Id
	private Long id;
	private String screenName;
	private String location;
	private Date createdAt;
	private boolean makeOffer;
	private String offerText;
	private double sentiment;
	private String text;
	private String topTerm;
	@Column(name="json", columnDefinition="TEXT")
	private String json; // Must be larger than VARCHAR(255)

	public RetailEvent() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isMakeOffer() {
		return makeOffer;
	}

	public void setMakeOffer(boolean makeOffer) {
		this.makeOffer = makeOffer;
	}

	public String getOfferText() {
		return offerText;
	}

	public void setOfferText(String offerText) {
		this.offerText = offerText;
	}

	public double getSentiment() {
		return sentiment;
	}

	public void setSentiment(double sentiment) {
		this.sentiment = sentiment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTopTerm() {
		return topTerm;
	}

	public void setTopTerm(String topTerm) {
		this.topTerm = topTerm;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + (makeOffer ? 1231 : 1237);
		result = prime * result + ((offerText == null) ? 0 : offerText.hashCode());
		result = prime * result + ((screenName == null) ? 0 : screenName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sentiment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((topTerm == null) ? 0 : topTerm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetailEvent other = (RetailEvent) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (makeOffer != other.makeOffer)
			return false;
		if (offerText == null) {
			if (other.offerText != null)
				return false;
		} else if (!offerText.equals(other.offerText))
			return false;
		if (screenName == null) {
			if (other.screenName != null)
				return false;
		} else if (!screenName.equals(other.screenName))
			return false;
		if (Double.doubleToLongBits(sentiment) != Double.doubleToLongBits(other.sentiment))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (topTerm == null) {
			if (other.topTerm != null)
				return false;
		} else if (!topTerm.equals(other.topTerm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RetailEvent [id=" + id + ", screenName=" + screenName + ", location=" + location + ", createdAt="
				+ createdAt + ", makeOffer=" + makeOffer + ", offerText=" + offerText + ", sentiment=" + sentiment
				+ ", text=" + text + ", topTerm=" + topTerm + ", json=" + json + "]";
	}

}
