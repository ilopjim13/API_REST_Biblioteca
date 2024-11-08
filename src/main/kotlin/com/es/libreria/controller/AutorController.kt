package com.es.libreria.controller

import com.es.libreria.model.Autor
import com.es.libreria.model.Libro
import com.es.libreria.service.AutorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/autores")
class AutorController {

    @Autowired
    private lateinit var autorService: AutorService

    @GetMapping("/{id}") // URI de este metodo --> localhost:8080/autores/
    fun getById(
        @PathVariable
        id:String?
    ): Autor? {
        if (id.isNullOrBlank()) return null

        return autorService.getById(id)
    }

    @GetMapping("/")
    fun getAll(): MutableList<Autor>? {
        return autorService.getAll()
    }

    @PostMapping("/")
    fun createNewAutor(
        @RequestBody autor:Autor
    ): Autor? {
        return autorService.createNewAutor(autor)
    }

    @PutMapping("/{id}")
    fun updateAutor(
        @PathVariable id: String?,
        @RequestBody autor: Autor
    ): Autor? {
        if (id.isNullOrBlank()) return null

        return autorService.updateAutor(id, autor)
    }

    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable
        id:String?
    ): String? {
        if (id.isNullOrBlank()) return null

        return if (autorService.deleteById(id)) "Se ha eliminado correctamente"
        else "No se ha podio eliminar el autor"
    }

    @GetMapping("/{id}/libros")
    fun getLibrosAutor(
        @PathVariable id:String?
    ): MutableList<Libro>? {
        if (id.isNullOrBlank()) return null
        return autorService.getLibrosAutor(id)
    }

}