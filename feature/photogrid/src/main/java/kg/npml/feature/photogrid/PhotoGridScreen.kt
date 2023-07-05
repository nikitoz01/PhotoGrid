package kg.npml.feature.photogrid

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kg.npml.core.common.model.Photo
import org.koin.androidx.compose.koinViewModel

@Composable
fun PhotoGridScreen(
    viewModel: PhotoGridViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val photoUiState by viewModel.photoUiState.collectAsStateWithLifecycle()

    val pagingPhotos = viewModel.getPagingPhoto().collectAsLazyPagingItems()

    PhotoGrid(
        photoUiState,
        viewModel::refresh,
        pagingPhotos,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoGrid(
    photoUiState: PhotoUiState,
    refresh: () -> Unit,
    pagingPhotos: LazyPagingItems<Photo>,
    modifier: Modifier = Modifier
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(photoUiState.isRefreshing),
        onRefresh = {
            refresh()
            pagingPhotos.refresh()
                    },
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 8.dp
            )
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(160.dp),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(pagingPhotos.itemCount) { index ->
                    SubcomposeAsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(pagingPhotos[index]?.source?.medium)
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        loading = {
                            LoadingPhotoPlaceholder()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                }
            }
            PagingStateIndicator(pagingPhotos)
        }
    }
}

@Composable
fun PagingStateIndicator(
    pagingPhotos: LazyPagingItems<Photo>,
    modifier: Modifier = Modifier
){
    when (val state = pagingPhotos.loadState.refresh) {
        is LoadState.Error -> {
            Toast
                .makeText(
                    LocalContext.current,
                    stringResource(kg.npml.core.common.R.string.try_again),
                    Toast.LENGTH_SHORT
                )
                .show()
        }

        is LoadState.Loading -> {
            LoadingIndicator(
                Modifier.fillMaxSize()
            )
        }

        else -> {}
    }

    when (val state = pagingPhotos.loadState.append) {
        is LoadState.Error -> {
            Toast
                .makeText(
                    LocalContext.current,
                    stringResource(kg.npml.core.common.R.string.try_again),
                    Toast.LENGTH_SHORT
                )
                .show()
        }

        is LoadState.Loading -> {
            LoadingIndicator(
                Modifier.fillMaxWidth()
            )
        }

        else -> {}
    }

}

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(color = Color.Black)
    }
}

@Composable
fun LoadingPhotoPlaceholder(modifier: Modifier = Modifier){
    Box (
        modifier = Modifier.defaultMinSize(minHeight = 256.dp),
        contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.2f)
        )
    }
}