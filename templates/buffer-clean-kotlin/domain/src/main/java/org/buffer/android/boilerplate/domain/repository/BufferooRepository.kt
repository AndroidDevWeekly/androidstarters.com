package <%= appPackage %>.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import <%= appPackage %>.domain.model.Bufferoo

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain alyer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface BufferooRepository {

    fun clearBufferoos(): Completable

    fun saveBufferoos(bufferoos: List<Bufferoo>): Completable

    fun getBufferoos(): Single<List<Bufferoo>>

}