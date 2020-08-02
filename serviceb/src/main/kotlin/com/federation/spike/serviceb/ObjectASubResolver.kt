package com.federation.spike.serviceb

import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import graphql.schema.DataFetchingEnvironment

@ExtendsDirective
@KeyDirective(fields = FieldSet("primaryKey"))
class ObjectAModel(@property:ExternalDirective val primaryKey: Int) {
    fun subResolvedField() = "I am resolved by Service B"
}


val objectAResolver = object : FederatedTypeResolver<ObjectAModel> {
    override suspend fun resolve(environment: DataFetchingEnvironment, representations: List<Map<String, Any>>): List<ObjectAModel?> = representations.map { keys ->
        keys["primaryKey"]?.toString()?.toIntOrNull()?.let { primaryKey ->
            ObjectAModel(primaryKey)
        }
    }
}

