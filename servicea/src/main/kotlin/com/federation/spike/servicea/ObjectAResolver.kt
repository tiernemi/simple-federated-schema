package com.federation.spike.servicea

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class ObjectAQuery : Query {
    @GraphQLDescription("Fetches a new object for a given primary key")
    fun objectA(): ObjectAModel? = ObjectAModel(1, "I'm resolved by service A")
}

