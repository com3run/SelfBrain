package com.mhss.app.mybrain.domain.use_case.settings

import com.mhss.app.mybrain.domain.model.preferences.PrefsKey
import com.mhss.app.mybrain.domain.repository.preferences.PreferenceRepository
import org.koin.core.annotation.Single

@Single
class SavePreferenceUseCase(
  private val preferenceRepository: PreferenceRepository
) {
    suspend operator fun <T> invoke(key: PrefsKey<T>, value: T) = preferenceRepository.savePreference(key, value)
}