package com.example.tvmazeinterview.presentation.state.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.presentation.composition.LocalAppBarState

data class AppBarAction(val icon: ImageVector, val action: () -> Unit)

class AppBarState(
    private val _title: MutableState<UIText> = mutableStateOf<UIText>(UIText.Resource(R.string.app_name)),
    private val _actions: SnapshotStateList<AppBarAction> = mutableStateListOf<AppBarAction>()
) {

    val title: State<UIText>
        get() = _title

    val actions: List<AppBarAction>
        get() = _actions

    fun addAction(vararg actions: AppBarAction){
        this._actions.addAll(actions)
    }

    fun setTitle(title: UIText){
        this._title.value = title
    }

    fun reset(){
        this._title.value = UIText.Raw("")
        this._actions.clear()
    }
}

@Composable
fun rememberAppBarState(
    title: UIText,
    actions: List<AppBarAction>
) : AppBarState{
    return remember {
        AppBarState(mutableStateOf(title), mutableStateListOf<AppBarAction>().apply {
            addAll(actions)
        })
    }
}


/**
 * Provide a composable to interact in an easier way with the app bar state
 * @param transform [AppBarState.() -> Unit] Function to make transformations on the appbar state
 */
@Composable
fun AppBarStateLaunchedEffect(
    transform: AppBarState.() -> Unit
) {
    val appBar = LocalAppBarState.current
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                transform(appBar)
            } else if (event == Lifecycle.Event.ON_STOP) {
                appBar.reset()
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

}