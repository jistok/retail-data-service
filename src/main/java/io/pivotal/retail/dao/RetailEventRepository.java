package io.pivotal.retail.dao;

import java.util.List;

import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.pivotal.retail.domain.RetailEvent;

public interface RetailEventRepository extends CrudRepository<RetailEvent, Long> {

	@Query("select * from /RetailEvent r where r.screenName = $1 order by r.createdAt desc limit $2 ")
	List<RetailEvent> findByScreenName(String screenName, int limit);
	
}
