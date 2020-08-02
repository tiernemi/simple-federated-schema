package com.federation.spike.servicea

import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@KeyDirective(fields = FieldSet("primaryKey"))
data class ObjectAModel(val primaryKey: Int, val resolvedField: String)
