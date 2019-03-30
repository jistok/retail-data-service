package io.pivotal.retail.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.pivotal.retail.domain.RetailEvent;

public interface RetailEventRepository extends CrudRepository<RetailEvent, Long> {

	@Query(value = "SELECT * FROM retail_event r WHERE r.screen_name = ?1 ORDER BY r.created_at DESC LIMIT ?2", nativeQuery = true)
	List<RetailEvent> findByScreenName(String screenName, int limit);

}
