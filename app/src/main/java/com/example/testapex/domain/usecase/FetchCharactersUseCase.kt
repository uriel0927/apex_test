package com.example.testapex.domain.usecase

import com.example.testapex.domain.model.CharacterModel
import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.ResultValue
import com.example.testapex.domain.model.RootError
import com.example.testapex.domain.repository.CharactersRepository
import javax.inject.Inject

/**
 * Use case responsible for fetching the characters.
 * @param repository The repository interface for characters data.
 */
class FetchCharactersUseCase @Inject constructor(private  val repository: CharactersRepository) {

    suspend operator fun invoke() : ResultValue<List<CharacterModel>,DataError>{
        return repository.fetchCharacters()
    }

}