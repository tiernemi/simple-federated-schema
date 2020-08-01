package com.federation.spike.serviceB

import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ServiceB {
	@Bean
	fun federatedTypeRegistry(): FederatedTypeRegistry {
		return FederatedTypeRegistry(mapOf("ObjectAModel" to objectAResolver))
	}
}

fun main(args: Array<String>) {
	runApplication<ServiceB>(*args)
}
