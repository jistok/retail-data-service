package io.pivotal.retail.dao;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.retail.domain.RetailEvent;

public interface RetailEventRepository extends CrudRepository<RetailEvent, Long> {

}
