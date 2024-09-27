package com.example.pantallas.Screen

class persona(val nombre:String,val apellido:String,val edad:String) {
    override fun equals(other: Any?): Boolean {
        return other is persona && other.nombre == this.nombre && other.apellido == this.apellido && other.edad == this.edad
    }

    override fun hashCode(): Int {
        return 31 * nombre.hashCode() + 31 * apellido.hashCode() + 31 * edad.hashCode()
    }
}