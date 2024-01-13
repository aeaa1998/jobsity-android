package com.example.tvmazeinterview.presentation.state.pagination

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class PaginationState<Item>(
    private val initialPage: Int
) {
    private val _items: SnapshotStateList<Item> = mutableStateListOf<Item>()
    private var _page: Int = initialPage

    val items: List<Item>
        get() = _items
    val page: Int
        get() = _page

    val nextPage: Int
        get() = _page + 1


    fun resetPagination() {
        _page = initialPage
        _items.clear()
    }
}