package kg.npml.feature.photogrid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kg.npml.core.common.FakePhotoCategories
import kg.npml.core.common.model.Photo
import kg.npml.core.domain.GetPhotosUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

/**
 * Вьюмодель
 */
@KoinViewModel
class PhotoGridViewModel(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {


    private val _photoUiState = MutableStateFlow(PhotoUiState(false))
    val photoUiState = _photoUiState.asStateFlow()

    private var currentCategory: String = ""
    fun getPagingPhoto(): Flow<PagingData<Photo>> {
        if (currentCategory.isBlank()) currentCategory = FakePhotoCategories.photos.random()
        _photoUiState.tryEmit(_photoUiState.value.copy(isRefreshing = false))
        return getPhotosUseCase(currentCategory).cachedIn(viewModelScope)
    }

    fun refresh() {
        viewModelScope.launch {
            _photoUiState.emit(_photoUiState.value.copy(isRefreshing = true))
            currentCategory = FakePhotoCategories.photos.random()
        }
    }

}


data class PhotoUiState(val isRefreshing: Boolean)

