package com.mhss.app.mybrain.presentation.settings

sealed class SettingsEvent {
    data class ImportData(val fileUri: String, val encrypted: Boolean, val password: String): SettingsEvent()
    data class ExportData(val directoryUri: String, val encrypted: Boolean, val password: String): SettingsEvent()
}