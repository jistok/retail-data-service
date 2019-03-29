package io.pivotal.retail.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.pivotal.retail.domain.RetailEvent;

public interface RetailEventRepository extends CrudRepository<RetailEvent, Long> {

	@Query("SELECT * FROM RetailEvent r WHERE r.screenName = $1 ORDER BY r.createdAt DESC LIMIT $2 ")
	List<RetailEvent> findByScreenName(String screenName, int limit);
	
}
