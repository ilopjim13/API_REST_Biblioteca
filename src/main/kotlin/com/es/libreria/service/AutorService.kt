package com.es.libreria.service

import com.es.libreria.model.Autor
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

}