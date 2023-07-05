package kg.npml.core.data.mapper

import kg.npml.core.common.model.Photo
import kg.npml.core.common.model.Source
import kg.npml.core.photonetwork.model.PhotoDto
import kg.npml.core.photonetwork.model.SourceDto

fun PhotoDto.toEntryPhoto(): Photo = Photo(id, sourceDto.toEntrySource())

fun SourceDto.toEntrySource(): Source = Source(original, medium, portrait)