package de.akquinet.playground.optionalvalues

fun readFloatParamK(name: String, params: Map<String, Set<String>>): Float? =
        params[name]
                ?.run { if (size != 1) null else this }
                ?.first()
                ?.toFloatOrNull()