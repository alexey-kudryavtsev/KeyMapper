package io.github.sds100.keymapper.keymaps

import android.content.Context
import android.os.Build
import io.github.sds100.keymapper.data.Keys
import io.github.sds100.keymapper.data.repositories.PreferenceRepository
import io.github.sds100.keymapper.util.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FingerprintGesturesSupportedUseCaseImpl @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
    private val settingsRepository: SettingsRepository
) : FingerprintGesturesSupportedUseCase {
    override val isSupported: Flow<Boolean?> =
        preferenceRepository.get(Keys.fingerprintGesturesAvailable).map {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return@map false

            it
        }

    override fun setSupported(supported: Boolean) {
        preferenceRepository.set(Keys.fingerprintGesturesAvailable, supported)
    }
}

interface FingerprintGesturesSupportedUseCase {
    /**
     * Is null if support is unknown
     */
    val isSupported: Flow<Boolean?>

    fun setSupported(supported: Boolean)
}
