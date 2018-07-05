package io.pivotal.retail.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.pivotal.retail.dao.MaxTweetIdRepository;
import io.pivotal.retail.domain.MaxTweetId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tweetInfo")
public class MaxTweetIdController {

	private MaxTweetIdRepository repo;
	private Logger logger = LoggerFactory.getLogger(MaxTweetIdController.class);

	@Autowired
	public MaxTweetIdController(MaxTweetIdRepository repo) {
		this.repo = repo;
	}

	// Set the max. tweet ID for a given user
	@RequestMapping(method = RequestMethod.PUT, value = "/{userName}")
	public void setMaxTweetId(@PathVariable String userName, @RequestBody Long value) {
		MaxTweetId maxTweetId = getMaxTweetId(userName);
		maxTweetId.setMaxTweetId(value);
		repo.save(maxTweetId); // SAVE THAT VALUE
	}

	// Get the max. tweet ID for a given user
	@RequestMapping(method = RequestMethod.GET, value = "/{userName}/maxTweetId")
	public Long getMaxTweetIdForUser(@PathVariable String userName) {
		MaxTweetId maxTweetId = getMaxTweetId(userName);
		return maxTweetId.getMaxTweetId();
	}

	// Get all { userID => maxTweetId } values
	@RequestMapping(value = "/maxTweetIds")
	public List<Map<String, Long>> getAllMaxTweetIds() {
		List<Map<String, Long>> rv = new ArrayList<>();
		for (MaxTweetId maxTweetId : repo.findAll()) {
			Map<String, Long> map = new HashMap<>();
			map.put(maxTweetId.getUserName(), maxTweetId.getMaxTweetId());
			rv.add(map);
		}
		return rv;
	}

	// Delete the data for the given user name (screen name)
	@RequestMapping(method = RequestMethod.DELETE, value = "/{userName}")
	public void deleteByTweetId(@PathVariable String userName) {
		repo.deleteById(userName);
	}

	private MaxTweetId getMaxTweetId(String userName) {
		Optional<MaxTweetId> item = repo.findById(userName);
		MaxTweetId maxTweetId = null;
		if (item.isPresent()) {
			maxTweetId = item.get();
			logger.info("Found MaxTweetId: " + maxTweetId);
		} else {
			maxTweetId = new MaxTweetId(userName);
			logger.info("MaxTweetId not found for userName: " + userName);
		}
		return maxTweetId;
	}
}
