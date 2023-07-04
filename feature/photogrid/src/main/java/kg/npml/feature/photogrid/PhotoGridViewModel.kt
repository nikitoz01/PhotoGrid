package kg.npml.feature.photogrid

import androidx.lifecycle.ViewModel
import kg.npml.core.domain.GetPhotosUseCase
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class PhotoGridViewModel(
    getPhotosUseCase: GetPhotosUseCase
): ViewModel() {
    init {
        getPhotosUseCase()
    }
}