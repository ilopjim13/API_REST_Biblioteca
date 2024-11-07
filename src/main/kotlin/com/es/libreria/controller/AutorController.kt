package com.es.libreria.controller

import com.es.libreria.model.Autor
import com.es.libreria.service.AutorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}