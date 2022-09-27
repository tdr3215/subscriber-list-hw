package com.techtalentsouth.SubscriberList;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber,Long>{

	Subscriber findByUserName(String userName);
}
