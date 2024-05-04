package ru.test.financyandrey.categories_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.test.financyandrey.categories_screen.data.db.model.ColorCategory
import ru.test.financyandrey.categories_screen.ui.viewmodel.CategoriesScreenViewModel

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(
    categoriesScreenViewModel: CategoriesScreenViewModel = viewModel()
) {
    val state = categoriesScreenViewModel.state
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Добавление операции"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        },
        bottomBar = {
            Box(modifier = Modifier.padding(16.dp)){
                Button(onClick = {
                    categoriesScreenViewModel.addCategory()
                },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "ДОбавить")
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(16.dp),
        ) {
            OutlinedTextField(value = state.sum, onValueChange = categoriesScreenViewModel::inputSum)
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Счет",
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outlineVariant)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Не задан",
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Категории",
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outlineVariant)
            )
            Spacer(modifier = Modifier.size(16.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                state.categories.forEach { category ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(
                                color = if (state.selectCategories == category)
                                    MaterialTheme.colorScheme.secondary else Color.Transparent
                            )
                            .clickable {
                                categoriesScreenViewModel.selectedCategorie(category)
                            }
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(category.color.color(), CircleShape)
                        )
                        Text(text = category.name)
                    }
                }
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.primary, CircleShape)
                        .clickable {  }
                ){
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                }
            }
        }
    }
}

fun ColorCategory.color() = when(this){
    ColorCategory.Orange -> Color.Yellow
    ColorCategory.Red -> Color.Red
    ColorCategory.Green -> Color.Green
}