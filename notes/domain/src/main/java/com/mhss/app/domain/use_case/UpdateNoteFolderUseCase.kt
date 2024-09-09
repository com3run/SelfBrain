package com.mhss.app.domain.use_case

import com.mhss.app.domain.model.NoteFolder
import com.mhss.app.domain.repository.NoteRepository
import org.koin.core.annotation.Single

@Single
class UpdateNoteFolderUseCase(
private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(folder: NoteFolder) = noteRepository.updateNoteFolder(folder)
}