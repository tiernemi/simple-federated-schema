package com.federation.spike.serviceA

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServiceA

fun main(args: Array<String>) {
	runApplication<ServiceA>(*args)
}
