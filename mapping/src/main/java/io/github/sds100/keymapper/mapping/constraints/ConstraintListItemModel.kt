package io.github.sds100.keymapper.mapping.constraints

import io.github.sds100.keymapper.base.util.ui.compose.ComposeIconInfo

data class ConstraintListItemModel(
    val id: String,
    val icon: ComposeIconInfo,
    /**
     * Null if no link should be shown between the items.
     */
    val constraintModeLink: io.github.sds100.keymapper.mapping.constraints.ConstraintMode?,
    val text: String,
    val error: String? = null,
    val isErrorFixable: Boolean = true,
)
