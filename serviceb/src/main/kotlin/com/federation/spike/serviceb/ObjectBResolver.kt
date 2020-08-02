package com.federation.spike.serviceb

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class ObjectBResolver : Query {
    @GraphQLDescription("Fetches a new object for a given primary key")
    fun objectB(): ObjectBModel? = ObjectBModel("I'm resolved by Service B")
}
