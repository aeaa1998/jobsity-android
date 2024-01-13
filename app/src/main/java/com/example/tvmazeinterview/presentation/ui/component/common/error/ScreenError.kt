package com.example.tvmazeinterview.presentation.ui.component.common.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.ui.theme.paddings

@Composable
fun ScreenError(
    title: UIText = UIText.Resource(R.string.error_default_title),
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.paddings.medium)
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Close,
            contentDescription = "Error icon",
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(48.dp)
        )
        Text(
            text = title.text,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onErrorContainer
        )


        //On retry was defined so lets render the retry button
        if (onRetry != null){
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.defaultMinSize(minWidth = 120.dp),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.error,
                )
            ) {
                Text(
                    text = stringResource(id = R.string.retry),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    ScreenError(){}
}
