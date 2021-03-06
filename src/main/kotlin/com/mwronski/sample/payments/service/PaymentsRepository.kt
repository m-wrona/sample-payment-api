package com.mwronski.sample.payments.service

import com.mwronski.sample.payments.model.Data
import com.mwronski.sample.payments.model.DataId
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * Payments data access
 *
 * TODO: make it inner/package visible only when real service with real payments logic is there
 */
@Repository
interface PaymentsRepository : ReactiveMongoRepository<Data, DataId>