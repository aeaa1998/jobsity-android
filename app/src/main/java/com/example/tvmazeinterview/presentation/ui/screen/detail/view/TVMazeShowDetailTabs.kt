package com.example.tvmazeinterview.presentation.ui.screen.detail.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.presentation.ui.screen.detail.model.TVMazeShowDetailTab
import com.example.tvmazeinterview.presentation.ui.theme.paddings

@Composable
fun TVMazeShowDetailTabs(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(
        selectedTabIndex = selectedIndex,
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
    ) {
        TVMazeShowDetailTab.values().forEachIndexed { index, tab ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onTabSelected(index) }
            ) {
                Text(
                    text = tab.text.text,
                    modifier = Modifier.padding(vertical = MaterialTheme.paddings.medium)
                )
            }
        }
    }

}