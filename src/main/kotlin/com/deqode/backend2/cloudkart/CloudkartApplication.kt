package com.deqode.backend2.cloudkart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EnableMongoRepositories
class CloudkartApplication

fun main(args: Array<String>) {
	runApplication<CloudkartApplication>(*args)
}
