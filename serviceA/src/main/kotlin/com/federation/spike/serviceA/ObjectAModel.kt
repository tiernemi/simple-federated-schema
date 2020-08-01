package com.federation.spike.serviceA

import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@KeyDirective(fields = FieldSet("primaryKey"))
data class ObjectAModel(val primaryKey: Int, val resolvedField: String)
