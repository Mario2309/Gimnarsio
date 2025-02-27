package es.etg.dam.pmdm13.gym

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import es.etg.dam.pmdm13.gym.data.local.preferences.EjecutarPreferencias
import es.etg.dam.pmdm13.gym.data.repository.PreferenciaRepositoryImpl
import es.etg.dam.pmdm13.gym.domain.repository.PreferenciasRepository
import es.etg.dam.pmdm13.gym.domain.usecase.ActualizarPreferenciaUseCase
import es.etg.dam.pmdm13.gym.domain.usecase.ObtenerPreferenciaUseCase
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePreferencias(context: Context): EjecutarPreferencias {
        return EjecutarPreferencias(context)
    }

    @Provides
    @Singleton
    fun providePreferenciasRepository(preferencias: EjecutarPreferencias): PreferenciasRepository {
        return PreferenciaRepositoryImpl(preferencias)
    }

    @Provides
    fun provideObtenerPreferenciasUseCase(repository: PreferenciasRepository): ObtenerPreferenciaUseCase {
        return ObtenerPreferenciaUseCase(repository)
    }

    @Provides
    fun provideActualizarPreferenciasUseCase(repository: PreferenciasRepository): ActualizarPreferenciaUseCase {
        return ActualizarPreferenciaUseCase(repository)
    }
}
