package io.pivotal.retail.dao;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.retail.domain.MaxTweetId;

public interface MaxTweetIdRepository extends CrudRepository<MaxTweetId, String> {

}
