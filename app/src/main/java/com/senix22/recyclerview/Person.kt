package com.senix22.recyclerview

class Person(var name: String, var age: Int, var mom: Person?, var dad: Person?) {
    override fun toString(): String {
        return "$name \n $age"
    }
}

fun getListOfRelatives(person: Person): List<Person> {
    val dadList = person.dad?.let { getListOfRelatives(it) } ?: emptyList()
    val momList = person.mom?.let { getListOfRelatives(it) } ?: emptyList()


    return listOf(person, *dadList.toTypedArray(), *momList.toTypedArray())
}


