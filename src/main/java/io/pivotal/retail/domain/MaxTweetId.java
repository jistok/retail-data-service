package io.pivotal.retail.domain;

import java.io.Serializable;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.ClientRegion;

@ClientRegion(name = "MaxTweetId", shortcut = ClientRegionShortcut.CACHING_PROXY)
public class MaxTweetId implements Serializable {

	@Id
	private String userName;
	private Long maxTweetId;
	
	private static final long serialVersionUID = 2889380026043978427L;
	
	public MaxTweetId() {
		super();
	}

	public MaxTweetId(String userName) {
		super();
		this.userName = userName;
		this.maxTweetId = -1L;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getMaxTweetId() {
		return maxTweetId;
	}

	public void setMaxTweetId(Long maxTweetId) {
		this.maxTweetId = maxTweetId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxTweetId == null) ? 0 : maxTweetId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		MaxTweetId other = (MaxTweetId) obj;
		if (maxTweetId == null) {
			if (other.maxTweetId != null)
				return false;
		} else if (!maxTweetId.equals(other.maxTweetId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MaxTweetId [userName=" + userName + ", maxTweetId=" + maxTweetId + "]";
	}

}
