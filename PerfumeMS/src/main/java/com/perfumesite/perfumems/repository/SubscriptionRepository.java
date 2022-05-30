package com.perfumesite.perfumems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perfumesite.perfumems.entity.CompKey;
import com.perfumesite.perfumems.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,CompKey>
{

}
