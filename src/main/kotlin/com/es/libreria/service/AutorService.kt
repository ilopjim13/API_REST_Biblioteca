package com.es.libreria.service

import com.es.libreria.model.Autor
import com.es.libreria.model.Libro
import com.es.libreria.repository.AutorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AutorService {

    @Autowired
    private lateinit var autorRepository: AutorRepository

    fun getById(id:String): Autor? {
        val idLong = id.toLongOrNull() ?: -1
        return if(idLong > 0) autorRepository.findByIdOrNull(idLong)
        else null
    }

    fun getAll(): MutableList<Autor>? {
        return autorRepository.findAll()
    }

    fun createNewAutor(autor:Autor): Autor? {
        return autorRepository.save(autor)
    }

    fun updateAutor(id:String, autor: Autor):Autor? {
        val idLong = id.toLongOrNull() ?: -1
        return if(idLong > 0) {
            val autorActualizar = autorRepository.findByIdOrNull(idLong)
            if (autorActualizar != null) autorRepository.save(autor)
            else null
        }
        else null
    }
    fun deleteById(id:String): Boolean {
        val idLong = id.toLongOrNull() ?: -1
        return if(idLong > 0) {
            autorRepository.deleteById(idLong)
            return true
        }
        else false
    }

    fun getLibrosAutor(id:String) :MutableList<Libro>? {
        val idLong = id.toLongOrNull() ?: -1
        return if(idLong > 0) {
            val autor = autorRepository.findByIdOrNull(idLong)
            autor?.libros
        }
        else null
    }


}